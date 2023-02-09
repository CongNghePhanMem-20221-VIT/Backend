package com.example.cnpm_backend.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "giatien")
public class GiaTienModel implements Serializable {
    private static final int serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sanpham")
    private String sanPham;

    @Column(name = "giatien")
    private int giatien;

    @Column(name = "soluong")
    private int soLuong;

    @Column(name = "idgiaithuong")
    private int idGiaiThuong;

    public GiaTienModel() {
        id = 0;
    }

    public GiaTienModel(int id, String sanPham, int giatien, int soLuong, int idGiaiThuong) {
        this.id = id;
        this.sanPham = sanPham;
        this.giatien = giatien;
        this.soLuong = soLuong;
        this.idGiaiThuong = idGiaiThuong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSanPham() {
        return sanPham;
    }

    public void setSanPham(String sanPham) {
        this.sanPham = sanPham;
    }

    public int getGiatien() {
        return giatien;
    }

    public void setGiatien(int giatien) {
        this.giatien = giatien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getIdGiaiThuong() {
        return idGiaiThuong;
    }

    public void setIdGiaiThuong(int idGiaiThuong) {
        this.idGiaiThuong = idGiaiThuong;
    }
}
