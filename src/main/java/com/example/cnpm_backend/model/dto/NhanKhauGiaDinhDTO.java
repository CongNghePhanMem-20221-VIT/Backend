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
public class NhanKhauGiaDinhDTO {

    private int id;
    private int IDCC;

    private String hoTen;
    private Date ngaySinh;

    private String nguyenQuan;

    private String danToc;

    private String quocTich;

    private String ngheNghiep;

    private String diaChiHienTai;

    private String diaChiThuongTru;

    private String gioiTinh;

    private String maGiaDinh;

    private String quanHeVoiChuHo;

}
