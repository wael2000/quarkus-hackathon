package org.acme.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.ManyToOne;
import java.util.Date;


@Entity
@Table(name="report")
@NamedQuery(name = "Reports.findAll", query = "SELECT r FROM Report r ORDER BY r.id", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
@Cacheable
public class Report {
    
    @Id
    @SequenceGenerator(name = "reportsSequence", sequenceName = "known_report_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reportsSequence")
    private Integer id;
    private String type;
    private Date date;
    private String link;

    @ManyToOne
    @JsonbTransient 
    public MedicalCase medicalCase;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public MedicalCase getMedicalCase() {
        return medicalCase;
    }

    public void setMedicalCase(MedicalCase medicalCase) {
        this.medicalCase = medicalCase;
    }

}