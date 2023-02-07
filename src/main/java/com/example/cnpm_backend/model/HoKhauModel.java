package com.example.cnpm_backend.model;

import java.util.Date;

public class HoKhauModel {
    private int idHoKhau;
    private int idChuHo;
    private String diaChi;
    private Date ngayTao;
    private String idKhuVuc;
    private String idGiaDinh;

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
