Biggles
=======

Den här lilla webapplikationen är en testbänk för olika former av tester, främst på klientsidan.
För rena javascript-tester används Jasmine och för funktionella tester används Geb.

Applikationen är högst enkel och består av en databas med alla Biggles böcker som utgivits i Sverige,
en rest-tjänst för att söka i databasen och en web-front driven av AngularJS.

Databasen är H2 (en minnesdatabas skriven i Java) och populeras från en textfil vid uppstart av systemet.
Spring och SpringMVC driver restdelarna och det hela kompileras, testas och paketeras av Maven.

Verktyg och ramverk:
http://spring.io/

http://jackson.codehaus.org/
http://angularjs.org/
http://maven.apache.org/
http://www.gebish.org/
http://pivotal.github.io/jasmine/

Kom igång:
```bash
git clone https://github.com/emilb/biggles.git
cd biggles
mvn jetty:run
```

Surfa till: http://localhost:9080/

