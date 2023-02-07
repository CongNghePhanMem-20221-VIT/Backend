package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.HoKhauModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoKhauService extends JpaRepository<HoKhauModel, Integer> {
}
