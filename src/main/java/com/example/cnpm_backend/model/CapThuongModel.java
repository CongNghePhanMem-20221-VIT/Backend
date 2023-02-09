package com.example.cnpm_backend.model;

import jakarta.persistence.*;
import org.springframework.core.SpringVersion;

import java.io.Serializable;

@Entity
@Table(name = "capthuong")
public class CapThuongModel implements Serializable {
    private static final int serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idnhankhau")
    private int idNhanKhau;

    @Column(name = "tienthuong")
    private int tienThuong;

    @Column(name = "sach")
    private int sach;

    @Column(name = "vo")
    private int vo;

    @Column(name = "qua")
    private int qua;

    @Column(name = "idgiaithuong")
    private int idGiaiThuong;

    @Column(name = "thanhtich")
    private String thanhTich;

    public CapThuongModel() {
        id = 0;
    }

    public CapThuongModel(int id, int idNhanKhau, int tienThuong, int sach, int vo, int qua, int idGiaiThuong, String thanhTich) {
        this.id = id;
        this.idNhanKhau = idNhanKhau;
        this.tienThuong = tienThuong;
        this.sach = sach;
        this.vo = vo;
        this.qua = qua;
        this.idGiaiThuong = idGiaiThuong;
        this.thanhTich = thanhTich;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(int idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }

    public int getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(int tienThuong) {
        this.tienThuong = tienThuong;
    }

    public int getSach() {
        return sach;
    }

    public void setSach(int sach) {
        this.sach = sach;
    }

    public int getVo() {
        return vo;
    }

    public void setVo(int vo) {
        this.vo = vo;
    }

    public int getQua() {
        return qua;
    }

    public void setQua(int qua) {
        this.qua = qua;
    }

    public int getIdGiaiThuong() {
        return idGiaiThuong;
    }

    public void setIdGiaiThuong(int idGiaiThuong) {
        this.idGiaiThuong = idGiaiThuong;
    }

    public String getThanhTich() {
        return thanhTich;
    }

    public void setThanhTich(String thanhTich) {
        this.thanhTich = thanhTich;
    }
}
