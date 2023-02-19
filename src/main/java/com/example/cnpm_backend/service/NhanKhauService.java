package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.NhanKhauModel;
import com.example.cnpm_backend.model.dto.NhanKhauCanCuocDTO;
import com.example.cnpm_backend.model.dto.NhanKhauCapThuongDTO;
import com.example.cnpm_backend.model.dto.NhanKhauGiaDinhDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanKhauService extends JpaRepository<NhanKhauModel, Integer> {
    @Query(value = "select * from nhankhau nk, giadinh gd where nk.hoten like %:name%", nativeQuery = true)
    List<NhanKhauModel> findNhanKhauByName(@Param("name") String name);

    @Query(value = "select new com.example.cnpm_backend.model.dto.NhanKhauGiaDinhDTO" +
            "(nk.id, nk.IDCC, nk.hoTen, nk.ngaySinh, nk.nguyenQuan, nk.danToc, nk.quocTich, nk.ngheNghiep, nk.diaChiHienTai, nk.diaChiThuongTru, nk.gioiTinh, gd.maGiaDinh) " +
            "from NhanKhauModel nk, GiaDinhModel gd where nk.id = gd.idNhanKhau")
    List<NhanKhauGiaDinhDTO> joinNhanKhauGiaDinh();

    @Query(value = "select new com.example.cnpm_backend.model.dto.NhanKhauCanCuocDTO" +
            "(nk.id, nk.IDCC, cc.idcc, nk.hoTen, nk.ngaySinh, nk.nguyenQuan, nk.danToc, nk.quocTich, nk.ngheNghiep, nk.diaChiHienTai, nk.diaChiThuongTru, nk.gioiTinh,cc.ngayCap,cc.noiCap) " +
            "from NhanKhauModel nk, CanCuocModel cc where nk.IDCC = cc.id")
    List<NhanKhauCanCuocDTO> joinNhanKhauCanCuoc();

    @Query(value = "select new com.example.cnpm_backend.model.dto.NhanKhauCapThuongDTO" +
            "(nk.id, nk.IDCC, nk.hoTen, nk.ngaySinh, nk.nguyenQuan, nk.danToc, nk.quocTich, nk.ngheNghiep, nk.diaChiHienTai, nk.diaChiThuongTru, nk.gioiTinh, ct.tienThuong, ct.sach, ct.vo, ct.qua, ct.thanhTich ) " +
            "from NhanKhauModel nk, CapThuongModel ct where nk.id = ct.idNhanKhau")
    List<NhanKhauCapThuongDTO> joinNhanKhauCapThuong();
}
