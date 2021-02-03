# start mongodb container
sudo docker run -it -v /Users/redhat/Documents/microservices/quarkus-code/hackathon/data:/mongodata -p 27017:27017 --name mongodb -d mongo
# start keycloak
sudo docker run -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=P@ssw0rd -p 8180:8080 jboss/keycloak

# API registry
docker run -it -p 8280:8080 apicurio/apicurio-registry-mem
