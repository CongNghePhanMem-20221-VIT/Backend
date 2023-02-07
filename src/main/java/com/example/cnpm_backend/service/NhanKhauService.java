package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.NhanKhauModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanKhauService extends JpaRepository<NhanKhauModel, String> {
}
