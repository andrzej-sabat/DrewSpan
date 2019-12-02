package com.drewSpan.drewSpan2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ewidencja")
public class Ewidencja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "e_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @EqualsAndHashCode.Exclude @ToString.Exclude private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "kr_maszyny_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @EqualsAndHashCode.Exclude @ToString.Exclude private KrMaszyny maszyna;

    @Column(name = "e_Zmiana")
    private int zmiana;

    @Column(name = "e_CzasPracy")
    private int czas_pracy;

    @Column(name = "e_Data")
    @DateTimeFormat(pattern="dd-MM-yyyy")
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public KrMaszyny getMaszyna() {
        return maszyna;
    }

    public void setMaszyna(KrMaszyny maszyna) {
        this.maszyna = maszyna;
    }

    public int getZmiana() {
        return zmiana;
    }

    public void setZmiana(int zmiana) {
        this.zmiana = zmiana;
    }


    public int getCzas_pracy() {
        return czas_pracy;
    }

    public void setCzas_pracy(int czas_pracy) {
        this.czas_pracy = czas_pracy;
    }

    @DateTimeFormat(pattern="dd-MM-yyyy")
    public Date getData() {
        return data;
    }
    @DateTimeFormat(pattern="dd-MM-yyyy")
    public void setData(Date data) {
        this.data = data;
    }


}
