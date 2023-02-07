package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.AccountModel;
import com.example.cnpm_backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/account/", method = RequestMethod.GET)
    public ResponseEntity<List<AccountModel>> listAllAccount(){
        List<AccountModel> listAccount = accountService.findAll();
        return new ResponseEntity<List<AccountModel>>(listAccount, HttpStatus.OK);
    }
}
