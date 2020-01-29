package com.drewSpan.drewSpan2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Table(name = "kr_maszyny")
public class KrMaszyny {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "krm_id")
    private long krm_id;
    @Column(name = "krm_kod", length = 200, unique = true)
    private String krm_kod;
    @Column(name = "krm_nazwa")
    private String krm_nazwa;

    @OneToMany(mappedBy = "maszyna", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Ewidencja> ewidencja;

    public long getKrm_id() {
        return krm_id;
    }

    public void setKrm_id(long krm_id) {
        this.krm_id = krm_id;
    }

    public String getKrm_kod() {
        return krm_kod;
    }

    public void setKrm_kod(String krm_kod) {
        this.krm_kod = krm_kod;
    }

    public String getKrm_nazwa() {
        return krm_nazwa;
    }

    public void setKrm_nazwa(String krm_nazwa) {
        this.krm_nazwa = krm_nazwa;
    }
}
