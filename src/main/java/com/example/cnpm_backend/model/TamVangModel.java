package com.example.cnpm_backend.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tamvang")
public class TamVangModel implements Serializable {
    private static final int serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idcancuoc")
    private int idcc;

    @Column(name = "ngaybatdau")
    private Date ngayBatDau;

    @Column(name = "ngayketthuc")
    private Date ngayKetThuc;

    @Column(name = "lydo")
    private String lyDo;

    @Column(name = "sodt")
    private String soDT;

    @Column(name = "matamvang")
    private String maTamVang;

    public TamVangModel() {
        id = 0;
    }

    public TamVangModel(int id, int idcc, Date ngayBatDau, Date ngayKetThuc, String lyDo, String soDT, String maTamVang) {
        this.id = id;
        this.idcc = idcc;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.lyDo = lyDo;
        this.soDT = soDT;
        this.maTamVang = maTamVang;
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

    public String getMaTamVang() {
        return maTamVang;
    }

    public void setMaTamVang(String maTamVang) {
        this.maTamVang = maTamVang;
    }
}
