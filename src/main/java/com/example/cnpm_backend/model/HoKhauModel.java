package com.example.cnpm_backend.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "hokhau")
public class HoKhauModel implements Serializable {
    private static final int serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHoKhau;

//    @Column(name="IDhokhau")
//    private int idHoKhau;
    @Column(name = "IDchuho")
    private int idChuHo;
    @Column(name = "diachi")
    private String diaChi;
    @Column(name = "ngaytao")
    private Date ngayTao;
    @Column(name = "IDkhuvuc")
    private String idKhuVuc;
    @Column(name = "Magiadinh")
    private String idGiaDinh;

    public HoKhauModel() {
    }

    public HoKhauModel(int idHoKhau, int idChuHo, String diaChi, Date ngayTao, String idKhuVuc, String idGiaDinh) {
        this.idHoKhau = idHoKhau;
        this.idChuHo = idChuHo;
        this.diaChi = diaChi;
        this.ngayTao = ngayTao;
        this.idKhuVuc = idKhuVuc;
        this.idGiaDinh = idGiaDinh;
    }

    public int getIdHoKhau() {
        return idHoKhau;
    }

    public void setIdHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
    }

    public int getIdChuHo() {
        return idChuHo;
    }

    public void setIdChuHo(int idChuHo) {
        this.idChuHo = idChuHo;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getIdKhuVuc() {
        return idKhuVuc;
    }

    public void setIdKhuVuc(String idKhuVuc) {
        this.idKhuVuc = idKhuVuc;
    }

    public String getIdGiaDinh() {
        return idGiaDinh;
    }

    public void setIdGiaDinh(String idGiaDinh) {
        this.idGiaDinh = idGiaDinh;
    }
}
