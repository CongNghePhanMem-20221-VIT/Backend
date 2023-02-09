package com.example.cnpm_backend.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cancuoc")
public class CanCuocModel implements Serializable {
    private static final int serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idcc")
    private String IDCC;

    @Column(name = "ngaycap")
    private Date ngayCap;
    @Column(name = "noicap")
    private String noiCap;

    public CanCuocModel(int id, String IDCC, Date ngayCap, String noiCap) {
        this.id = id;
        this.IDCC = IDCC;
        this.ngayCap = ngayCap;
        this.noiCap = noiCap;
    }

    public CanCuocModel() {
        id = 0;
    }

    public String getIDCC() {
        return IDCC;
    }

    public void setIDCC(String IDCC) {
        this.IDCC = IDCC;
    }

    public Date getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    public String getNoiCap() {
        return noiCap;
    }

    public void setNoiCap(String noiCap) {
        this.noiCap = noiCap;
    }
}
