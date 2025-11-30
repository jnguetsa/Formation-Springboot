Voici des données d'exemple pour vos tables Utilisateur et Enseignant :

## Données pour la table Utilisateur

```sql
-- Utilisateurs de base
INSERT INTO utilisateur (id, nom, email, telephone, mot_de_passe, sexe, active, date_creation, dtype) VALUES
(1, 'Martin Dupont', 'martin.dupont@email.com', '0123456789', 'password123', 'HOMME', true, '2023-01-15 10:30:00', 'Utilisateur'),
(2, 'Sophie Bernard', 'sophie.bernard@email.com', '0234567890', 'password456', 'FEMME', true, '2023-02-20 14:15:00', 'Utilisateur'),
(3, 'Thomas Leroy', 'thomas.leroy@email.com', '0345678901', 'password789', 'HOMME', true, '2023-03-10 09:45:00', 'Utilisateur');

-- Enseignants (héritent de Utilisateur)
INSERT INTO utilisateur (id, nom, email, telephone, mot_de_passe, sexe, active, date_creation, dtype, grade, specialite) VALUES
(4, 'Dr. Marie Curie', 'marie.curie@universite.fr', '0456789012', 'science123', 'FEMME', true, '2023-01-10 08:00:00', 'Enseignant', 'PROFESSEUR', 'Physique'),
(5, 'Prof. Jean Piaget', 'jean.piaget@universite.fr', '0567890123', 'psycho456', 'HOMME', true, '2023-02-05 11:20:00', 'Enseignant', 'PROFESSEUR', 'Psychologie'),
(6, 'Dr. Albert Einstein', 'albert.einstein@universite.fr', '0678901234', 'relativity', 'HOMME', true, '2023-03-15 16:45:00', 'Enseignant', 'PROFESSEUR_EMERITE', 'Physique Théorique'),
(7, 'M. Claude Monet', 'claude.monet@art-school.fr', '0789012345', 'impression', 'HOMME', true, '2023-04-01 13:10:00', 'Enseignant', 'MAITRE_DE_CONFERENCES', 'Arts Plastiques'),
(8, 'Mme. Simone de Beauvoir', 'simone.beauvoir@philo.fr', '0890123456', 'existential', 'FEMME', true, '2023-04-18 15:30:00', 'Enseignant', 'PROFESSEUR', 'Philosophie'),
(9, 'Dr. Marie Skłodowska', 'marie.sklodowska@science.fr', '0901234567', 'radioactive', 'FEMME', true, '2023-05-22 10:00:00', 'Enseignant', 'PROFESSEUR', 'Chimie'),
(10, 'Prof. Stephen Hawking', 'stephen.hawking@cosmos.fr', '0012345678', 'blackhole', 'HOMME', false, '2023-06-30 12:00:00', 'Enseignant', 'PROFESSEUR_EMERITE', 'Astrophysique');
```

## Script SQL complet avec création de séquence

```sql
-- Création d'une séquence pour les IDs (adapté à PostgreSQL avec GenerationType.TABLE)
CREATE SEQUENCE utilisateur_seq START 11;

-- Insertion des données
INSERT INTO utilisateur (id, nom, email, telephone, mot_de_passe, sexe, active, date_creation, dtype) VALUES
(1, 'Martin Dupont', 'martin.dupont@email.com', '0123456789', '$2a$10$password123', 'HOMME', true, '2023-01-15 10:30:00', 'Utilisateur'),
(2, 'Sophie Bernard', 'sophie.bernard@email.com', '0234567890', '$2a$10$password456', 'FEMME', true, '2023-02-20 14:15:00', 'Utilisateur'),
(3, 'Thomas Leroy', 'thomas.leroy@email.com', '0345678901', '$2a$10$password789', 'HOMME', true, '2023-03-10 09:45:00', 'Utilisateur');

INSERT INTO utilisateur (id, nom, email, telephone, mot_de_passe, sexe, active, date_creation, dtype, grade, specialite) VALUES
(4, 'Dr. Marie Curie', 'marie.curie@universite.fr', '0456789012', '$2a$10$science123', 'FEMME', true, '2023-01-10 08:00:00', 'Enseignant', 'PROFESSEUR', 'Physique'),
(5, 'Prof. Jean Piaget', 'jean.piaget@universite.fr', '0567890123', '$2a$10$psycho456', 'HOMME', true, '2023-02-05 11:20:00', 'Enseignant', 'PROFESSEUR', 'Psychologie'),
(6, 'Dr. Albert Einstein', 'albert.einstein@universite.fr', '0678901234', '$2a$10$relativity', 'HOMME', true, '2023-03-15 16:45:00', 'Enseignant', 'PROFESSEUR_EMERITE', 'Physique Théorique'),
(7, 'M. Claude Monet', 'claude.monet@art-school.fr', '0789012345', '$2a$10$impression', 'HOMME', true, '2023-04-01 13:10:00', 'Enseignant', 'MAITRE_DE_CONFERENCES', 'Arts Plastiques'),
(8, 'Mme. Simone de Beauvoir', 'simone.beauvoir@philo.fr', '0890123456', '$2a$10$existential', 'FEMME', true, '2023-04-18 15:30:00', 'Enseignant', 'PROFESSEUR', 'Philosophie'),
(9, 'Dr. Marie Skłodowska', 'marie.sklodowska@science.fr', '0901234567', '$2a$10$radioactive', 'FEMME', true, '2023-05-22 10:00:00', 'Enseignant', 'PROFESSEUR', 'Chimie'),
(10, 'Prof. Stephen Hawking', 'stephen.hawking@cosmos.fr', '0012345678', '$2a$10$blackhole', 'HOMME', false, '2023-06-30 12:00:00', 'Enseignant', 'PROFESSEUR_EMERITE', 'Astrophysique');
```

## Enumérations nécessaires

Assurez-vous d'avoir ces enums dans votre code Java :

```java
public enum TypeSexe {
    HOMME,
    FEMME,
    AUTRE
}

public enum Grade {
    PROFESSEUR,
    PROFESSEUR_EMERITE,
    MAITRE_DE_CONFERENCES,
    CHARGEE_DE_COURS,
    ASSISTANT
}
```

## Données supplémentaires variées

```sql
-- Enseignants avec différentes spécialités
INSERT INTO utilisateur (id, nom, email, telephone, mot_de_passe, sexe, active, date_creation, dtype, grade, specialite) VALUES
(11, 'Dr. Alan Turing', 'alan.turing@computing.uk', '0112233445', '$2a$10$enigma', 'HOMME', true, '2023-07-12 09:15:00', 'Enseignant', 'PROFESSEUR', 'Informatique'),
(12, 'Prof. Noam Chomsky', 'noam.chomsky@linguistics.edu', '0223344556', '$2a$10$linguistics', 'HOMME', true, '2023-08-25 14:20:00', 'Enseignant', 'PROFESSEUR_EMERITE', 'Linguistique'),
(13, 'Dr. Rosalind Franklin', 'rosalind.franklin@dna.uk', '0334455667', '$2a$10$dnaStructure', 'FEMME', true, '2023-09-08 11:45:00', 'Enseignant', 'MAITRE_DE_CONFERENCES', 'Biologie Moléculaire'),
(14, 'M. Pablo Picasso', 'pablo.picasso@art.edu', '0445566778', '$2a$10$cubism', 'HOMME', false, '2023-10-17 16:30:00', 'Enseignant', 'PROFESSEUR', 'Arts Modernes');
```

Ces données fournissent :

- **3 utilisateurs standards**
- **11 enseignants** avec différents grades et spécialités
- Un mélange d'hommes et de femmes
- Quelques comptes inactifs pour la variété
- Des dates de création réparties sur l'année 2023
- Des spécialités académiques variées

Les mots de passe sont hashés (format BCrypt) pour plus de réalisme. Vous pouvez les adapter selon vos besoins.