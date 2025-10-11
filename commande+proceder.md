# Procédure complète pour initialiser un projet Spring Boot avec Docker

## 📋 Prérequis
- Java 17+ installé
- Maven installé
- Docker Desktop installé et démarré

---

## 🚀 Étape 1 : Création du projet Spring Boot

### Option A : Via Spring Initializr (Recommandé)
```bash
# Aller sur https://start.spring.io/
# Choisir :
# - Project: Maven
# - Language: Java
# - Spring Boot: 3.2.x
# - Packaging: Jar
# - Java: 17
# - Dependencies: Spring Web, Spring Data JPA, PostgreSQL Driver
# Télécharger et extraire le projet
```

### Option B : Via la ligne de commande
```bash
# Naviguer dans votre répertoire de travail
cd /chemin/vers/vos/projets

# Créer un nouveau projet Spring Boot
mvn archetype:generate \
  -DgroupId=com.votreentreprise \
  -DartifactId=mon-projet \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false
```

---

## 🛠 Étape 2 : Structure du projet
Votre projet devrait avoir cette structure :
```
mon-projet/
├── src/
│   └── main/
│       └── java/
│           └── com/votreentreprise/
│               └── MonProjetApplication.java
├── pom.xml
├── Dockerfile
└── docker-compose.yml
```

---

## 📝 Étape 3 : Configuration des fichiers

### 3.1 Fichier `application.properties`
```properties
# Configuration de base
spring.application.name=mon-projet
server.port=8080

# Configuration DataSource
spring.datasource.url=jdbc:postgresql://localhost:5432/mon-projet
spring.datasource.username=postgres
spring.datasource.password=password

# Configuration JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true

# Pour le développement
spring.jpa.defer-datasource-initialization=true
```

### 3.2 Fichier `Dockerfile`
```dockerfile
# Étape 1 : Build de l'application
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 : Image d'exécution
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copier le JAR depuis l'étape de build
COPY --from=build /app/target/*.jar app.jar

# Exposition du port
EXPOSE 8080

# Commande de démarrage
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

### 3.3 Fichier `docker-compose.yml`
```yaml
version: '3.8'

services:
  # Base de données PostgreSQL
  postgres:
    image: postgres:15
    container_name: postgres-db
    environment:
      POSTGRES_DB: mon-projet
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: password
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
    networks:
      - app-network

  # Interface d'administration de la base de données
  pgadmin:
    image: dpage/pgadmin4
    container_name: pgadmin
    environment:
      PGADMIN_DEFAULT_EMAIL: admin@admin.com
      PGADMIN_DEFAULT_PASSWORD: admin
    ports:
      - "5050:80"
    depends_on:
      - postgres
    networks:
      - app-network

  # Application Spring Boot
  app:
    build:
      context: .
      dockerfile: Dockerfile
    container_name: spring-app
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/mon-projet
      - SPRING_DATASOURCE_USERNAME=postgres
      - SPRING_DATASOURCE_PASSWORD=password
      - SPRING_JPA_HIBERNATE_DDL_AUTO=update
      - SPRING_JPA_SHOW_SQL=true
    ports:
      - "8080:8080"
    depends_on:
      - postgres
    networks:
      - app-network

volumes:
  postgres_data:

networks:
  app-network:
    driver: bridge
```

---

## 🔧 Étape 4 : Commandes de build et démarrage

### 4.1 Build de l'application localement (test)
```bash
# Se placer dans le répertoire du projet
cd mon-projet

# Build avec Maven
mvn clean package

# Tester l'application localement
java -jar target/*.jar
```

### 4.2 Construction des images Docker
```bash
# Build l'image de l'application
docker build -t mon-projet-app .

# Vérifier que l'image est créée
docker images
```

### 4.3 Démarrage avec Docker Compose
```bash
# Démarrer tous les services
docker-compose up --build

# Démarrer en arrière-plan
docker-compose up -d --build

# Voir les logs
docker-compose logs -f

# Arrêter les services
docker-compose down

# Arrêter et supprimer les volumes
docker-compose down -v
```

---

## 🧪 Étape 5 : Vérification

### 5.1 Vérifier les containers en cours d'exécution
```bash
docker-compose ps
# Doit afficher 3 services : postgres-db, pgadmin, spring-app
```

### 5.2 Tester l'application
```bash
# Tester l'API Spring Boot
curl http://localhost:8080

# Vérifier la santé de l'application
curl http://localhost:8080/actuator/health
```

### 5.3 Accéder aux interfaces
- **Application Spring Boot** : http://localhost:8080
- **PgAdmin (Admin DB)** : http://localhost:5050
- **PostgreSQL** : localhost:5432

---

## 🐛 Étape 6 : Dépannage courant

### Vérifier les logs
```bash
# Logs de l'application
docker-compose logs app

# Logs de la base de données
docker-compose logs postgres

# Logs en temps réel
docker-compose logs -f app
```

### Redémarrer un service spécifique
```bash
docker-compose restart app
```

### Rebuild un service spécifique
```bash
docker-compose up --build app
```

### Nettoyage Docker
```bash
# Supprimer les containers arrêtés
docker container prune

# Supprimer les images non utilisées
docker image prune

# Supprimer les volumes non utilisés
docker volume prune
```

---

## 📁 Étape 7 : Développement avec Hot Reload (Optionnel)

Pour le développement avec rechargement automatique, modifiez le `Dockerfile` :

```dockerfile
FROM maven:3.9-eclipse-temurin-17 AS development
WORKDIR /app
COPY . .
CMD ["mvn", "spring-boot:run"]
```

Et dans `docker-compose.yml` pour le développement :
```yaml
app:
  build:
    context: .
    target: development
  volumes:
    - .:/app
    - ~/.m2:/root/.m2
  environment:
    - SPRING_DEVTOOLS_RESTART_ENABLED=true
```

---

## ✅ Résultat final

Après ces étapes, vous aurez :
- ✅ Une application Spring Boot fonctionnelle
- ✅ Une base de PostgreSQL containerisée
- ✅ Une interface d'administration pour la DB
- ✅ Tous les services connectés via un réseau Docker
- ✅ Des commandes pour gérer facilement l'infrastructure

Votre environnement de développement est maintenant prêt ! 🎉



---
# Commandes Docker Essentielles et leurs Rôles

## 🐳 Commandes Docker de Base

### Gestion des Containers
```bash
# Lancer tous les services
docker-compose up
docker-compose up -d                          # Mode détaché (arrière-plan)
docker-compose up --build                     # Rebuild les images avant démarrage

# Arrêter les services
docker-compose down                           # Arrêter et supprimer les containers
docker-compose down -v                        # + supprimer les volumes
docker-compose stop                           # Arrêter sans supprimer

# Voir l'état des services
docker-compose ps                             # Status des services
docker-compose logs                           # Voir tous les logs
docker-compose logs -f app                    # Logs en temps réel du service "app"
```

### Gestion des Images
```bash
# Construire une image
docker build -t mon-app .                     # Build l'image avec un tag
docker build --no-cache -t mon-app .          # Build sans utiliser le cache

# Lister les images
docker images                                 # Lister toutes les images
docker image ls                               # Alternative

# Supprimer des images
docker rmi mon-app                            # Supprimer une image
docker image prune                            # Supprimer images non utilisées
docker image prune -a                         # Supprimer toutes les images non utilisées
```

### Gestion des Containers Individuels
```bash
# Exécuter un container
docker run -d -p 8080:8080 mon-app            # Démarrer en arrière-plan
docker run -it mon-app /bin/bash              # Mode interactif

# Gérer les containers
docker ps                                     # Containers en cours d'exécution
docker ps -a                                  # Tous les containers (même arrêtés)
docker stop <container_id>                    # Arrêter un container
docker start <container_id>                   # Redémarrer un container
docker restart <container_id>                 # Redémarrer
docker rm <container_id>                      # Supprimer un container
docker rm -f <container_id>                   # Forcer la suppression
```

### Inspection et Debug
```bash
# Inspecter
docker logs <container_id>                    # Voir les logs d'un container
docker logs -f <container_id>                 # Suivre les logs en temps réel
docker exec -it <container_id> /bin/bash      # Ouvrir un shell dans le container
docker inspect <container_id>                 # Informations détaillées

# Monitoring
docker stats                                  # Statistiques en temps réel
docker top <container_id>                     # Processus dans le container
```

### Nettoyage
```bash
docker container prune                        # Supprimer containers arrêtés
docker image prune                            # Supprimer images sans tag
docker volume prune                           # Supprimer volumes non utilisés
docker system prune                           # Nettoyage complet (containers, images, réseaux)
docker system prune -a                        # Nettoyage agressif
docker system df                              # Voir l'espace disque utilisé
```

---

## 🪟 Commandes Windows CMD Essentielles

### Gestion des Processus et Ports
```cmd
:: Trouver quel processus utilise un port
netstat -ano | findstr :8080

:: Tuer un processus par PID
taskkill /PID 1234 /F

:: Tuer un processus par nom
taskkill /IM java.exe /F

:: Lister tous les processus
tasklist

:: Lister les processus avec des détails
wmic process get processid,executablepath
```

### Gestion des Fichiers et Répertoires
```cmd
:: Navigation
cd mon-projet                                :: Changer de répertoire
cd ..                                        :: Remonter d'un niveau
dir                                          :: Lister le contenu

:: Copie de fichiers
copy fichier1.txt fichier2.txt
xcopy source destination /E /H /C /I

:: Suppression
del fichier.txt
rmdir /S mon-dossier                         :: Supprimer un dossier récursivement

:: Création de dossiers
mkdir nouveau-dossier
```

### Réseau et Connexions
```cmd
:: Test de connexion
ping google.com
telnet localhost 8080

:: Informations réseau
ipconfig
ipconfig /all

:: Flush DNS
ipconfig /flushdns
```

### Variables d'Environnement
```cmd
:: Voir les variables
set

:: Définir une variable temporaire
set JAVA_HOME=C:\Program Files\Java\jdk-17

:: Voir une variable spécifique
echo %JAVA_HOME%
```

---

## 🔄 Workflow de Développement Typique

### Démarrage du Projet
```bash
# 1. Build initial
mvn clean package

# 2. Construire les images Docker
docker-compose build

# 3. Démarrer l'environnement
docker-compose up -d

# 4. Vérifier que tout fonctionne
docker-compose ps
curl http://localhost:8080/actuator/health
```

### Pendant le Développement
```bash
# Voir les logs en temps réel
docker-compose logs -f app

# Redémarrer uniquement l'application après des changements
docker-compose restart app

# Rebuild et redémarrer un service spécifique
docker-compose up --build -d app

# Ouvrir un shell dans le container pour debug
docker exec -it spring-app /bin/bash
```

### Arrêt et Nettoyage
```bash
# Arrêt propre
docker-compose down

# Si problèmes de ports/conflits sur Windows
netstat -ano | findstr :8080
taskkill /PID <PID_TROUVE> /F

# Nettoyage complet si nécessaire
docker-compose down -v
docker system prune
```

---

## 🚨 Commandes de Dépannage Spécifiques

### Problèmes de Port
```bash
# Sur Windows - libérer un port
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# Sur Linux/Mac
lsof -i :8080
kill -9 <PID>
```

### Problèmes de Build
```bash
# Clean rebuild
docker-compose down
docker system prune
mvn clean package
docker-compose up --build
```

### Problèmes de Base de Données
```bash
# Vérifier la connexion DB
docker exec -it postgres-db psql -U postgres -d mon-projet

# Redémarrer seulement la DB
docker-compose restart postgres
```

### Problèmes de Mémoire/Cache
```bash
# Vider le cache Maven dans le container
docker exec -it spring-app mvn dependency:purge-local-repository

# Rebuild sans cache
docker-compose build --no-cache
```

---

## 📋 Checklist de Démarrage Rapide

```bash
# 1. Vérifier que Docker tourne
docker --version
docker-compose --version

# 2. Build l'application
mvn clean package

# 3. Démarrer l'environnement
docker-compose up -d --build

# 4. Vérifier
docker-compose ps
curl http://localhost:8080/actuator/health

# 5. Voir les logs si problème
docker-compose logs -f app

# 6. Arrêt
docker-compose down
```

Ces commandes couvrent 95% des besoins quotidiens pour développer avec Docker et Spring Boot! 🎯
