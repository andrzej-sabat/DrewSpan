package com.drewSpan.drewSpan2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wydajnosc {

    @Id
    private Long id;
    private Long user_id;
    private String knt_nazwisko;
    private String data;
    private Double wydajnosc;

    public Wydajnosc(Long user_id, String knt_nazwisko, String data, Double wydajnosc) {
        this.user_id = user_id;
        this.knt_nazwisko = knt_nazwisko;
        this.data = data;
        this.wydajnosc = wydajnosc;
    }

    public Wydajnosc(Long user_id, String knt_nazwisko, Double wydajnosc) {
        this.user_id = user_id;
        this.knt_nazwisko = knt_nazwisko;
        this.wydajnosc = wydajnosc;
    }

    public Wydajnosc() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getKnt_nazwisko() {
        return knt_nazwisko;
    }

    public void setKnt_nazwisko(String knt_nazwisko) {
        this.knt_nazwisko = knt_nazwisko;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getWydajnosc() {
        return wydajnosc;
    }

    public void setWydajnosc(Double wydajnosc) {
        this.wydajnosc = wydajnosc;
    }
}


