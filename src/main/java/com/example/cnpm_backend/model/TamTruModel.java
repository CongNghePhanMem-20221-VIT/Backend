package com.example.cnpm_backend.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tamtru")
public class TamTruModel implements Serializable {
    private static final int serialVersionUID = 1;

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "IDcancuoc")
    private int idcc;

    @Column(name = "ngaybatdau")
    private Date ngayBatDau;

    @Column(name = "ngayketthuc")
    private Date ngayKetThuc;

    @Column(name = "lydo")
    private String lyDo;

    @Column(name = "soDT")
    private String soDT;

    @Column(name = "matamtru")
    private String maTamTru;

    public TamTruModel() {
        id = 0;
    }

    public TamTruModel(int id, int idcc, Date ngayBatDau, Date ngayKetThuc, String lyDo, String soDT, String maTamTru) {
        this.id = id;
        this.idcc = idcc;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.lyDo = lyDo;
        this.soDT = soDT;
        this.maTamTru = maTamTru;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcc() {
        return idcc;
    }

    public void setIdcc(int idcc) {
        this.idcc = idcc;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getMaTamTru() {
        return maTamTru;
    }

    public void setMaTamTru(String maTamTru) {
        this.maTamTru = maTamTru;
    }
}
