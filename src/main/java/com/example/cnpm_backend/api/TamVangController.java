package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.AccountModel;
import com.example.cnpm_backend.model.TamVangModel;
import com.example.cnpm_backend.model.dto.CanCuocTamVangDTO;
import com.example.cnpm_backend.service.TamVangService;
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
public class TamVangController {
    public static Logger logger = LoggerFactory.getLogger(TamVangController.class);
    @Autowired
    TamVangService tamVangService;

    @RequestMapping(value = "/tamvang/", method = RequestMethod.GET)
    public ResponseEntity<List<TamVangModel>> listAllTamVang(){
        List<TamVangModel> listTamVang = tamVangService.findAll();
        if(listTamVang.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<TamVangModel>>(listTamVang, HttpStatus.OK);
    }

    @RequestMapping(value = "/tamvang/{id}", method = RequestMethod.GET)
    public Optional<TamVangModel> findTamVang(@PathVariable("id") int id){
        Optional<TamVangModel> tamVang = tamVangService.findById(id);
        if (tamVang == null){
            ResponseEntity.notFound().build();
        }
        return tamVang;
    }

    //    tạo mới liên hệ
    @RequestMapping(value = "/tamvang/", method = RequestMethod.POST)
    public TamVangModel saveTamVang(@Valid @RequestBody TamVangModel tamVangModel){
        return tamVangService.save(tamVangModel);
    }

    //    update liên hệ
    @RequestMapping(value = "/tamvang/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TamVangModel> updateTamVang(@PathVariable(value = "id") int id,
                                                      @Valid @RequestBody TamVangModel tamVangForm) {
        Optional<TamVangModel> tamVangModel = tamVangService.findById(id);
        if(tamVangService == null) {
            return ResponseEntity.notFound().build();
        }
        tamVangModel.get().setMaTamVang(tamVangForm.getMaTamVang());
        tamVangModel.get().setIdcc(tamVangForm.getIdcc());
        tamVangModel.get().setLyDo(tamVangForm.getLyDo());
        tamVangModel.get().setSoDT(tamVangForm.getSoDT());
        tamVangModel.get().setNgayBatDau(tamVangForm.getNgayBatDau());
        tamVangModel.get().setNgayKetThuc(tamVangForm.getNgayKetThuc());


        TamVangModel updatedTamVang = tamVangService.save(tamVangModel.get());
        return ResponseEntity.ok(updatedTamVang);
    }

    ////    xóa liên hệ
    @RequestMapping(value = "/tamvang/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TamVangModel> deleteTamVang(@PathVariable(value = "id") int id) {
        Optional<TamVangModel> tamVangModel = tamVangService.findById(id);
        if(tamVangModel == null) {
            return ResponseEntity.notFound().build();
        }

        tamVangService.delete(tamVangModel.get());
        return ResponseEntity.ok().build();
    }

    //tìm danh sach tam vang
    @RequestMapping(value = "/tamvang/danhsach", method = RequestMethod.GET)
    public ResponseEntity<List<CanCuocTamVangDTO>> joinCanCuocTamVang(){
        List<CanCuocTamVangDTO> listHoKhauGiaDinhCanCuoc = tamVangService.joinCanCuocTamVang();
        if(listHoKhauGiaDinhCanCuoc.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CanCuocTamVangDTO>>(listHoKhauGiaDinhCanCuoc, HttpStatus.OK);
    }

}
