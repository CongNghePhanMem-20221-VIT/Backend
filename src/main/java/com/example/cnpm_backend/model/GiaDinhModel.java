package com.example.cnpm_backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "giadinh")
public class GiaDinhModel implements Serializable {
    private static final int serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "magiadinh")
    private String maGiaDinh;
    @Column(name = "idhokhau")
    private int idHoKhau;

    @Column(name = "idnhankhau")
    private int idNhanKhau;
    @Column(name = "hoten")
    private String hoTen;
    @Column(name = "ngaysinh")
    private Date ngaySinh;
    @Column(name = "nghenghiep")
    private String ngheNghiep;
    @Column(name = "quanhevoichuho")
    private String quanHeVoiChuHo;
    @Column(name = "diachihientai")
    private String diaChiHienTai;

    public GiaDinhModel() {
        id = 0;
    }

    public GiaDinhModel(int id, String maGiaDinh, int idHoKhau, int idNhanKhau, String hoTen, Date ngaySinh, String ngheNghiep, String quanHeVoiChuHo, String diaChiHienTai) {
        this.id = id;
        this.maGiaDinh = maGiaDinh;
        this.idHoKhau = idHoKhau;
        this.idNhanKhau = idNhanKhau;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.ngheNghiep = ngheNghiep;
        this.quanHeVoiChuHo = quanHeVoiChuHo;
        this.diaChiHienTai = diaChiHienTai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaGiaDinh() {
        return maGiaDinh;
    }

    public void setMaGiaDinh(String maGiaDinh) {
        this.maGiaDinh = maGiaDinh;
    }

    public int getIdHoKhau() {
        return idHoKhau;
    }

    public void setIdHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
    }

    public int getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(int idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getQuanHeVoiChuHo() {
        return quanHeVoiChuHo;
    }

    public void setQuanHeVoiChuHo(String quanHeVoiChuHo) {
        this.quanHeVoiChuHo = quanHeVoiChuHo;
    }

    public String getDiaChiHienTai() {
        return diaChiHienTai;
    }

    public void setDiaChiHienTai(String diaChiHienTai) {
        this.diaChiHienTai = diaChiHienTai;
    }
}
