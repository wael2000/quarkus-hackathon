package org.acme.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.bson.codecs.pojo.annotations.BsonProperty;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
/**
 {
    "id": "5eedf94a51a9cc4f4cd52220",
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
    "name": "nono ibrahim",
    "speciality": [
        "Oncology"
    ]
 }  
 */


@MongoEntity(collection = "Physician")
public class Physician extends PanacheMongoEntity {
    public String name;

    @BsonProperty("birth")
    public LocalDate birthDate;
    public String qualifications;
    public Status status;
    public List<String> education;
    public List<String> expertise;
    public List<String> experience;
    public List<String> speciality;
    public List<String> awards;
    public List<String> publications;
    public List<String> memberships;
    public Map address;
    public String image;
    /** address 
    {
        "country": "UAE",
        "city": "Dubai",
        "address": "Dubai Mall",
        "location": {
          "type": "Point",
          "coordinates": [
            25.1973,//latitude
            55.2793 //longitude
          ]
        }
    }
    */

    // return name as lowercase in the model
    public String getName() {
        return name.toLowerCase();
    }

    // store all names in uppercase in the DB
    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    // entity methods
    public static Physician findByName(String name) {
        return find("name", name).firstResult();
    }

    public static List<Physician> findActive() {
        return list("status", Status.ACTIVE);
    }

    public static List<Physician> findNearBy(Double distance, Map params) {
        //The equatorial radius of the Earth is approximately 3,963.2 miles or 6,378.1 kilometers.
        //Double distanceinRadius = distance / 3963.2;
        Double distanceinRadius = distance/6378.1;
        String specialityFilter="$or: [ { 'speciality' : {not : \"\"}} ";
        if(params.get("speciality")!=null){
            for(String speciality : (List<String>) params.get("speciality")){
                specialityFilter += ",{'speciality' : \"" + speciality + "\"}";
            }
        }
        specialityFilter += "]";
        String nearByFilter="";
        if(params!=null && params.get("latitude")!=null && params.get("longitude")!=null)
            nearByFilter = ", 'address.location.coordinates':{'$geoWithin':{'$centerSphere':[[ " + params.get("latitude") + "," + params.get("longitude") +"], " + distanceinRadius +"]}}";
        return list("{" + specialityFilter + nearByFilter + "}");
    }

    public static void deleteLoics() {
        delete("name", "Loïc");
    }
}
