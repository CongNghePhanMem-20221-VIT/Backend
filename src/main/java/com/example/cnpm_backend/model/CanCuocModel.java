package com.example.cnpm_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "cancuoc")
public class CanCuocModel {
    @Id
    @Column(name = "idcc")
    private String IDCC;

    @Column(name = "ngaycap")
    private Date ngayCap;
    @Column(name = "noicap")
    private String noiCap;

    public CanCuocModel(String IDCC, Date ngayCap, String noiCap) {
        this.IDCC = IDCC;
        this.ngayCap = ngayCap;
        this.noiCap = noiCap;
    }

    public CanCuocModel() {

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
