package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.GiaTienModel;
import com.example.cnpm_backend.service.GiaTienService;
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
public class GiaTienController {
    public static Logger logger = LoggerFactory.getLogger(GiaTienController.class);
    @Autowired
    GiaTienService giaTienService;

    @RequestMapping(value = "/giatien/", method = RequestMethod.GET)
    public ResponseEntity<List<GiaTienModel>> listAllGiaTien(){
        List<GiaTienModel> listGiaTien = giaTienService.findAll();
        if(listGiaTien.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<GiaTienModel>>(listGiaTien, HttpStatus.OK);
    }

    @RequestMapping(value = "/giatien/{id}", method = RequestMethod.GET)
    public Optional<GiaTienModel> findGiaTien(@PathVariable("id") int id){
        Optional<GiaTienModel> giaTien = giaTienService.findById(id);
        if (giaTien == null){
            ResponseEntity.notFound().build();
        }
        return giaTien;
    }
}
