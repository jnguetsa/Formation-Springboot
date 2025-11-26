## Cours JPA : **Les 3 stratégies d’héritage**
### `SINGLE_TABLE`, `JOINED`, `TABLE_PER_CLASS`
**Exemple concret : `Utilisateur` → `Etudiant`, `Surveillant`, `Administrateur`**

---

## 1. **Contexte : Hiérarchie de classes**

```java
public abstract class Utilisateur {
    private Long id;
    private String nom;
    private String email;
    // getters, setters
}

public class Etudiant extends Utilisateur {
    private String niveau;      // ex: L1, M2
    private String matricule;
}

public class Surveillant extends Utilisateur {
    private String zone;        // ex: Bâtiment A
    private LocalTime debutService;
}

public class Administrateur extends Utilisateur {
    private String departement;
    private boolean superAdmin;
}
```

> **But** : Stocker tout ça en base de données avec **JPA / Hibernate**

---

## 2. **Les 3 stratégies d’héritage JPA**

| Stratégie | Annotation | Table(s) créée(s) | Avantages | Inconvénients |
|---------|------------|-------------------|---------|---------------|
| `SINGLE_TABLE` | `@Inheritance(strategy = InheritanceType.SINGLE_TABLE)` | **1 seule table** | Requêtes simples, performant | Colonnes `NULL` partout |
| `JOINED` | `@Inheritance(strategy = InheritanceType.JOINED)` | **1 table par classe** | Normalisé, pas de NULL | Plus de `JOIN`, moins performant |
| `TABLE_PER_CLASS` | `@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)` | **1 table par classe concrète** | Simple, pas de `JOIN` | Doublon de colonnes, `POLYMORPHISM` limité |

---

## 3. **Détail avec schémas de tables**

---

### **1. `SINGLE_TABLE` → 1 table, tout dedans**

```java
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_utilisateur", discriminatorType = DiscriminatorType.STRING)
public abstract class Utilisateur { ... }
```

#### Table générée :

```sql
utilisateur
├── id (PK)
├── nom
├── email
├── type_utilisateur  (DTYPE) → 'ETUDIANT', 'SURVEILLANT', 'ADMIN'
├── niveau
├── matricule
├── zone
├── debut_service
├── departement
├── super_admin
```

> **Colonnes inutilisées = `NULL`**  
> Ex : Un `Etudiant` → `zone = NULL`, `super_admin = NULL`

#### Quand l'utiliser ?
| Situation | Oui |
|---------|-----|
| Peu de sous-classes | Oui |
| Beaucoup de requêtes **polymorphes** (`WHERE type = ...`) | Oui |
| Performance critique | Oui |
| Données souvent `NULL` acceptables | Oui |

> **Cas idéal** : Peu de différences entre types, lecture fréquente

---

### **2. `JOINED` → 1 table par classe (normalisé)**

```java
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type_utilisateur")
public abstract class Utilisateur { ... }

@Entity
@DiscriminatorValue("ETUDIANT")
public class Etudiant extends Utilisateur { ... }
```

#### Tables générées :

```sql
utilisateur
├── id (PK)
├── nom
├── email
├── type_utilisateur

etudiant
├── id (PK, FK → utilisateur.id)
├── niveau
├── matricule

surveillant
├── id (PK, FK)
├── zone
├── debut_service

administrateur
├── id (PK, FK)
├── departement
├── super_admin
```

> **Aucun `NULL`**, **normalisation parfaite**

#### Quand l'utiliser ?
| Situation | Oui |
|---------|-----|
| Base de données normalisée | Oui |
| Sous-classes très différentes | Oui |
| Intégrité référentielle importante | Oui |
| Requêtes ciblées par type | Oui |

> **Cas idéal** : Modèle riche, relations complexes, évolution future

---

### **3. `TABLE_PER_CLASS` → 1 table par classe concrète**

```java
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Utilisateur { ... }
```

#### Tables générées :

```sql
etudiant
├── id (PK)
├── nom
├── email
├── niveau
├── matricule

surveillant
├── id (PK)
├── nom
├── email
├── zone
├── debut_service

administrateur
├── id (PK)
├── nom
├── email
├── departement
├── super_admin
```

> **Pas de table `utilisateur`**, **pas de `JOIN`**

#### Quand l'utiliser ?
| Situation | Oui |
|---------|-----|
| Aucune requête polymorphe | Oui |
| Chaque type est indépendant | Oui |
| Performance d’écriture max | Oui |
| Évite les `JOIN` | Oui |

> **Problème** :  
> `SELECT u FROM Utilisateur u` → **ne fonctionne pas bien** (UNION interne coûteuse)

---

## 4. **Comparaison rapide**

| Critère | `SINGLE_TABLE` | `JOINED` | `TABLE_PER_CLASS` |
|--------|----------------|----------|-------------------|
| Nombre de tables | 1 | 4 | 3 |
| `NULL` dans colonnes | Oui | Non | Non |
| `JOIN` requis | Non | Oui | Non |
| Requêtes polymorphes | Rapides | Moyennes | Lentes |
| Écriture | Rapide | Moyenne | Rapide |
| Évolution du modèle | Facile | Très facile | Difficile |

---

## 5. **Recommandation selon le cas**

| Cas d’usage | Stratégie recommandée |
|------------|------------------------|
| **Peu de types**, **beaucoup de requêtes mixtes** | `SINGLE_TABLE` |
| **Types très différents**, **base normalisée** | `JOINED` |
| **Chaque type indépendant**, **pas de requêtes globales** | `TABLE_PER_CLASS` |

---

## 6. **Exemple complet : Code JPA**

### `SINGLE_TABLE` (recommandé pour ton cas)

```java
@Entity
@Table(name = "utilisateur")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_utilisateur", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("UTILISATEUR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;
}

@Entity
@DiscriminatorValue("ETUDIANT")
@Data
@EqualsAndHashCode(callSuper = true)
public class Etudiant extends Utilisateur {
    private String niveau;
    private String matricule;
}

@Entity
@DiscriminatorValue("SURVEILLANT")
@Data
@EqualsAndHashCode(callSuper = true)
public class Surveillant extends Utilisateur {
    private String zone;
    private LocalTime debutService;
}

@Entity
@DiscriminatorValue("ADMIN")
@Data
@EqualsAndHashCode(callSuper = true)
public class Administrateur extends Utilisateur {
    private String departement;
    private boolean superAdmin = false;
}
```

---

## 7. **Test en JPQL**

```java
// Tous les utilisateurs
List<Utilisateur> tous = entityManager
    .createQuery("SELECT u FROM Utilisateur u", Utilisateur.class)
    .getResultList();

// Seulement les étudiants
List<Etudiant> etudiants = entityManager
    .createQuery("SELECT e FROM Etudiant e", Etudiant.class)
    .getResultList();
```

---

## 8. **Résumé visuel**

```
SINGLE_TABLE          JOINED               TABLE_PER_CLASS
┌────────────────┐   ┌────────────┐        ┌────────────┐
│   utilisateur  │   │ utilisateur│        │  etudiant  │
│ id, nom, email │   │ id, nom    │        │ id, nom... │
│ DTYPE, niveau  │   ├────────────┤        ├────────────┤
│ matricule, ... │   │  etudiant  │        │ surveillant│
└────────────────┘   │ id, niveau │        │ id, nom... │
                     └────────────┘        └────────────┘
```

---

## 9. **Conclusion : Quelle stratégie pour ton cas ?**

> **Ton cas** : `Etudiant`, `Surveillant`, `Administrateur` → **peu de types**, **besoin de requêtes globales** (ex: login, liste utilisateurs)

**Recommandation : `SINGLE_TABLE`**

**Pourquoi ?**
- Performant
- Requêtes simples (`SELECT u FROM Utilisateur u`)
- Peu de colonnes `NULL` (seulement les champs spécifiques)
- Évolutif facilement

> **Évite `TABLE_PER_CLASS`** → pas de requêtes polymorphes efficaces  
> **Utilise `JOINED`** seulement si tu veux une base **parfaitement normalisée**

---

**Tu veux un TP complet avec :**
- Repository
- Service
- Test d’insertion / lecture
- Migration SQL

Dis-moi : **"Go TP Héritage JPA !"**