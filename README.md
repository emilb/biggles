Steg 3
=======

Funktionell testning med Geb
----------------------------

Vi har lagt till maven-failsafe-plugin och konfigurerat den att köra alla tester
i alla filer vars namn matchar *Spec.* Vi har även konfigurerat jetty-maven-plugin
att starta sig själv i fasen pre-integration-test.

För varje test som körs tas en screenshot som läggs i target/test-reports/geb/

Det går att byta Selenium-driver genom att modifiera filen /test/resources/GebConfig.groovy.
FirefoxDriver verkar (förutom PhantomJS) fungera bäst.

Din uppgift är att skriva en spec för att testa sidan som listar alla boktitlar i
bokstavsordning: http://localhost:9080/#/titles/alpha

Det finns redan ett pageobjekt som verifierar det grundläggande i sidan (rätt titel och
att menyvalet är gråmarkerat).

1. Kopiera filen src/test/groovy/IllustratorsSpec.groovy till src/test/groovy/TitlesAlphaSpec.groovy
2. Modifiera TitlesAlphaSpec att gå till sidan TitlesAlphaPage
3. I waitFor klausulen verifiera
3.1 att första boken i listan är "Biggles & Co".
3.2 att det finns totalt 13 sidor i tabellnavigeraren.

Referenser och hjälp:
http://www.gebish.org/manual/0.7.2/navigator.html#interacting_with_content

Om du kör Geb-testet från din IDE måste du först själv starta applikationen med:
```bash
mvn jetty:run
```

Övriga kommandon:
```bash
mvn integration-test
mvn test
```
