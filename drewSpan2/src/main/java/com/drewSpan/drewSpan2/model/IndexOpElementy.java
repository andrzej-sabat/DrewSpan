package com.drewSpan.drewSpan2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @JoinColumn(name = "opt_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private OpTech opTech;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_indeksu")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private IndexOp indexOp;

    @Column(name = "Czas")
    private long czas;

    @Column(name = "wspK")
    private double wspK;


}
