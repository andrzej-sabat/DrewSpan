package com.drewSpan.drewSpan2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

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
}



