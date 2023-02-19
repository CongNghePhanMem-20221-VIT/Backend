package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.GiaTienModel;
import com.example.cnpm_backend.model.dto.GiaTienGiaiThuongDTO;
import com.example.cnpm_backend.service.GiaTienService;
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
public class GiaTienController {
    public static Logger logger = LoggerFactory.getLogger(GiaTienController.class);
    @Autowired
    GiaTienService giaTienService;

    //    lấy tất cả liên hệ
    @RequestMapping(value = "/giatien/", method = RequestMethod.GET)
    public ResponseEntity<List<GiaTienModel>> listAllGiaTien(){
        List<GiaTienModel> listGiaTien = giaTienService.findAll();
        if(listGiaTien.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<GiaTienModel>>(listGiaTien, HttpStatus.OK);
    }

    //    lấy một liên hệ
    @RequestMapping(value = "/giatien/{id}", method = RequestMethod.GET)
    public Optional<GiaTienModel> findGiaTien(@PathVariable("id") int id){
        Optional<GiaTienModel> giaTien = giaTienService.findById(id);
        if (giaTien == null){
            ResponseEntity.notFound().build();
        }
        return giaTien;
    }

    //    tạo mới liên hệ
    @RequestMapping(value = "/giatien/", method = RequestMethod.POST)
    public GiaTienModel saveGiaTien(@Valid @RequestBody GiaTienModel giaTienModel){
        return giaTienService.save(giaTienModel);
    }

    //    update liên hệ
    @RequestMapping(value = "/giatien/{id}", method = RequestMethod.PUT)
    public ResponseEntity<GiaTienModel> updateGiaTien(@PathVariable(value = "id") int id,
                                                      @Valid @RequestBody GiaTienModel giaTienForm) {
        Optional<GiaTienModel> giaTienModel = giaTienService.findById(id);
        if(giaTienService == null) {
            return ResponseEntity.notFound().build();
        }
        giaTienModel.get().setGiatien(giaTienForm.getGiatien());
        giaTienModel.get().setIdGiaiThuong(giaTienForm.getIdGiaiThuong());
        giaTienModel.get().setSanPham(giaTienForm.getSanPham());
        giaTienModel.get().setSoLuong(giaTienForm.getSoLuong());

        GiaTienModel updatedGiaTien = giaTienService.save(giaTienModel.get());
        return ResponseEntity.ok(updatedGiaTien);
    }

    ////    xóa liên hệ
    @RequestMapping(value = "/giatien/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<GiaTienModel> deleteGiaTien(@PathVariable(value = "id") int id) {
        Optional<GiaTienModel> giaTienModel = giaTienService.findById(id);
        if(giaTienModel == null) {
            return ResponseEntity.notFound().build();
        }

        giaTienService.delete(giaTienModel.get());
        return ResponseEntity.ok().build();

    }

    //tìm tất cả liên hệ của Gia tien, giai thuong
    @RequestMapping(value = "/tienthuong/giaithuong", method = RequestMethod.GET)
    public ResponseEntity<List<GiaTienGiaiThuongDTO>> joinGiaTienGiaiThuong(){
        List<GiaTienGiaiThuongDTO> listNhanKhauGiaDinh = giaTienService.joinGiaTienGiaiThuong();
        if(listNhanKhauGiaDinh.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<GiaTienGiaiThuongDTO>>(listNhanKhauGiaDinh, HttpStatus.OK);
    }

}
