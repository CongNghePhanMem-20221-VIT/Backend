package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.GiaDinhModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiaDinhService extends JpaRepository<GiaDinhModel, Integer> {
    @Query(value = "select * from giadinh gd where gd.Magiadinh like :name", nativeQuery = true)
    List<GiaDinhModel> findGiaDinhByMa(@Param("name") String name);
}
