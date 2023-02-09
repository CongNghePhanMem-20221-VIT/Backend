package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.AccountModel;
import com.example.cnpm_backend.service.AccountService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccountController {
    public static Logger logger = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    AccountService accountService;

//    lấy tất cả liên hệ
    @RequestMapping(value = "/account/", method = RequestMethod.GET)
    public ResponseEntity<List<AccountModel>> listAllAccount(){
        List<AccountModel> listAccount = accountService.findAll();
        if(listAccount.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<AccountModel>>(listAccount, HttpStatus.OK);
    }

//    tạo mới liên hệ
    @RequestMapping(value = "/account/", method = RequestMethod.POST)
        public AccountModel saveAccount(@Valid @RequestBody AccountModel accountModel){
            return accountService.save(accountModel);
    }

//    lấy một liên hệ
    @RequestMapping(value = "/account/{userid}", method = RequestMethod.GET)
    public Optional<AccountModel> findAccount(@PathVariable("userid") int userid) {
        Optional<AccountModel> accountModel= accountService.findById(userid);
        if(accountModel == null) {
            ResponseEntity.notFound().build();
        }
        return accountModel;
}

//    update liên hệ
    @RequestMapping(value = "/account/{userid}", method = RequestMethod.PUT)
    public ResponseEntity<AccountModel> updateAccount(@PathVariable(value = "userid") int userid,
                                                 @Valid @RequestBody AccountModel accountForm) {
        Optional<AccountModel> accountModel = accountService.findById(userid);
        if(accountService == null) {
            return ResponseEntity.notFound().build();
        }
        accountModel.get().setUserName(accountForm.getUserName());
        accountModel.get().setPassword(accountForm.getPassword());

        AccountModel updatedAccount = accountService.save(accountModel.get());
        return ResponseEntity.ok(updatedAccount);
    }

////    xóa liên hệ
    @RequestMapping(value = "/account/{userid}", method = RequestMethod.DELETE)
    public ResponseEntity<AccountModel> deleteAccount(@PathVariable(value = "userid") int userid) {
        Optional<AccountModel> accountModel = accountService.findById(userid);
        if(accountModel == null) {
            return ResponseEntity.notFound().build();
        }

        accountService.delete(accountModel.get());
        return ResponseEntity.ok().build();
    }
}
