package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.AccountModel;
import com.example.cnpm_backend.model.HoKhauModel;
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
    @RequestMapping(value = "/hokhau/{idHoKhau}", method = RequestMethod.GET)
    public Optional<HoKhauModel> findHoKhau(@PathVariable("idHoKhau") int idHoKhau) {
        Optional<HoKhauModel> hoKhauModel= hoKhauService.findById(idHoKhau);
        if(hoKhauModel == null) {
            ResponseEntity.notFound().build();
        }
        return hoKhauModel;
    }

    //    update liên hệ
    @RequestMapping(value = "/hokhau/{idHoKhau}", method = RequestMethod.PUT)
    public ResponseEntity<HoKhauModel> updateHoKhau(@PathVariable(value = "idHoKhau") int idHoKhau,
                                                      @Valid @RequestBody HoKhauModel hoKhauForm) {
        Optional<HoKhauModel> hoKhauModel = hoKhauService.findById(idHoKhau);
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
    @RequestMapping(value = "/hokhau/{idHoKhau}", method = RequestMethod.DELETE)
    public ResponseEntity<HoKhauModel> deleteHoKhau(@PathVariable(value = "idHoKhau") int idHoKhau) {
        Optional<HoKhauModel> hoKhauModel = hoKhauService.findById(idHoKhau);
        if(hoKhauModel == null) {
            return ResponseEntity.notFound().build();
        }

        hoKhauService.delete(hoKhauModel.get());
        return ResponseEntity.ok().build();

    }
}
