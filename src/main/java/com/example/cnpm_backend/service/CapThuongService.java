package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.CapThuongModel;
import com.example.cnpm_backend.model.dto.CapThuongNhanKhauDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapThuongService extends JpaRepository<CapThuongModel, Integer> {
    @Query(value = "select new com.example.cnpm_backend.model.dto.CapThuongNhanKhauDTO" +
            "(nk.id, cc.idcc, nk.hoTen, nk.gioiTinh, nk.ngaySinh, nk.diaChiHienTai, nk.diaChiThuongTru, ct.thanhTich, ct.tienThuong, ct.sach, ct.vo, ct.qua) " +
            "from CanCuocModel cc, NhanKhauModel nk, CapThuongModel ct where ct.idNhanKhau = nk.id and nk.IDCC = cc.id")
    List<CapThuongNhanKhauDTO> joinCapThuongNhanKhau();
}
