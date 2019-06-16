package com.drewSpan.drewSpan2.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "index_op")
public class IndexOp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Indeksu")
    private long id;
    @Column(name = "i_Kod")
    private String kod;
    @Column(name = "i_Nazwa")
    private String nazwa;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
