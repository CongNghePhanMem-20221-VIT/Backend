package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.GiaDinhModel;
import com.example.cnpm_backend.service.GiaDinhService;
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
public class GiaDinhController {
    public static Logger logger = LoggerFactory.getLogger(GiaDinhController.class);
    @Autowired
    GiaDinhService giaDinhService;

    @RequestMapping(value = "/giadinh/", method = RequestMethod.GET)
    public ResponseEntity<List<GiaDinhModel>> listAllGiaDinh(){
        List<GiaDinhModel> listGiaDinh = giaDinhService.findAll();
        if(listGiaDinh.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<GiaDinhModel>>(listGiaDinh, HttpStatus.OK);
    }

    @RequestMapping(value = "/giadinh/{id}", method = RequestMethod.GET)
    public Optional<GiaDinhModel> findGiaDinh(@PathVariable("id") String id){
        Optional<GiaDinhModel> giaDinh = giaDinhService.findById(id);
        if (giaDinh == null){
            ResponseEntity.notFound().build();
        }
        return giaDinh;
    }
}
