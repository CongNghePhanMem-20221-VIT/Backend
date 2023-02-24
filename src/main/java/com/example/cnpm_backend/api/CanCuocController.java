package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.CanCuocModel;
import com.example.cnpm_backend.service.CanCuocService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CanCuocController {
    public static Logger logger = LoggerFactory.getLogger(CanCuocController.class);
    @Autowired
    CanCuocService canCuocService;


    //    lấy tất cả liên hệ
    @RequestMapping(value = "/cancuoc/", method = RequestMethod.GET)
    public ResponseEntity<List<CanCuocModel>> listAllCanCuoc(){
        List<CanCuocModel> listCanCuoc = canCuocService.findAll();
        if(listCanCuoc.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CanCuocModel>>(listCanCuoc, HttpStatus.OK);
    }

    //    tạo mới liên hệ
    @RequestMapping(value = "/cancuoc/", method = RequestMethod.POST)
    public CanCuocModel saveCanCuoc(@Valid @RequestBody CanCuocModel canCuocModel){
        return canCuocService.save(canCuocModel);
    }

    //    lấy một liên hệ
    @RequestMapping(value = "/cancuoc/{id}", method = RequestMethod.GET)
    public Optional<CanCuocModel> findCanCuoc(@PathVariable("id") int id) {
        Optional<CanCuocModel> canCuocModel= canCuocService.findById(id);
        if(canCuocModel == null) {
            ResponseEntity.notFound().build();
        }
        return canCuocModel;
    }

    //    update liên hệ
    @RequestMapping(value = "/cancuoc/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CanCuocModel> updateCanCuoc(@PathVariable(value = "id") int id,
                                                      @Valid @RequestBody CanCuocModel canCuocForm) {
        Optional<CanCuocModel> canCuocModel = canCuocService.findById(id);
        if(canCuocService == null) {
            return ResponseEntity.notFound().build();
        }
        canCuocModel.get().setIdcc(canCuocForm.getIdcc());
        canCuocModel.get().setNgayCap(canCuocForm.getNgayCap());
        canCuocModel.get().setNoiCap(canCuocForm.getNoiCap());

        CanCuocModel updatedCanCuoc = canCuocService.save(canCuocModel.get());
        return ResponseEntity.ok(updatedCanCuoc);
    }

    ////    xóa liên hệ
    @RequestMapping(value = "/cancuoc/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CanCuocModel> deleteCanCuoc(@PathVariable(value = "id") int id) {
        Optional<CanCuocModel> canCuocModel = canCuocService.findById(id);
        if(canCuocModel == null) {
            return ResponseEntity.notFound().build();
        }

        canCuocService.delete(canCuocModel.get());
        return ResponseEntity.ok().build();

    }
}
