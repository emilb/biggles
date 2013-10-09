Steg 1
======

1. Lägg till dig själv som developer i pom.xml
2. Lägg till pluginerna maven-clean-plugin och maven-compiler-plugin i senaste versioner.
3. Konfigurera maven-compiler-plugin att använda java 1.7 och enkodning UTF-8
4. Verifiera att projektet bygger samt kan deployas i jetty

Referenser och hjälp:
http://maven.apache.org/plugins

Tips:
```bash
mvn clean
mvn compile:help
mvn compile
mvn install
mvn jetty:run
```
Jetty är konfigurerad att lyssna på port 9080 vilket gör att du kan surfa till: http://localhost:9080
