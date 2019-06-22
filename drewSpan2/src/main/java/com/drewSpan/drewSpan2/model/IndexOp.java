package com.drewSpan.drewSpan2.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "index_op")
public class IndexOp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_indeksu")
    private long id_indeksu;
    @Column(name = "i_kod")
    private String i_kod;
    @Column(name = "i_nazwa")
    private String i_nazwa;


    public long getId_indeksu() {
        return id_indeksu;
    }

    public void setId_indeksu(long id_indeksu) {
        this.id_indeksu = id_indeksu;
    }

    public String getI_kod() {
        return i_kod;
    }

    public void setI_kod(String i_kod) {
        this.i_kod = i_kod;
    }

    public String getI_nazwa() {
        return i_nazwa;
    }

    public void setI_nazwa(String i_nazwa) {
        this.i_nazwa = i_nazwa;
    }
}
