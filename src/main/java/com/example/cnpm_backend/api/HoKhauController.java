package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.AccountModel;
import com.example.cnpm_backend.model.HoKhauModel;
import com.example.cnpm_backend.model.dto.HoKhauGiaDinhCanCuocDTO;
import com.example.cnpm_backend.model.dto.HoKhauGiaDinhDTO;
import com.example.cnpm_backend.model.dto.NhanKhauCapThuongDTO;
import com.example.cnpm_backend.model.dto.NhanKhauGiaDinhDTO;
import com.example.cnpm_backend.service.HoKhauService;
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
public class HoKhauController {
    public static Logger logger = LoggerFactory.getLogger(HoKhauController.class);
    @Autowired
    HoKhauService hoKhauService;

    //    lấy tất cả liên hệ
    @RequestMapping(value = "/hokhau/", method = RequestMethod.GET)
    public ResponseEntity<List<HoKhauModel>> listAllHoKhau(){
        List<HoKhauModel> listHoKhau = hoKhauService.findAll();
        if(listHoKhau.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<HoKhauModel>>(listHoKhau, HttpStatus.OK);
    }

    //    tạo mới liên hệ
    @RequestMapping(value = "/hokhau/", method = RequestMethod.POST)
    public HoKhauModel saveHoKhau(@Valid @RequestBody HoKhauModel hoKhauModel){
        return hoKhauService.save(hoKhauModel);
    }

    //    lấy một liên hệ
    @RequestMapping(value = "/hokhau/{idhokhau}", method = RequestMethod.GET)
    public Optional<HoKhauModel> findHoKhau(@PathVariable("idhokhau") int idhokhau) {
        Optional<HoKhauModel> hoKhauModel= hoKhauService.findById(idhokhau);
        if(hoKhauModel == null) {
            ResponseEntity.notFound().build();
        }
        return hoKhauModel;
    }

    //    update liên hệ
    @RequestMapping(value = "/hokhau/{idhokhau}", method = RequestMethod.PUT)
    public ResponseEntity<HoKhauModel> updateHoKhau(@PathVariable(value = "idhokhau") int idhokhau,
                                                      @Valid @RequestBody HoKhauModel hoKhauForm) {
        Optional<HoKhauModel> hoKhauModel = hoKhauService.findById(idhokhau);
        if(hoKhauService == null) {
            return ResponseEntity.notFound().build();
        }
        
        hoKhauModel.get().setDiaChi(hoKhauForm.getDiaChi());
        hoKhauModel.get().setIdGiaDinh(hoKhauForm.getIdGiaDinh());
        hoKhauModel.get().setIdChuHo(hoKhauForm.getIdChuHo());
        hoKhauModel.get().setNgayTao(hoKhauForm.getNgayTao());
        hoKhauModel.get().setIdKhuVuc(hoKhauForm.getIdKhuVuc());

        HoKhauModel updatedHoKhau = hoKhauService.save(hoKhauModel.get());
        return ResponseEntity.ok(updatedHoKhau);
    }

    ////    xóa liên hệ
    @RequestMapping(value = "/hokhau/{idhokhau}", method = RequestMethod.DELETE)
    public ResponseEntity<HoKhauModel> deleteHoKhau(@PathVariable(value = "idhokhau") int idhokhau) {
        Optional<HoKhauModel> hoKhauModel = hoKhauService.findById(idhokhau);
        if(hoKhauModel == null) {
            return ResponseEntity.notFound().build();
        }

        hoKhauService.delete(hoKhauModel.get());
        return ResponseEntity.ok().build();

    }

    //tìm tất cả liên hệ của ho khẩu, gia đình
    @RequestMapping(value = "/hokhau/giadinh", method = RequestMethod.GET)
    public ResponseEntity<List<HoKhauGiaDinhDTO>> joinHoKhauGiaDinh(){
        List<HoKhauGiaDinhDTO> listHoKhauGiaDinh = hoKhauService.joinHoKhauGiaDinh();
        if(listHoKhauGiaDinh.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<HoKhauGiaDinhDTO>>(listHoKhauGiaDinh, HttpStatus.OK);
    }

    //tìm tất cả liên hệ của ho khau, chu ho, can cuoc
    @RequestMapping(value = "/hokhau/chuho", method = RequestMethod.GET)
    public ResponseEntity<List<HoKhauGiaDinhCanCuocDTO>> joinHoKhauGiaDinhCanCuoc(){
        List<HoKhauGiaDinhCanCuocDTO> listHoKhauGiaDinhCanCuoc = hoKhauService.joinHoKhauGiaDinhCanCuoc();
        if(listHoKhauGiaDinhCanCuoc.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<HoKhauGiaDinhCanCuocDTO>>(listHoKhauGiaDinhCanCuoc, HttpStatus.OK);
    }


}
