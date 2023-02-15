package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.NhanKhauModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanKhauService extends JpaRepository<NhanKhauModel, Integer> {

    @Query(value = "select * from nhankhau nk where nk.hoten = :name", nativeQuery = true)
    List<NhanKhauModel> findNhanKhauByName(@Param("name") String name);
}
