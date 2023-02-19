package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.AccountModel;
import com.example.cnpm_backend.model.CapThuongModel;
import com.example.cnpm_backend.model.dto.CapThuongNhanKhauDTO;
import com.example.cnpm_backend.service.CapThuongService;
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

    //    lấy tất cả liên hệ
    
    //    tạo mới liên hệ
    @RequestMapping(value = "/capthuong/", method = RequestMethod.POST)
    public CapThuongModel saveCapThuong(@Valid @RequestBody CapThuongModel capThuongModel){
        return capThuongService.save(capThuongModel);
    }

    //    lấy một liên hệ
    

    //    update liên hệ
    @RequestMapping(value = "/capthuong/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CapThuongModel> updateCapThuong(@PathVariable(value = "id") int id,
                                                      @Valid @RequestBody CapThuongModel capThuongForm) {
        Optional<CapThuongModel> capThuongModel = capThuongService.findById(id);
        if(capThuongService == null) {
            return ResponseEntity.notFound().build();
        }
        capThuongModel.get().setIdGiaiThuong(capThuongForm.getIdGiaiThuong());
        capThuongModel.get().setTienThuong(capThuongForm.getTienThuong());
        capThuongModel.get().setQua(capThuongForm.getQua());
        capThuongModel.get().setSach(capThuongForm.getSach());
        capThuongModel.get().setVo(capThuongForm.getVo());
        capThuongModel.get().setThanhTich(capThuongForm.getThanhTich());
        capThuongModel.get().setIdNhanKhau(capThuongForm.getIdNhanKhau());

        CapThuongModel updatedCapThuong = capThuongService.save(capThuongModel.get());
        return ResponseEntity.ok(updatedCapThuong);
    }

    ////    xóa liên hệ
    @RequestMapping(value = "/capthuong/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CapThuongModel> deleteCapThuong(@PathVariable(value = "id") int id) {
        Optional<CapThuongModel> capThuongModel = capThuongService.findById(id);
        if(capThuongModel == null) {
            return ResponseEntity.notFound().build();
        }

        capThuongService.delete(capThuongModel.get());
        return ResponseEntity.ok().build();

    }

    //tìm danh sach phan thuong cua moi nhan khau
    @RequestMapping(value = "/capthuong/nhankhau", method = RequestMethod.GET)
    public ResponseEntity<List<CapThuongNhanKhauDTO>> joinCapThuongNhanKhau(){
        List<CapThuongNhanKhauDTO> listCapThuongNhanKhau = capThuongService.joinCapThuongNhanKhau();
        if(listCapThuongNhanKhau.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CapThuongNhanKhauDTO>>(listCapThuongNhanKhau, HttpStatus.OK);
    }

}
