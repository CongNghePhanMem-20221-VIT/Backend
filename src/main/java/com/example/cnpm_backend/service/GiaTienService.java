package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.GiaTienModel;
import com.example.cnpm_backend.model.dto.GiaTienGiaiThuongDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiaTienService extends JpaRepository<GiaTienModel, Integer> {
    @Query(value = "select new com.example.cnpm_backend.model.dto.GiaTienGiaiThuongDTO" +
            "(gti.id, gth.tenGiai, gti.sanPham, gti.giatien, gti.soLuong) " +
            "from GiaiThuongModel gth, GiaTienModel  gti where gti.idGiaiThuong = gth.id and gti.idGiaiThuong = :idGiai order by gth.tenGiai")
    List<GiaTienGiaiThuongDTO> joinGiaTienGiaiThuong(@Param("idGiai") int idGiai);
}
