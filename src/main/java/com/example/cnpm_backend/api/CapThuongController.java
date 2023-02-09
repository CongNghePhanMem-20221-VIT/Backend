package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.CapThuongModel;
import com.example.cnpm_backend.service.CapThuongService;
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
public class CapThuongController {
    public static Logger logger = LoggerFactory.getLogger(CapThuongController.class);
    @Autowired
    CapThuongService capThuongService;

    @RequestMapping(value = "/capthuong/", method = RequestMethod.GET)
    public ResponseEntity<List<CapThuongModel>> listAllCapThuong(){
        List<CapThuongModel> listCapThuong = capThuongService.findAll();
        if(listCapThuong.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CapThuongModel>>(listCapThuong, HttpStatus.OK);
    }

    @RequestMapping(value = "/capthuong/{id}", method = RequestMethod.GET)
    public Optional<CapThuongModel> findCapThuong(@PathVariable("id") int id){
        Optional<CapThuongModel> capThuong = capThuongService.findById(id);
        if (capThuong == null){
            ResponseEntity.notFound().build();
        }
        return capThuong;
    }
}
