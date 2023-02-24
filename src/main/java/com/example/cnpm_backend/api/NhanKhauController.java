package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.AccountModel;
import com.example.cnpm_backend.model.NhanKhauModel;

import com.example.cnpm_backend.model.dto.NhanKhauCapThuongDTO;
import com.example.cnpm_backend.model.dto.NhanKhauGiaDinhDTO;
import com.example.cnpm_backend.model.dto.NhanKhauCanCuocDTO;

import com.example.cnpm_backend.service.NhanKhauService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
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


    // tìm 1 liên hệ

    @RequestMapping(value = "/nhankhau/timkiem", method = RequestMethod.GET)
    public ResponseEntity<List<NhanKhauModel>> listNhanKhauWithName(@RequestBody NhanKhauModel nhankhauModel){
        List<NhanKhauModel> listNhanKhau = nhanKhauService.findNhanKhauByName(nhankhauModel.getHoTen());
        if(listNhanKhau.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<NhanKhauModel>>(listNhanKhau, HttpStatus.OK);
    }

    //tìm tất cả liên hệ của nhân khẩu, gia đình

    @RequestMapping(value = "/nhankhau/giadinh", method = RequestMethod.GET)
    public ResponseEntity<List<NhanKhauGiaDinhDTO>> joinNhanKhauGiaDinh(){
        List<NhanKhauGiaDinhDTO> listNhanKhauGiaDinh = nhanKhauService.joinNhanKhauGiaDinh();
        if(listNhanKhauGiaDinh.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<NhanKhauGiaDinhDTO>>(listNhanKhauGiaDinh, HttpStatus.OK);
    }


    //tìm tất cả liên hệ của nhân khẩu, can cước
    @RequestMapping(value = "/nhankhau/cancuoc", method = RequestMethod.GET)
    public ResponseEntity<List<NhanKhauCanCuocDTO>> joinNhanKhauCanCuoc(){
        List<NhanKhauCanCuocDTO> listNhanKhauCanCuoc = nhanKhauService.joinNhanKhauCanCuoc();
        if(listNhanKhauCanCuoc.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<NhanKhauCanCuocDTO>>(listNhanKhauCanCuoc, HttpStatus.OK);
    }

    //tìm tất cả liên hệ của nhân khẩu, cap thuong theo idGiaiThuong
    @RequestMapping(value = "/nhankhau/capthuong/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<NhanKhauCapThuongDTO>> joinNhanKhauCapThuong(@PathVariable("id") int id){
        List<NhanKhauCapThuongDTO> listNhanKhauCapThuong = nhanKhauService.joinNhanKhauCapThuong(id);
        if(listNhanKhauCapThuong.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<NhanKhauCapThuongDTO>>(listNhanKhauCapThuong, HttpStatus.OK);
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
        if (nhanKhauModel == null) {
            return ResponseEntity.notFound().build();
        }

        nhanKhauService.delete(nhanKhauModel.get());
        return ResponseEntity.ok().build();
    }
}
