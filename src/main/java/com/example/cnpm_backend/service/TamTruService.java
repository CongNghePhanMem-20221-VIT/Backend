package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.TamTruModel;
import com.example.cnpm_backend.model.dto.CanCuocTamTruDTO;
import com.example.cnpm_backend.model.dto.HoKhauGiaDinhDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TamTruService extends JpaRepository<TamTruModel, Integer> {

    @Query(value = "select new com.example.cnpm_backend.model.dto.CanCuocTamTruDTO" +
            "(tt.id, cc.idcc, nk.hoTen, nk.gioiTinh, tt.soDT, nk.ngheNghiep, nk.diaChiHienTai, nk.diaChiThuongTru,tt.ngayBatDau,tt.ngayKetThuc,tt.lyDo, tt.maTamTru) " +
            "from CanCuocModel cc, NhanKhauModel nk, TamTruModel tt where tt.idcc = cc.id and nk.IDCC = cc.id")
    List<CanCuocTamTruDTO> joinCanCuocTamTru();
}
