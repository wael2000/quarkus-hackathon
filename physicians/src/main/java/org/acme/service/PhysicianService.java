package org.acme.service;

import org.bson.types.ObjectId;
import java.util.List;
import org.acme.model.Physician;


public class PhysicianService {


    public List<Physician> list() {
        return Physician.listAll();
    }

    public Physician get(String id) {
        return Physician.findById(new ObjectId(id));
    }

    public Physician create(Physician physician) {
        physician.persist();
        return physician;
    }


    public Physician update(Physician physician) {
        physician.update();
        return physician;
    }

    public void delete(String id) {
        Physician physician = Physician.findById(new ObjectId(id));
        physician.delete();
    }

    public Physician search(String name) {
        return Physician.findByName(name);
    }

    public Long count() {
        return Physician.count();
    }
    
}