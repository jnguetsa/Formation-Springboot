Voici un **tableau clair et complet** des annotations JPA/Hibernate les plus utilisées (Spring Boot).
Il est organisé par catégories : entités, colonnes, relations, clés primaires, contraintes, etc.

---

# 📘 **TABLEAU COMPLET DES ANNOTATIONS JPA / HIBERNATE**

## 🏛️ **A. Annotations pour les entités**

| Annotation             | Explication                                                                   |
| ---------------------- | ----------------------------------------------------------------------------- |
| `@Entity`              | Indique que la classe est une entité JPA mappée dans la base de données.      |
| `@Table(name = "...")` | Définit le nom de la table et peut contenir des contraintes (unique, index…). |
| `@MappedSuperclass`    | Permet de définir une classe parent avec des champs hérités par des entités.  |
| `@Embeddable`          | Déclare un objet réutilisable stocké dans la même table (valeur intégrée).    |
| `@Embedded`            | Utilisé dans une entité pour inclure un objet `@Embeddable`.                  |
| `@Inheritance`         | Configure l’héritage entre entités (SINGLE_TABLE, JOINED, TABLE_PER_CLASS).   |
| `@DiscriminatorColumn` | Définit la colonne utilisée pour distinguer les sous-classes en SINGLE_TABLE. |
| `@DiscriminatorValue`  | Valeur stockée pour identifier une sous-classe.                               |

---

## 🔑 **B. Annotations pour la clé primaire**

| Annotation                      | Explication                                                              |
| ------------------------------- | ------------------------------------------------------------------------ |
| `@Id`                           | Indique la clé primaire.                                                 |
| `@GeneratedValue(strategy = …)` | Génère automatiquement la clé primaire (IDENTITY, AUTO, SEQUENCE…).      |
| `@SequenceGenerator`            | Déclare un générateur basé sur une séquence.                             |
| `@TableGenerator`               | Déclare un générateur de clés basé sur une table.                        |
| `@Column`                       | Peut spécifier `nullable`, `unique`, `length`, `name`, `updatable`, etc. |

---

## 🧱 **C. Annotations pour les colonnes**

| Annotation                     | Explication                                             |
| ------------------------------ | ------------------------------------------------------- |
| `@Column(name = "...")`        | Configure une colonne (taille, null, unique…).          |
| `@Lob`                         | Représente un gros objet (texte long ou BLOB).          |
| `@Enumerated(EnumType.STRING)` | Sauvegarde les enums comme STRING (souvent recommandé). |
| `@Temporal(TemporalType.DATE)` | Pour les anciens types Date (avant LocalDate).          |
| `@Transient`                   | Champ ignoré par Hibernate (pas stocké).                |
| `@CreationTimestamp`           | Ajoute automatiquement la date de création.             |
| `@UpdateTimestamp`             | Ajoute automatiquement la date de mise à jour.          |

---

## 🔗 **D. Annotations pour les relations**

### (Très important pour comprendre JPA)

| Annotation                  | Explication                                       |
| --------------------------- | ------------------------------------------------- |
| `@OneToOne`                 | Relation 1–1 entre deux entités.                  |
| `@OneToMany`                | Relation 1–N (parent → liste d’enfants).          |
| `@ManyToOne`                | Relation N–1 (plusieurs enfants → un parent).     |
| `@ManyToMany`               | Relation N–N avec table intermédiaire.            |
| `@JoinColumn(name = "...")` | Spécifie la clé étrangère.                        |
| `@JoinTable(name = "...")`  | Table de jointure pour ManyToMany.                |
| `mappedBy = "..."`          | Indique le côté inverse de la relation.           |
| `cascade = ...`             | Cascade des opérations (persist, merge, remove…). |
| `fetch = LAZY/EAGER`        | Mode de chargement de la relation.                |

---

## 🛡️ **E. Annotations pour les contraintes et validations**

| Annotation                          | Explication                                                |
| ----------------------------------- | ---------------------------------------------------------- |
| `@Column(unique = true)`            | Rend une colonne unique.                                   |
| `@Table(uniqueConstraints = {...})` | Créer une contrainte unique sur une ou plusieurs colonnes. |
| `@NotNull`                          | Champ obligatoire (validation).                            |
| `@Size(min, max)`                   | Définit une taille minimum/maximum.                        |
| `@Email`                            | Valide qu’un champ est un email.                           |
| `@Pattern(regex = "...")`           | Applique une regex.                                        |

---

## ⚙️ **F. Annotations avancées**

| Annotation             | Explication                                          |
| ---------------------- | ---------------------------------------------------- |
| `@NamedQuery`          | Déclare une requête JPQL réutilisable.               |
| `@NamedNativeQuery`    | Déclare une requête SQL native réutilisable.         |
| `@SqlResultSetMapping` | Map un résultat SQL vers un DTO.                     |
| `@Convert`             | Utilise un convertisseur personnalisé.               |
| `@Version`             | Active l’optimistic locking (contrôle des conflits). |

---

# 🔥 **Tu veux aussi ?**

Je peux te préparer :

✅ un PDF complet
✅ un tableau encore plus détaillé
✅ un exemple d’entité avec toutes les annotations
✅ un cours clair sur les relations (OneToMany, ManyToOne…)

Dis-moi ce que tu veux.
