package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.AccountModel;
import com.example.cnpm_backend.model.NhanKhauModel;
import com.example.cnpm_backend.service.NhanKhauService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NhanKhauController {
    public static Logger logger = LoggerFactory.getLogger(NhanKhauController.class);
    @Autowired
    NhanKhauService nhanKhauService;

    @RequestMapping(value = "/nhankhau/", method = RequestMethod.GET)
    public ResponseEntity<List<NhanKhauModel>> listAllNhanKhau(){
        List<NhanKhauModel> listNhanKhau = nhanKhauService.findAll();
        if(listNhanKhau.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<NhanKhauModel>>(listNhanKhau, HttpStatus.OK);
    }

    //    tạo mới liên hệ
    @RequestMapping(value = "/nhankhau/", method = RequestMethod.POST)
    public NhanKhauModel saveNhanKhau(@Valid @RequestBody NhanKhauModel nhanKhauModel){
        return nhanKhauService.save(nhanKhauModel);
    }

    //    lấy một liên hệ
    @RequestMapping(value = "/nhankhau/{id}", method = RequestMethod.GET)
    public Optional<NhanKhauModel> findNhanKhau(@PathVariable("id") int id) {
        Optional<NhanKhauModel> nhanKhauModel= nhanKhauService.findById(id);
        if(nhanKhauModel == null) {
            ResponseEntity.notFound().build();
        }
        return nhanKhauModel;
    }

    //    update liên hệ
    @RequestMapping(value = "/nhankhau/{id}", method = RequestMethod.PUT)
    public ResponseEntity<NhanKhauModel> updateNhanKhau(@PathVariable(value = "id") int id,
                                                      @Valid @RequestBody NhanKhauModel nhanKhauForm) {
        Optional<NhanKhauModel> nhanKhauModel = nhanKhauService.findById(id);
        if(nhanKhauService == null) {
            return ResponseEntity.notFound().build();
        }
        nhanKhauModel.get().setDanToc(nhanKhauForm.getDanToc());
        nhanKhauModel.get().setDiaChiHienTai(nhanKhauForm.getDiaChiHienTai());
        nhanKhauModel.get().setDiaChiThuongTru(nhanKhauForm.getDiaChiThuongTru());
        nhanKhauModel.get().setIDCC(nhanKhauForm.getIDCC());
        nhanKhauModel.get().setGioiTinh(nhanKhauForm.getGioiTinh());
        nhanKhauModel.get().setNguyenQuan(nhanKhauForm.getNguyenQuan());
        nhanKhauModel.get().setNgheNghiep(nhanKhauForm.getNgheNghiep());
        nhanKhauModel.get().setQuocTich(nhanKhauForm.getQuocTich());
        nhanKhauModel.get().setNgaySinh(nhanKhauForm.getNgaySinh());
        nhanKhauModel.get().setHoTen(nhanKhauForm.getHoTen());


        NhanKhauModel updatedNhanKhau = nhanKhauService.save(nhanKhauModel.get());
        return ResponseEntity.ok(updatedNhanKhau);
    }

    ////    xóa liên hệ
    @RequestMapping(value = "/nhankhau/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<NhanKhauModel> deleteNhanKhau(@PathVariable(value = "id") int id) {
        Optional<NhanKhauModel> nhanKhauModel = nhanKhauService.findById(id);
        if(nhanKhauModel == null) {
            return ResponseEntity.notFound().build();
        }

        nhanKhauService.delete(nhanKhauModel.get());
        return ResponseEntity.ok().build();

    }
}
