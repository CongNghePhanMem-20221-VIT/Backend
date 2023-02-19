package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.AccountModel;
import com.example.cnpm_backend.model.GiaiThuongModel;
import com.example.cnpm_backend.service.GiaiThuongService;
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
public class GiaiThuongController {
    public static Logger logger = LoggerFactory.getLogger(GiaiThuongController.class);
    @Autowired
    GiaiThuongService giaiThuongService;

    //    lấy tất cả liên hệ
    @RequestMapping(value = "/giaithuong/", method = RequestMethod.GET)
    public ResponseEntity<List<GiaiThuongModel>> listAllGiaiThuong(){
        List<GiaiThuongModel> listGiaiThuong = giaiThuongService.findAll();
        if(listGiaiThuong.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<GiaiThuongModel>>(listGiaiThuong, HttpStatus.OK);
    }

    //    lấy một liên hệ
    @RequestMapping(value = "/giaithuong/{id}", method = RequestMethod.GET)
    public Optional<GiaiThuongModel> findGiaiThuong(@PathVariable("id") int id){
        Optional<GiaiThuongModel> giaiThuong = giaiThuongService.findById(id);
        if (giaiThuong == null){
            ResponseEntity.notFound().build();
        }
        return giaiThuong;
    }


    //    tạo mới liên hệ
    @RequestMapping(value = "/giaithuong/", method = RequestMethod.POST)
    public GiaiThuongModel saveGiaiThuong(@Valid @RequestBody GiaiThuongModel giaiThuongModel){
        return giaiThuongService.save(giaiThuongModel);
    }

    //    update liên hệ
    @RequestMapping(value = "/giaithuong/{id}", method = RequestMethod.PUT)
    public ResponseEntity<GiaiThuongModel> updateGiaiThuong(@PathVariable(value = "id") int id,
                                                      @Valid @RequestBody GiaiThuongModel giaiThuongForm) {
        Optional<GiaiThuongModel> giaiThuongModel = giaiThuongService.findById(id);
        if(giaiThuongService == null) {
            return ResponseEntity.notFound().build();
        }
        giaiThuongModel.get().setTenGiai(giaiThuongForm.getTenGiai());

        GiaiThuongModel updatedGiaiThuong = giaiThuongService.save(giaiThuongModel.get());
        return ResponseEntity.ok(updatedGiaiThuong);
    }

    ////    xóa liên hệ
    @RequestMapping(value = "/giaithuong/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<GiaiThuongModel> deleteGiaiThuong(@PathVariable(value = "id") int id) {
        Optional<GiaiThuongModel> giaiThuongModel = giaiThuongService.findById(id);
        if(giaiThuongModel == null) {
            return ResponseEntity.notFound().build();
        }

        giaiThuongService.delete(giaiThuongModel.get());
        return ResponseEntity.ok().build();

    }
}
