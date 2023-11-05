# Utilisez l'image de base de votre choix
FROM openjdk:11

# Définissez le répertoire de travail
WORKDIR /app

# Copiez le fichier JAR depuis le répertoire cible de votre projet
COPY target/newjar.jar newjar.jar

# Exposez le port
EXPOSE 8083

# Commande pour exécuter l'application
CMD ["java", "-jar", "newjar.jar"]
