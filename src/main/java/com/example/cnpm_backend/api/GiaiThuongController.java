package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.GiaiThuongModel;
import com.example.cnpm_backend.service.GiaiThuongService;
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
public class GiaiThuongController {
    public static Logger logger = LoggerFactory.getLogger(GiaiThuongController.class);
    @Autowired
    GiaiThuongService giaiThuongService;

    @RequestMapping(value = "/giaithuong/", method = RequestMethod.GET)
    public ResponseEntity<List<GiaiThuongModel>> listAllGiaiThuong(){
        List<GiaiThuongModel> listGiaiThuong = giaiThuongService.findAll();
        if(listGiaiThuong.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<GiaiThuongModel>>(listGiaiThuong, HttpStatus.OK);
    }

    @RequestMapping(value = "/giaithuong/{id}", method = RequestMethod.GET)
    public Optional<GiaiThuongModel> findGiaiThuong(@PathVariable("id") int id){
        Optional<GiaiThuongModel> giaiThuong = giaiThuongService.findById(id);
        if (giaiThuong == null){
            ResponseEntity.notFound().build();
        }
        return giaiThuong;
    }
}
