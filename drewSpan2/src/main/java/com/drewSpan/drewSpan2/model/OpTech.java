package com.drewSpan.drewSpan2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import javax.persistence.*;
import java.util.Set;
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Data
@Entity
@Table(name = "op_tech")
public class OpTech implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "opt_id")
    private long opt_id;
    @Column(name = "opt_kod")
    private String opt_kod;
    @Column(name = "opt_nazwa")
    private String opt_nazwa;

    @JsonIgnore
    @OneToMany(mappedBy = "opTech", cascade = CascadeType.ALL)
    private Set<IndexOpElementy> indexOpElementies;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getOpt_id() {
        return opt_id;
    }

    public void setOpt_id(long opt_id) {
        this.opt_id = opt_id;
    }

    public String getOpt_kod() {
        return opt_kod;
    }

    public void setOpt_kod(String opt_kod) {
        this.opt_kod = opt_kod;
    }

    public String getOpt_nazwa() {
        return opt_nazwa;
    }

    public void setOpt_nazwa(String opt_nazwa) {
        this.opt_nazwa = opt_nazwa;
    }

    public Set<IndexOpElementy> getIndexOpElementies() {
        return indexOpElementies;
    }

    public void setIndexOpElementies(Set<IndexOpElementy> indexOpElementies) {
        this.indexOpElementies = indexOpElementies;
    }

    @Override
    public String toString() {
        return "OpTech{" +
                "opt_id=" + opt_id +
                ", opt_kod='" + opt_kod + '\'' +
                ", opt_nazwa='" + opt_nazwa +
                '}';
    }



}



