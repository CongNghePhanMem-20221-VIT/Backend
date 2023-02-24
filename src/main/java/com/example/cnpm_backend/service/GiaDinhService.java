package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.GiaDinhModel;

import com.example.cnpm_backend.model.dto.NhanKhauGiaDinhDTO;
import jakarta.annotation.PreDestroy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiaDinhService extends JpaRepository<GiaDinhModel, Integer> {

    @Query(value = "select new com.example.cnpm_backend.model.dto.NhanKhauGiaDinhDTO" +
            "(nk.id, nk.IDCC, nk.hoTen, nk.ngaySinh, nk.nguyenQuan, nk.danToc, nk.quocTich, nk.ngheNghiep, nk.diaChiHienTai, nk.diaChiThuongTru, nk.gioiTinh, gd.maGiaDinh, gd.quanHeVoiChuHo) " +
            "from NhanKhauModel nk, GiaDinhModel gd where nk.id = gd.idNhanKhau and gd.maGiaDinh like :name")
    List<NhanKhauGiaDinhDTO> findGiaDinhByMa(@Param("name") String name);
}
