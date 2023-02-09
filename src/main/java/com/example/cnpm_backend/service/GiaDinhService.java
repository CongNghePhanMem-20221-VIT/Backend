package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.GiaDinhModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiaDinhService extends JpaRepository<GiaDinhModel, Integer> {
}
