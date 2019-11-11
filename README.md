# UI tests 
## BaseURL:
http://automationpractice.com/index.php

## Docker:
In order to run Zalenium:
- cd {project.direcotory}/docker 
- docker-compose up

## Running commands:
### Generate report after test execution:
* mvn allure:report

### Run test for custom environment configuration (prod in this case):
* mvn clean install test -Ddriver=firefox -Dremote=true -Dconfig=prod -Pparallel

### Run test locally for specified browser (chrome is a default) using sequential execution
* mvn clean install test -Ddriver=firefox
* mvn clean install test 

### Run test locally with specified browser using parallel execution:
* mvn clean install test -Ddriver=chrome -Pparallel
* mvn clean install test -Ddriver=firefox -Pparallel

### Run test on remote docker environment with specified browser using parallel execution:
* mvn clean install test -Ddriver=firefox -Dremote=true -Pparallel
* mvn clean install test -Ddriver=chrome -Dremote=true -Pparallel
