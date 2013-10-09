Steg 2
=======

Javascript-testning med Jasmine
-------------------------------

Vi har lagt till Jasmine som en plugin. Jasmine är konfigurerad att använda goal=test och den
hookar in sig i testfasen.

I src/main/webapp/resources/js/BigglesApp.js finns en klass som heter BigglesUtil.Paginator. Den
används för att dela upp en array med objekt i sidor. Ett embryo till test finns i
src/test/javascript/paginator_spec.js

1. Verifiera att javascripttesterna i nuläget inte passerar.
2. Komplettera paginator_spec.js med meningsfulla tester
3. Säkerställ att hela projektet bygger igen.

Referenser och hjälp:
* http://searls.github.io/jasmine-maven-plugin/
* http://pivotal.github.io/jasmine/

Jasmine har ett BDD mode som startas via:
```bash
mvn jasmine:bdd
```

Öppna sen en webläsare mot <http://localhost:8234/> så får du kontinuerliga uppdateringar av testresultaten.

Övriga kommandon:
```bash
mvn jasmine:test
mvn test
```
