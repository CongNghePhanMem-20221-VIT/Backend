package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.CanCuocModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanCuocService extends JpaRepository<CanCuocModel, String> {
}
