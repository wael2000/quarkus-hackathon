package org.acme.kogito.model;

public class Request {

    private Integer id;
    private String status;
    private String physician;


    @Override
    public String toString() {
        return "Request [id=" + id + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhysician() {
        return physician;
    }

    public void setPhysician(String physician) {
        this.physician = physician;
    }

}
