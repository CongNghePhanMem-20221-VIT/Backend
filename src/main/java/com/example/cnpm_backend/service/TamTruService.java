package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.TamTruModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TamTruService extends JpaRepository<TamTruModel, Integer> {

}
