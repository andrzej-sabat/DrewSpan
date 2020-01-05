package com.drewSpan.drewSpan2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WydajnoscElement {

    @Id @GeneratedValue
    private Long id;
    private Long opt_id;
    private Long id_indeksu;
    private Double wydajnosc;

    public WydajnoscElement(Long opt_id, Long id_indeksu, Double wydajnosc) {
        this.opt_id = opt_id;
        this.id_indeksu = id_indeksu;
        this.wydajnosc = wydajnosc;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOpt_id() {
        return opt_id;
    }

    public void setOpt_id(Long opt_id) {
        this.opt_id = opt_id;
    }

    public Long getId_indeksu() {
        return id_indeksu;
    }

    public void setId_indeksu(Long id_indeksu) {
        this.id_indeksu = id_indeksu;
    }

    public Double getWydajnosc() {
        return wydajnosc;
    }

    public void setWydajnosc(Double wydajnosc) {
        this.wydajnosc = wydajnosc;
    }
}


