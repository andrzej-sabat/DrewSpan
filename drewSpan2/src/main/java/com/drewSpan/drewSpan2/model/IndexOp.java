package com.drewSpan.drewSpan2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Data
@Entity
@Table(name = "index_op")
public class IndexOp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_indeksu")
    private long id_indeksu;
    @Column(name = "i_kod", length = 200 ,unique = true)
    private String i_kod;
    @Column(name = "i_nazwa", length = 200 , unique = true)
    private String i_nazwa;

    @JsonIgnore
    @OneToMany(mappedBy = "indexOp", cascade = CascadeType.ALL)
    private Set<IndexOpElementy> indexOpElementies;




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

    public Set<IndexOpElementy> getIndexOpElementies() {
        return indexOpElementies;
    }

    public void setIndexOpElementies(Set<IndexOpElementy> indexOpElementies) {
        this.indexOpElementies = indexOpElementies;
    }

    @Override
    public String toString() {
        return "IndexOp{" +
                "id_indeksu=" + id_indeksu +
                ", i_kod='" + i_kod + '\'' +
                ", i_nazwa='" + i_nazwa +
                '}';
    }
}
