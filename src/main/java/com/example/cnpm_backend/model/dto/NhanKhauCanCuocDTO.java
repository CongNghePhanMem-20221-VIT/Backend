package com.example.cnpm_backend.model.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class NhanKhauCanCuocDTO {

    private int id;
    private int IDCC;
    private String CanCuoc;
    private String hoTen;
    private Date ngaySinh;

    private String nguyenQuan;

    private String danToc;

    private String quocTich;

    private String ngheNghiep;

    private String diaChiHienTai;

    private String diaChiThuongTru;

    private String gioiTinh;

    private Date ngayCap;

    private String noiCap;



}
