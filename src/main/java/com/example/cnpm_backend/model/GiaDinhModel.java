package com.example.cnpm_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "giadinh")
public class GiaDinhModel {
    @Id
    @Column(name = "id")
    private String idGiaDinh;
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
    }

    public GiaDinhModel(String idGiaDinh, int idHoKhau, String hoTen, Date ngaySinh, String ngheNghiep, String quanHeVoiChuHo, String diaChiHienTai) {
        this.idGiaDinh = idGiaDinh;
        this.idHoKhau = idHoKhau;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.ngheNghiep = ngheNghiep;
        this.quanHeVoiChuHo = quanHeVoiChuHo;
        this.diaChiHienTai = diaChiHienTai;
    }

    public String getIdGiaDinh() {
        return idGiaDinh;
    }

    public void setIdGiaDinh(String idGiaDinh) {
        this.idGiaDinh = idGiaDinh;
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
