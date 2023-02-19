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

public class CapThuongNhanKhauDTO {

    private int id;

    private String IDCC;

    private String hoTen;

    private String gioiTinh;

    private Date ngaySinh;

    private String diaChiHienTai;

    private String diaChiThuongTru;

    private String thanhTich;

    private int tienThuong;

    private int sach;

    private int vo;

    private int qua;

}

