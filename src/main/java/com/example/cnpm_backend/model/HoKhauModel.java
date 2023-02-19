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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "hokhau")
public class HoKhauModel implements Serializable {
    private static int serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idhokhau;

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

}
