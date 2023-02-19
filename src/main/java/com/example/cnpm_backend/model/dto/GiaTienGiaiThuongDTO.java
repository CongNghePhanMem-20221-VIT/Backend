package com.example.cnpm_backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class GiaTienGiaiThuongDTO {
    private int id;

    private String tenGiai;

    private String sanPham;

    private int giatien;

    private int soLuong;
}
