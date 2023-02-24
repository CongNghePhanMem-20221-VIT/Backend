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

public class HoKhauThemMoiDTO {

    private String canCuoc;

    private Date ngayCap;

    private String noiCap;

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

//    private Date ngayTao;

    private String diaChi;

    private String idKhuVuc;
}
