package com.example.cnpm_backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HoKhauGiaDinhCanCuocDTO {
    private int id;

    private String diaChi;

    private Date ngayTao;

    private String idKhuVuc;

    private String idGiaDinh;

    private String hoTen;

    private Date ngaySinh;

    private String ngheNghiep;

    private String quanHeVoiChuHo;

    private String diaChiHienTai;

    private String canCuoc;



}
