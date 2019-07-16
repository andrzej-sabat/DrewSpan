package com.drewSpan.drewSpan2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "index_opElementy")
public class IndexOpElementy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "i_op_e_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @EqualsAndHashCode.Exclude
    private OpTech opTech;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @EqualsAndHashCode.Exclude
    private IndexOp indexOp;

    @Column(name = "Czas")
    private long czas;

    @Column(name = "wspK")
    private double wspK;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OpTech getOpTech() {
        return opTech;
    }

    public void setOpTech(OpTech opTech) {
        this.opTech = opTech;
    }

    public IndexOp getIndexOp() {
        return indexOp;
    }

    public void setIndexOp(IndexOp indexOp) {
        this.indexOp = indexOp;
    }



    public long getCzas() {
        return czas;
    }

    public void setCzas(long czas) {
        this.czas = czas;
    }

    public double getWspK() {
        return wspK;
    }

    public void setWspK(double wspK) {
        this.wspK = wspK;
    }

    @Override
    public String toString() {
        return "IndexOpElementy{" +
                "id=" + id +
               // ", opTech=" + opTech +
              //  ", indexOp=" + indexOp +
                ", czas=" + czas +
                ", wspK=" + wspK +
                '}';
    }


}
