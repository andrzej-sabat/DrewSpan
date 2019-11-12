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

}
