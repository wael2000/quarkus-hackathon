# medical case request microservice
https://quarkus.io/guides/hibernate-search-elasticsearch
https://quarkus.io/guides/hibernate-orm-panache


This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `quarkus-getting-started-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/quarkus-getting-started-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/quarkus-getting-started-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.



# build OCP app
# To build the image on OpenShift
oc new-app registry.access.redhat.com/ubi8/openjdk-11:latest~https://github.com/wael2000/quarkus-hackathon.git --context-dir=cases --name=cases

oc logs -f bc/cases

# To create the route
oc expose svc/quarkus-quickstart

# Get the route URL
export URL="http://$(oc get route | grep quarkus-quickstart | awk '{print $2}')"
curl $URL/hello/greeting/quarkus


To test the application 


1 - Submit new case 
curl -X POST http://localhost:8080/cases \
    -H 'content-type: application/json' \
    -H 'accept: application/json' \
    -d '{
        "date": "2020-05-31T20:00:00Z[UTC]",
        "description": "Stomach111111",
        "patientDOB": "1975-05-01",
        "patientGender": "Femaleaaaaaaa",
        "patientName": "tota Helmy",
        "patientNationality": "Irish",
        "reports": [
        {
        "type": "PCR test",
        "link":"http://download.me/r001",
        "date" : "2020-06-11T20:00:00Z[UTC]"
        },
        {
        "type": "MRI - 01",
        "link":"http://download.me/r002",
        "date" : "2020-06-11T20:00:00Z[UTC]"
        }
        ],
        "symptoms": "diarrhea, Gas"
        }'

2 - update existing case 
curl -X POST http://localhost:8080/cases/2 \
    -H 'content-type: application/json' \
    -H 'accept: application/json' \
    -d '{
        "id" : "2",
        "date": "2020-05-31T20:00:00Z[UTC]",
        "description": "Stomach111111",
        "patientDOB": "1975-05-01",
        "patientGender": "Femaleaaaaaaa",
        "patientName": "tota Helmy",
        "patientNationality": "Irish",
        "reports": [
        {
        "id" : 3,
        "type": "PCR test",
        "link":"http://download.me/r001",
        "date" : "2020-06-11T20:00:00Z[UTC]"
        },
        {
        "id" : 11,
        "type": "MRI - 01",
        "link":"http://download.me/r002",
        "date" : "2020-06-11T20:00:00Z[UTC]"
        }
        ],
        "symptoms": "diarrhea, Gas"
        }

3 - delete case
curl -X DELETE http://localhost:8080/cases/10 \
    -H 'content-type: application/json' \
    -H 'accept: application/json'

4 - get list of cases 
curl -X GET http://localhost:8080/cases \
    -H 'content-type: application/json' \
    -H 'accept: application/json'