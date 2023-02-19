package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.TamVangModel;
import com.example.cnpm_backend.model.dto.CanCuocTamVangDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TamVangService extends JpaRepository<TamVangModel, Integer> {
    @Query(value = "select new com.example.cnpm_backend.model.dto.CanCuocTamVangDTO" +
            "(tv.id, cc.idcc, nk.hoTen, nk.gioiTinh, tv.soDT, nk.ngheNghiep, nk.diaChiHienTai, nk.diaChiThuongTru,tv.ngayBatDau,tv.lyDo, tv.maTamVang) " +
            "from CanCuocModel cc, NhanKhauModel nk, TamVangModel tv where tv.idcc = cc.id and nk.IDCC = cc.id")
    List<CanCuocTamVangDTO> joinCanCuocTamVang();
}
