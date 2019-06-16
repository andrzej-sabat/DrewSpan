package com.drewSpan.drewSpan2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@Entity
@Table(name = "op_tech")
public class OpTech {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "opT_Id")
    private long id;
    @Column(name = "opT_Kod")
    private String kod;
    @Column(name = "opT_Nazwa")
    private String nazwa;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}



