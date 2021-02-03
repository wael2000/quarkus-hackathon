# start all microservices
mvn quarkus:dev -f physicians/pom.xml
mvn quarkus:dev -f cases/pom.xml
mvn quarkus:dev -f bp/pom.xml
mvn quarkus:dev -f composite/pom.xml
mvn quarkus:dev -f ui/pom.xml
