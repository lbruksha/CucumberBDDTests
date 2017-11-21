Cucumber BDD Tests
=========================

1. Right-click to 'execute' any of the .feature files in the src/test/resources folder
2. Alternately, you can create a Run Configuration to run tagged scenarios (e.g. smoke) by passing 
the following program arguments: '--plugin html:output --tags @smoke --glue src/test/groovy/com/eodessa src/test/resources' and setting the Main class to 'cucumber.api.cli.Main'

Geb manual
=========================
http://www.gebish.org/manual/current/

API rest assured test execution
=========================
gradle test -Dserver.port=80 -Dserver.host=https://api.eodessa.com