package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.TamVangModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TamVangService extends JpaRepository<TamVangModel, Integer> {

}
