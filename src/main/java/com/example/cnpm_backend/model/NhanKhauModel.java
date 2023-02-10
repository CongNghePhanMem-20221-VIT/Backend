package com.example.cnpm_backend.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "nhankhau")
public class NhanKhauModel implements Serializable {
    private static int serialVersionUID = 1;
    @Id
    @Column(name="ID")
    private int id;

    @Column(name = "IDcancuoc")
    private String IDCC;
    @Column(name = "hoten")
    private String hoTen;
    @Column(name = "ngaysinh")
    private Date ngaySinh;
    @Column(name = "nguyenquan")
    private String nguyenQuan;
    @Column(name = "dantoc")
    private String danToc;
    @Column(name = "quoctich")
    private String quocTich;
    @Column(name = "nghenghiep")
    private String ngheNghiep;
    @Column(name = "diachihientai")
    private String diaChiHienTai;
    @Column(name = "diachithuongtru")
    private String diaChiThuongTru;
    @Column(name = "gioitinh")
    private String gioiTinh;

    public NhanKhauModel() {
    }

    public NhanKhauModel(int id,String IDCC, String hoTen, Date ngaySinh, String nguyenQuan, String danToc, String quocTich, String ngheNghiep, String diaChiHienTai, String diaChiThuongTru, String gioiTinh) {
        this.id = id;
        this.IDCC = IDCC;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.nguyenQuan = nguyenQuan;
        this.danToc = danToc;
        this.quocTich = quocTich;
        this.ngheNghiep = ngheNghiep;
        this.diaChiHienTai = diaChiHienTai;
        this.diaChiThuongTru = diaChiThuongTru;
        this.gioiTinh = gioiTinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getIDCC() {
        return IDCC;
    }

    public void setIDCC(String IDCC) {
        this.IDCC = IDCC;
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

    public String getNguyenQuan() {
        return nguyenQuan;
    }

    public void setNguyenQuan(String nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getDiaChiHienTai() {
        return diaChiHienTai;
    }

    public void setDiaChiHienTai(String diaChiHienTai) {
        this.diaChiHienTai = diaChiHienTai;
    }

    public String getDiaChiThuongTru() {
        return diaChiThuongTru;
    }

    public void setDiaChiThuongTru(String diaChiThuongTru) {
        this.diaChiThuongTru = diaChiThuongTru;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
