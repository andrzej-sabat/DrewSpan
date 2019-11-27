package com.drewSpan.drewSpan2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ewidencja_elementy")
public class EwidencjaElementy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_element")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "opt_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private OpTech opTech;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_indeksu")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private IndexOp indexOp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "e_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ewidencja ewidencja;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "KrMaszyny_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private KrMaszyny maszyna;

    @Column(name = "ilosc")
    private int ilosc;

    @Column(name = "czas")
    private int czas;

    @Column(name = "data")
    private Date data;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ewidencja getEwidencja() {
        return ewidencja;
    }

    public void setEwidencja(Ewidencja ewidencja) {
        this.ewidencja = ewidencja;
    }

    public KrMaszyny getMaszyna() {
        return maszyna;
    }

    public void setMaszyna(KrMaszyny maszyna) {
        this.maszyna = maszyna;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public int getCzas() {
        return czas;
    }

    public void setCzas(int czas) {
        this.czas = czas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
