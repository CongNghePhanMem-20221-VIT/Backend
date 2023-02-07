package com.example.cnpm_backend.model;

import java.util.Date;

public class CanCuocModel {
    private String IDCC;
    private Date ngayCap;
    private String noiCap;

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
