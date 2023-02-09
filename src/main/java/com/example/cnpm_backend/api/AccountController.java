package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.AccountModel;
import com.example.cnpm_backend.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccountController {
    public static Logger logger = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/account/", method = RequestMethod.GET)
    public ResponseEntity<List<AccountModel>> listAllAccount(){
        List<AccountModel> listAccount = accountService.findAll();
        if(listAccount.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<AccountModel>>(listAccount, HttpStatus.OK);
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public Optional<AccountModel> findAccount(@PathVariable("id") int id){
        Optional<AccountModel> account = accountService.findById(id);
        if (account == null){
            ResponseEntity.notFound().build();
        }
        return account;
    }
}
