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

public class CanCuocTamTruDTO {
    private int id;

    private String idcc;

    private String hoTen;

    private String gioiTinh;

    private String soDT;

    private String ngheNghiep;

    private String diaChiHienTai;

    private String diaChiThuongTru;

    private Date ngayBatDau;

    private Date ngayKetThuc;

    private String lyDo;

    private String maTamTru;
}
