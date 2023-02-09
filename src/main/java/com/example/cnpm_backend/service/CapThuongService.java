package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.CapThuongModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapThuongService extends JpaRepository<CapThuongModel, Integer> {

}
