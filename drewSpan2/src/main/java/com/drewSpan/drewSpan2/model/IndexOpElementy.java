package com.drewSpan.drewSpan2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToMany(mappedBy = "indexOpElementy", cascade = CascadeType.ALL)
    private Set<OpTech> opTech;

    @OneToMany(mappedBy = "indexOpElementy", cascade = CascadeType.ALL)
    private Set<IndexOp> indexOp;

    @Column(name = "Czas")
    private long czas;

    @Column(name = "wspK")
    private double wspK;


}
