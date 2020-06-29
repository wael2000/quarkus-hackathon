https://quarkus.io/guides/mongodb
run mongodb:
sudo docker run -it -v /Users/redhat/Documents/microservices/quarkus-code/hackathon/data:/mongodata -p 27017:27017 --name mongodb -d mongo

Quarkus guide: https://quarkus.io/guides/mongodb-panache


1 - to create new physician record

curl -X POST http://localhost:8080/physician \
    -H 'content-type: application/json' \
    -H 'accept: application/json' \
    -d  '{
    "address": {
        "country": "UAE",
        "address": "Dubai Mall",
        "city": "Dubai",
        "location": {
            "coordinates": [
                25.1973,
                55.2793
            ],
            "type": "Point"
        }
    },
    "education": [
        "MBBS from JSS Medical College, Mysore in 2005",
        "MS (Gen Surgery) from Mysore Medical College & Research Institute, Mysore in 2008",
        "M.Ch (Urology) from Vijayanagar Institute of Medical Sciences, Bellary in 2002"
    ],
    "experience": [
        "Senior Resident (Gen Surgery) at Bidar Institute of Medical Sciences, Bidar from 2008 - 2009",
        "Senior Resident (Urology) at Vijaynagar Institute of Medical Sciences, Bellary from July 2012 - Sept 2012",
        "Consultant (Urology & Andrology) at Ramayya Pramila Urology and Nephrology Institute & Hospitals, Hyderabad from Aug 2012 - Aug 2014",
        "Consultant Urologist at CARE Hospitals, Hyderabad From Sept 2014 OnWards"
    ],
    "expertise": [
        "Reconstructive Urology",
        "Retrograde Intra - Renal Surgery (RIRS)",
        "Micro and Mini PCNL with Laser Lithotripsy",
        "Laser Prostate Surgery",
        "Reconstructive Urology (Urethral Stricture Surgery)",
        "Endourology",
        "Laser stone and laser prostate surgery",
        "Laparoscopic urology",
        "Andrology",
        "Male infertility"
    ],
    "name": "nono",
    "speciality": [
        "Oncology"
    ]
}'


2 - to get list of physicians
curl -X GET http://localhost:8080/physician \
    -H 'content-type: application/json' \
    -H 'accept: application/json' 

3 - get physicians by id
curl -X GET http://localhost:8080/physician/{id} \
    -H 'content-type: application/json' \
    -H 'accept: application/json' 

Example    
http://localhost:8080/physician/5ef0c2c34d8e2f36b3ba3ce6


4 - search by name
curl -X GET http://localhost:8080/physician/search/{name} \
    -H 'content-type: application/json' \
    -H 'accept: application/json' 

Example
http://localhost:8080/physician/search/nono


5 - find physicians near by using speciality
curl -X POST http://localhost:8080/physician/nearBy/{distance} \
    -H 'content-type: application/json' \
    -H 'accept: application/json' \
    -d  '{ 
            "latitude" : 25.1973,
            "longitude" : 56.2793,
            "speciality" : ["Radiology"]
        }'

Example
http://localhost:8080/physician/nearBy/15