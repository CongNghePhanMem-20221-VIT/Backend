package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.GiaDinhModel;
import com.example.cnpm_backend.service.GiaDinhService;
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
public class GiaDinhController {
    public static Logger logger = LoggerFactory.getLogger(GiaDinhController.class);
    @Autowired
    GiaDinhService GiaDinhService;

    @RequestMapping(value = "/giadinh/", method = RequestMethod.GET)
    public ResponseEntity<List<GiaDinhModel>> listAllGiaDinh(){
        List<GiaDinhModel> listGiaDinh = GiaDinhService.findAll();
        if(listGiaDinh.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<GiaDinhModel>>(listGiaDinh, HttpStatus.OK);
    }
}
