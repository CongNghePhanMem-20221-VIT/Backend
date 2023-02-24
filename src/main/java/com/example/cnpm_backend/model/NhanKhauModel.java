package com.example.cnpm_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "nhankhau")
public class NhanKhauModel implements Serializable {
    private static int serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "IDcancuoc")
    private int IDCC;
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

}
