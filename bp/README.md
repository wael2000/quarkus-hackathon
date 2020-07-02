# medical case business process microservice

This project uses Quarkus, and Kogito to handle the medical case workflow (Process)
implemenating below process

                                              [------------------]
                                      |-- No -| Assign physician |--|
                [-----------------]   |       [------------------]  |    [-----------------]
    {start}---->| check physician |---<>                            <>---| case assessment |-->{end}
                [-----------------]   |                             |    [-----------------]
                                      |-- Yes ----------------------|

with Built-in OpenAPI specs and Swagger-UI

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

## To test functionality 
Check swagger documentation on below URL
http://localhost:8080/swagger-ui/

1 - Create processes instance wiating for assessment as physician is passed 
curl -X POST http://localhost:8080/requests \
    -H 'content-type: application/json' \
    -H 'accept: application/json' \
    -d '{"request": { "id":1, "physician" : "Wael" }}'

below is  the process path
                                              [------------------]
                                      |-- No -| Assign physician |--|
                [=================]   |       [------------------]  |    [=================]
    {start}====>| check physician |===<>                            <>===| case assessment |==>{end}
                [=================]   |                             |    [=================]
                                      |== Yes ======================|

1 - Create processes instance wiating for physician assignment physician is passed 
curl -X POST http://localhost:8080/requests \
    -H 'content-type: application/json' \
    -H 'accept: application/json' \
    -d '{"request": { "id":2}}'

below is  the process path
                                              [==================]
                                      |== No =| Assign physician |==|
                [=================]   |       [==================]  |    [=================]
    {start}====>| check physician |===<>                            <>===| case assessment |==>{end}
                [=================]   |                             |    [=================]
                                      |-- Yes ----------------------|

3 - once a process instance created, below reponse expected
{
    "id": "3173ed77-9e5e-4f41-8362-6298af33e0e3",
    "request": {
        "id": 3
    }
}

4 - we cab query all process instances using 
curl -X GET http://localhost:8080/requests \
    -H 'content-type: application/json' \
    -H 'accept: application/json'

expected response 

[
    {"id":"3173ed77-9e5e-4f41-8362-6298af33e0e3","request":{"id":3,"physician":"Ali Ali Ali","status":"Assigned"}},
    {"id":"4a9f540d-e403-4756-bbd5-19f779985012","request":{"id":1,"status":"Assigned"}}, 
    {"id":"96d381bc-0129-4087-a25c-179a962e3488","request":{"id":1,"physician":"Wael","status":"Assigned"}}
]

5 - to get process tasks 

curl -X GET http://localhost:8080/requests/{process-id}/tasks \
    -H 'content-type: application/json' \
    -H 'accept: application/json'

expected response 

{
b4522309-b5c0-404e-9d1d-0f00b2c5933e: "CaseAssessment"
}

6 - to get task details 
curl -X GET http://localhost:8080/requests/{process-id}/{task-name}/{task-id} \
    -H 'content-type: application/json' \
    -H 'accept: application/json'

example URL: 
http://localhost:8080/requests/3173ed77-9e5e-4f41-8362-6298af33e0e3/CaseAssessment/b4522309-b5c0-404e-9d1d-0f00b2c5933e

expected response 
{   "id":"b4522309-b5c0-404e-9d1d-0f00b2c5933e",
    "name":"CaseAssessment",
    "request":{
        "id":3,
        "physician":"Ali",
        "status":"Assigned"
    }
}

7 - to act on a task
curl -X POST http://localhost:8080/requests/{process-id}/{task-name}/{task-id} \
    -H 'content-type: application/json' \
    -H 'accept: application/json'
    -d '{ "id": "{task-id}", "name": "AssignPhysician", "request": { "id": 3, "physician" : "Ali", "status": "Assigned"}}'

example
http://localhost:8080/requests/3173ed77-9e5e-4f41-8362-6298af33e0e3/AssignPhysician/687e14d3-88c2-466d-b5a5-e0dcfd740b8a
