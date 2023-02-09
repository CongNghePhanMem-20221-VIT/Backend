package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.GiaiThuongModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiaiThuongService extends JpaRepository<GiaiThuongModel, Integer> {

}
