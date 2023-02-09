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

    @Column(name = "phanthuong")
    private int phanThuong;

    @Column(name = "idgiaithuong")
    private int idGiaiThuong;

    public CapThuongModel() {
        id = 0;
    }

    public CapThuongModel(int id, int idNhanKhau, int phanThuong, int idGiaiThuong) {
        this.id = id;
        this.idNhanKhau = idNhanKhau;
        this.phanThuong = phanThuong;
        this.idGiaiThuong = idGiaiThuong;
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

    public int getPhanThuong() {
        return phanThuong;
    }

    public void setPhanThuong(int phanThuong) {
        this.phanThuong = phanThuong;
    }

    public int getIdGiaiThuong() {
        return idGiaiThuong;
    }

    public void setIdGiaiThuong(int idGiaiThuong) {
        this.idGiaiThuong = idGiaiThuong;
    }
}
