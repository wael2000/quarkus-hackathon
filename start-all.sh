# start all microservices
physicians/mvnw quarkus:dev -f physicians/pom.xml
cases/mvnw quarkus:dev -f cases/pom.xml
bp/mvnw quarkus:dev -f bp/pom.xml
composite/mvnw quarkus:dev -f composite/pom.xml
ui/mvnw quarkus:dev -f ui/pom.xml