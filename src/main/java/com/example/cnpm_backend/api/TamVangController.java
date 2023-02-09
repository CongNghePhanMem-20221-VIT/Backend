package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.TamVangModel;
import com.example.cnpm_backend.service.TamVangService;
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
public class TamVangController {
    public static Logger logger = LoggerFactory.getLogger(TamVangController.class);
    @Autowired
    TamVangService tamVangService;

    @RequestMapping(value = "/tamvang/", method = RequestMethod.GET)
    public ResponseEntity<List<TamVangModel>> listAllTamVang(){
        List<TamVangModel> listTamVang = tamVangService.findAll();
        if(listTamVang.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<TamVangModel>>(listTamVang, HttpStatus.OK);
    }

    @RequestMapping(value = "/tamvang/{id}", method = RequestMethod.GET)
    public Optional<TamVangModel> findTamVang(@PathVariable("id") int id){
        Optional<TamVangModel> tamVang = tamVangService.findById(id);
        if (tamVang == null){
            ResponseEntity.notFound().build();
        }
        return tamVang;
    }
}
