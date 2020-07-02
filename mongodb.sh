# start mongodb container
sudo docker run -it -v /Users/redhat/Documents/microservices/quarkus-code/hackathon/data:/mongodata -p 27017:27017 --name mongodb -d mongo
