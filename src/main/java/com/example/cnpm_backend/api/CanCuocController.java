package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.CanCuocModel;
import com.example.cnpm_backend.service.CanCuocService;
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
public class CanCuocController {
    public static Logger logger = LoggerFactory.getLogger(CanCuocController.class);
    @Autowired
    CanCuocService canCuocService;

    @RequestMapping(value = "/cancuoc/", method = RequestMethod.GET)
    public ResponseEntity<List<CanCuocModel>> listAllCanCuoc(){
        List<CanCuocModel> listCanCuoc = canCuocService.findAll();
        if(listCanCuoc.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CanCuocModel>>(listCanCuoc, HttpStatus.OK);
    }
}
