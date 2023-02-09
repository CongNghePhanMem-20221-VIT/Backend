package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.NhanKhauModel;
import com.example.cnpm_backend.service.NhanKhauService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NhanKhauController {
    public static Logger logger = LoggerFactory.getLogger(NhanKhauController.class);
    @Autowired
    NhanKhauService NhanKhauService;

    @RequestMapping(value = "/nhankhau/", method = RequestMethod.GET)
    public ResponseEntity<List<NhanKhauModel>> listAllNhanKhau(){
        List<NhanKhauModel> listNhanKhau = NhanKhauService.findAll();
        if(listNhanKhau.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<NhanKhauModel>>(listNhanKhau, HttpStatus.OK);
    }

//    @RequestMapping(value = "/nhankhau/{id}", method = RequestMethod.GET)
//    public Optional<NhanKhauModel> findNhanKhau(@PathVariable("id") int id){
//        Optional<NhanKhauModel> NhanKhau = NhanKhauService.findById(id);
//        if (NhanKhau == null){
//            ResponseEntity.notFound().build();
//        }
//        return NhanKhau;
//    }
}
