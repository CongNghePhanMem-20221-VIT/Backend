package com.example.cnpm_backend.model;

import jakarta.persistence.*;

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

    public GiaDinhModel(int id, String maGiaDinh, int idHoKhau, String hoTen, Date ngaySinh, String ngheNghiep, String quanHeVoiChuHo, String diaChiHienTai) {
        this.id = id;
        this.maGiaDinh = maGiaDinh;
        this.idHoKhau = idHoKhau;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.ngheNghiep = ngheNghiep;
        this.quanHeVoiChuHo = quanHeVoiChuHo;
        this.diaChiHienTai = diaChiHienTai;
    }

    public String getIdGiaDinh() {
        return maGiaDinh;
    }

    public void setIdGiaDinh(String idGiaDinh) {
        this.maGiaDinh = idGiaDinh;
    }

    public int getIdHoKhau() {
        return idHoKhau;
    }

    public void setIdHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
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
