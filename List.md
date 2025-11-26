Salut ! 😊

Oui, il y a **beaucoup de rouge** dans ton code, et c’est normal : il y a **plusieurs erreurs de syntaxe** dans les deux classes `Permission` et `Role`. Je vais te les corriger **proprement**, t’expliquer chaque problème, et te donner les **versions corrigées**.

---

### Problèmes dans `Permission.java`

```java
ManyToMany(fetch=FetchType.EAGER)
private Collection roles= new ArrayList<>();
```

#### Erreurs :
1. **`ManyToMany` sans `@`** → Il faut `@ManyToMany`
2. **`Collection` sans type générique** → Doit être `Collection<Role>`
3. **Nom de variable `roles`** → Mauvaise pratique (confus avec la classe `Role`)
4. **Pas d'import pour `Role`**

---

### Problèmes dans `Role.java`

```java
ManyToMany(mappedBy="roles" fetch= fetchType.Eager)
private Collection roles=new ArrayList<>();
```

#### Erreurs :
1. **`ManyToMany` sans `@`**
2. **`fetchType.Eager`** → Fausse casse : `FetchType.EAGER` (majuscule)
3. **`Collection` sans type** → Doit être `Collection<Permission>`
4. **Nom de variable `roles`** → Très confus !
5. **Pas d'import pour `Permission`**

---

## Versions corrigées

### `Permission.java`

```java
package com.example.formation.Entites;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom; // Bonne pratique : minuscule

    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
}
```

---

### `Role.java`

```java
package com.example.formation.Entites;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    private String description;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Collection<Permission> permissions = new ArrayList<>();
}
```

---

## Résumé des corrections

| Problème | Correction |
|--------|-----------|
| `@ManyToMany` manquant | Ajouté |
| `Collection` sans type | → `Collection<Role>` ou `Collection<Permission>` |
| `roles` comme nom de variable | → Renommé `permissions` dans `Role` pour clarté |
| `fetchType.Eager` | → `FetchType.EAGER` |
| Champs `Nom`, `Description` | → `nom`, `description` (convention Java) |
| Imports manquants | Ajoutés implicitement (assure-toi que `Role` et `Permission` sont dans le même package) |

---

## Bonus : Relation bidirectionnelle propre

```java
// Dans Permission
@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(
    name = "permission_role",
    joinColumns = @JoinColumn(name = "permission_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
)
private Collection<Role> roles = new ArrayList<>();
```

> **Optionnel** : Si tu veux contrôler la table de jointure (`permission_role`)  
> Sinon, Hibernate la crée automatiquement.

---

Si tu veux, je peux te générer aussi :
- Le `RoleRepository`
- Le `PermissionService`
- Un exemple de `CommandLineRunner` pour tester

Dis-moi ce que tu veux faire avec ces entités ! 🚀


## Cours complet : **Les Collections en Java**
### `List`, `Set`, `Queue`, `Map` → **Différences, Implémentations & Quand les utiliser**

---

### 1. **Hiérarchie des Collections en Java**

```
java.lang.Object
   └── java.util.Collection<E>
         ├── java.util.List<E>
         ├── java.util.Set<E>
         ├── java.util.Queue<E>
         └── java.util.Deque<E>

java.util.Map<K,V>   (n’est PAS une Collection, mais très utilisé)
```

---

## 2. **Les 3 grandes interfaces : `List`, `Set`, `Queue`**

| Interface | Ordre | Doublons | Accès par index | Exemples d’implémentations |
|---------|-------|----------|------------------|----------------------------|
| `List<E>` | Oui (ordre d’insertion) | Oui | Oui | `ArrayList`, `LinkedList`, `Vector` |
| `Set<E>` | Non (sauf `LinkedHashSet`) | Non | Non | `HashSet`, `LinkedHashSet`, `TreeSet` |
| `Queue<E>` | Oui (FIFO ou priorité) | Oui | Non (sauf `PriorityQueue`) | `LinkedList`, `PriorityQueue` |

---

## 3. **Détail par interface**

---

### `List<E>` – **Liste ordonnée avec doublons**

```java
List<String> noms = new ArrayList<>();
noms.add("Ali");     // [Ali]
noms.add("Sara");    // [Ali, Sara]
noms.add("Ali");     // [Ali, Sara, Ali] → doublon OK
noms.get(0);         // → "Ali"
```

#### Implémentations

| Classe | Accès | Insertion/Suppr. | Thread-safe ? | Quand l'utiliser |
|-------|-------|------------------|----------------|------------------|
| `ArrayList` | O(1) | O(n) | Non | **Par défaut** – lecture fréquente |
| `LinkedList` | O(n) | O(1) | Non | Insertion/suppression en tête/milieu |
| `Vector` | O(1) | O(n) | Oui (synchronized) | Ancien code, évite en général |

> **Règle d’or** :  
> → **90% des cas → `ArrayList`**

---

### `Set<E>` – **Ensemble sans doublons**

```java
Set<String> uniques = new HashSet<>();
uniques.add("Java");     // [Java]
uniques.add("Python");   // [Java, Python]
uniques.add("Java");     // ignoré → pas de doublon
```

#### Implémentations

| Classe | Ordre | Performance | Particularité |
|-------|-------|-------------|-------------|
| `HashSet` | Aucun | O(1) ajout/recherche | **Plus rapide** |
| `LinkedHashSet` | Ordre d’insertion | O(1) | Garde l’ordre |
| `TreeSet` | Trié (naturel ou `Comparator`) | O(log n) | Tri automatique |

> **Quand utiliser ?**
> - `HashSet` → **vitesse max**, pas besoin d’ordre
> - `LinkedHashSet` → besoin de **préserver l’ordre d’ajout**
> - `TreeSet` → besoin de **tri automatique** (ex: noms par ordre alphabétique)

---

### `Queue<E>` – **File d’attente**

```java
Queue<String> file = new LinkedList<>();
file.offer("Tâche 1");
file.offer("Tâche 2");
file.poll(); // → "Tâche 1"
```

#### Implémentations

| Classe | Type | Usage |
|-------|------|-------|
| `LinkedList` | FIFO | File classique |
| `PriorityQueue` | Par priorité (naturelle ou `Comparator`) | Tâches urgentes d’abord |

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(5); pq.offer(1); pq.offer(3);
pq.poll(); // → 1 (le plus petit)
```

---

## 4. **`Map<K,V>` – Association clé → valeur**

> **Pas une `Collection`**, mais **très utilisée avec elles**

```java
Map<String, Integer> ages = new HashMap<>();
ages.put("Ali", 25);
ages.put("Sara", 30);
ages.get("Ali"); // → 25
```

#### Implémentations

| Classe | Ordre | Null key | Performance |
|-------|-------|----------|-------------|
| `HashMap` | Aucun | Oui (1 null) | O(1) |
| `LinkedHashMap` | Insertion | Oui | O(1) + ordre |
| `TreeMap` | Trié par clé | Non | O(log n) |

---

## 5. **Tableau récapitulatif : QUAND UTILISER QUOI ?**

| Besoin | Structure recommandée |
|-------|------------------------|
| Liste avec doublons, accès rapide par index | `ArrayList` |
| Liste avec beaucoup d’ajouts/suppressions en tête | `LinkedList` |
| Pas de doublons, recherche rapide | `HashSet` |
| Pas de doublons + garder l’ordre d’insertion | `LinkedHashSet` |
| Ensemble trié automatiquement | `TreeSet` |
| File d’attente (FIFO) | `LinkedList` ou `ArrayDeque` |
| File par priorité | `PriorityQueue` |
| Clé → valeur, accès rapide | `HashMap` |
| Clé → valeur + ordre d’insertion | `LinkedHashMap` |
| Clé → valeur + tri par clé | `TreeMap` |

---

## 6. **Bonnes pratiques**

```java
// Mauvais
List<String> list = new ArrayList<String>();

// Bon
List<String> list = new ArrayList<>(); // Diamond operator
```

```java
// Évite Vector sauf legacy
List<String> legacy = new Vector<>(); // synchronized → lent
```

```java
// Utilise les interfaces en paramètre
public void afficher(List<String> noms) { ... }
```

---

## 7. **Exercice rapide (corrigé)**

```java
public class ExerciceCollection {
    public static void main(String[] args) {
        // 1. Liste ordonnée avec doublons
        List<String> fruits = new ArrayList<>();
        fruits.add("Pomme");
        fruits.add("Banane");
        fruits.add("Pomme");

        // 2. Ensemble sans doublons + ordre
        Set<String> uniques = new LinkedHashSet<>(fruits);

        // 3. File d'attente
        Queue<String> panier = new LinkedList<>(uniques);

        // 4. Map : fruit → quantité
        Map<String, Integer> stock = new HashMap<>();
        for (String f : panier) {
            stock.put(f, stock.getOrDefault(f, 0) + 1);
        }

        System.out.println(stock); // {Pomme=2, Banane=1}
    }
}
```

---

## Résumé visuel

```
List → [A, B, A]        (ordre + doublons)
Set  → {A, B}           (pas de doublons)
Map  → {A→1, B→2}       (clé → valeur)
Queue → A → B → C       (FIFO ou priorité)
```

---

**Tu maîtrises maintenant quand utiliser `List`, `Set`, `Queue`, `Map` !**

---
## Cours complet : **Encapsulation, Accès, Méthodes & Constructeurs en Java**
### **"À quoi ça sert ? Quand l'utiliser ?"**

---

## 1. **Les Modificateurs d'accès : `public`, `private`, `protected`, `default`**

| Modificateur | Où on le voit | Qui peut y accéder ? |
|-------------|---------------|----------------------|
| `public`     | Partout       | **Tout le monde** (même autres packages) |
| `protected`  | Héritage      | Même classe + sous-classes + même package |
| *(rien)*     | `default`     | Même package uniquement |
| `private`    | Interne       | **Seulement dans la même classe** |

---

## 2. **Attributs : `private` (toujours !)**

```java
public class Personne {
    private String nom;        // private → caché
    private int age;
}
```

> **Règle d’or** :  
> **TOUS les attributs → `private`**  
> **Jamais `public` !** (sauf constantes `public static final`)

---

## 3. **Getters & Setters : Pourquoi ?**

### Getters → **Lire** un attribut
```java
public String getNom() {
    return nom;
}
```

### Setters → **Modifier** un attribut (avec contrôle)
```java
public void setNom(String nom) {
    if (nom != null && !nom.isEmpty()) {
        this.nom = nom;
    }
}
```

### Exemple complet

```java
public class Personne {
    private String nom;
    private int age;

    // Getter
    public String getNom() {
        return nom;
    }

    // Setter avec validation
    public void setNom(String nom) {
        if (nom != null && nom.length() > 0) {
            this.nom = nom.trim();
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        }
    }
}
```

---

## 4. **Attribut `public` → À ÉVITER !**

```java
public String nom; // DANGER !
```

```java
personne.nom = null;        // → crash possible
personne.nom = "";          // → donnée invalide
```

> **Avec `private` + setter → contrôle total**  
> **Avec `public` → n’importe qui peut casser l’objet**

---

## 5. **Méthodes : `public` vs `private`**

| Type | Exemple | Quand l'utiliser |
|------|--------|------------------|
| `public` | `public void afficher()` | API publique → appelée depuis l’extérieur |
| `private` | `private boolean estValide()` | Méthode interne → aide interne seulement |

```java
public class CompteBancaire {
    private double solde;

    public void deposer(double montant) {
        if (estPositif(montant)) {  // méthode privée
            solde += montant;
        }
    }

    private boolean estPositif(double valeur) {
        return valeur > 0;
    }
}
```

---

## 6. **Méthode `static` : appartient à la CLASSE, pas à l’objet**

```java
public class MathUtils {
    public static int additionner(int a, int b) {
        return a + b;
    }
}
```

```java
// Appel SANS créer d'objet
int resultat = MathUtils.additionner(5, 3); // → 8
```

### Quand utiliser `static` ?
| Cas | Exemple |
|-----|--------|
| Outils généraux | `Math.random()`, `Collections.sort()` |
| Constantes | `public static final double PI = 3.14;` |
| Méthodes utilitaires | `StringUtils.isEmpty()` |

> **Pas de `this` dans une méthode `static` !**

---

## 7. **Constructeurs : Créer un objet**

### Constructeur **sans paramètre** (défaut)

```java
public Personne() {
    this.nom = "Inconnu";
    this.age = 0;
}
```

### Constructeur **avec paramètres**

```java
public Personne(String nom, int age) {
    this.nom = nom;
    this.age = age;
}
```

### Constructeur `private` → **Design Pattern**

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {} // privé → pas d'instanciation directe

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

---

## 8. **Récapitulatif : QUAND UTILISER QUOI ?**

| Élément | Quand l'utiliser | Exemple |
|--------|------------------|--------|
| `private` attribut | **Toujours** | `private String nom;` |
| `public` getter/setter | Accès contrôlé | `getNom()`, `setNom()` |
| `public` méthode | API publique | `calculerSalaire()` |
| `private` méthode | Logique interne | `validerEmail()` |
| `static` méthode | Utilitaire, pas besoin d’objet | `Math.max(a, b)` |
| Constructeur sans param | Valeurs par défaut | `new Personne()` |
| Constructeur avec param | Initialisation précise | `new Personne("Ali", 25)` |
| Constructeur `private` | Singleton, factory | `Singleton.getInstance()` |
| `public static final` | Constante | `public static final int MAX = 100;` |

---

## 9. **Exemple complet : Classe bien conçue**

```java
public class Etudiant {
    // 1. Attributs privés
    private String nom;
    private int age;
    private static int compteur = 0; // partagé

    // 2. Constructeur avec param
    public Etudiant(String nom, int age) {
        setNom(nom);    // validation
        setAge(age);
        compteur++;
    }

    // 3. Constructeur par défaut
    public Etudiant() {
        this("Inconnu", 18);
    }

    // 4. Getters
    public String getNom() { return nom; }
    public int getAge() { return age; }

    // 5. Setter avec contrôle
    public void setNom(String nom) {
        if (nom != null && !nom.trim().isEmpty()) {
            this.nom = nom.trim();
        }
    }

    public void setAge(int age) {
        if (age >= 0) this.age = age;
    }

    // 6. Méthode publique
    public void afficher() {
        System.out.println(nom + " (" + age + " ans)");
    }

    // 7. Méthode privée (interne)
    private boolean estMajeur() {
        return age >= 18;
    }

    // 8. Méthode static
    public static int getNombreEtudiants() {
        return compteur;
    }
}
```

```java
// Utilisation
Etudiant e1 = new Etudiant("Sara", 20);
Etudiant e2 = new Etudiant();
e1.afficher(); // Sara (20 ans)
System.out.println(Etudiant.getNombreEtudiants()); // 2
```

---

## 10. **Résumé visuel**

```
Classe Etudiant
├── private nom, age
├── public getNom(), setNom()
├── public Etudiant(String, int)
├── private estMajeur()
├── public static getNombreEtudiants()
└── public afficher()
```

---

**Tu sais maintenant :**
- Pourquoi `private` + getter/setter
- Quand utiliser `static`
- À quoi servent les constructeurs
- Comment bien structurer une classe

---

**Tu veux un TP ?**  
Je te fais **5 exercices corrigés** (voiture, compte bancaire, étudiant, etc.)  
Dis-moi : **"Go TP !"**

