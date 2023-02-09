package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.TamTruModel;
import com.example.cnpm_backend.service.TamTruService;
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
public class TamTruController {
    public static Logger logger = LoggerFactory.getLogger(TamTruController.class);
    @Autowired
    TamTruService tamTruService;

    @RequestMapping(value = "/tamtru/", method = RequestMethod.GET)
    public ResponseEntity<List<TamTruModel>> listAllTamTru(){
        List<TamTruModel> listTamTru = tamTruService.findAll();
        if(listTamTru.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<TamTruModel>>(listTamTru, HttpStatus.OK);
    }

    @RequestMapping(value = "/tamtru/{id}", method = RequestMethod.GET)
    public Optional<TamTruModel> findTamTru(@PathVariable("id") int id){
        Optional<TamTruModel> tamTru = tamTruService.findById(id);
        if (tamTru == null){
            ResponseEntity.notFound().build();
        }
        return tamTru;
    }
}