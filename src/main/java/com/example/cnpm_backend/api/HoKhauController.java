package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.HoKhauModel;
import com.example.cnpm_backend.service.HoKhauService;
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
public class HoKhauController {
    public static Logger logger = LoggerFactory.getLogger(HoKhauController.class);
    @Autowired
    HoKhauService HoKhauService;

    @RequestMapping(value = "/hokhau/", method = RequestMethod.GET)
    public ResponseEntity<List<HoKhauModel>> listAllHoKhau(){
        List<HoKhauModel> listHoKhau = HoKhauService.findAll();
        if(listHoKhau.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<HoKhauModel>>(listHoKhau, HttpStatus.OK);
    }

//    @RequestMapping(value = "/hokhau/{id}", method = RequestMethod.GET)
//    public Optional<HoKhauModel> findHoKhau(@PathVariable("id") int id){
//        Optional<HoKhauModel> HoKhau = HoKhauService.findById(id);
//        if (HoKhau == null){
//            ResponseEntity.notFound().build();
//        }
//        return HoKhau;
//    }
}
