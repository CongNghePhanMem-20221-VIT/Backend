package com.example.cnpm_backend.service;

import com.example.cnpm_backend.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountService extends JpaRepository<AccountModel, Integer> {

}
