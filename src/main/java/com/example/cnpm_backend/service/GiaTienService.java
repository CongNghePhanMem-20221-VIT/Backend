package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.GiaTienModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiaTienService extends JpaRepository<GiaTienModel, Integer> {

}