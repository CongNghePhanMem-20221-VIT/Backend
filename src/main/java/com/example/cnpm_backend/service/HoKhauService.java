package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.HoKhauModel;

import com.example.cnpm_backend.model.dto.HoKhauGiaDinhCanCuocDTO;
import com.example.cnpm_backend.model.dto.HoKhauGiaDinhDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoKhauService extends JpaRepository<HoKhauModel, Integer> {

    @Query(value = "select new com.example.cnpm_backend.model.dto.HoKhauGiaDinhDTO" +
            "(gd.idHoKhau, hk.diaChi, hk.ngayTao, hk.idKhuVuc, hk.idGiaDinh, gd.hoTen, gd.ngaySinh, gd.ngheNghiep, gd.quanHeVoiChuHo, gd.diaChiHienTai) " +
            "from HoKhauModel hk, GiaDinhModel gd where hk.idhokhau = gd.idHoKhau")
    List<HoKhauGiaDinhDTO> joinHoKhauGiaDinh();

    @Query(value = "select new com.example.cnpm_backend.model.dto.HoKhauGiaDinhCanCuocDTO" +
            "(gd.idHoKhau, hk.diaChi, hk.ngayTao, hk.idKhuVuc, hk.idGiaDinh, gd.hoTen, gd.ngaySinh, gd.ngheNghiep, gd.quanHeVoiChuHo, gd.diaChiHienTai, cc.idcc) " +
            "from HoKhauModel hk, GiaDinhModel gd, CanCuocModel cc where hk.idhokhau = gd.idHoKhau and cc.id = hk.idChuHo and gd.quanHeVoiChuHo = 'Chủ hộ'")
    List<HoKhauGiaDinhCanCuocDTO> joinHoKhauGiaDinhCanCuoc();




}
