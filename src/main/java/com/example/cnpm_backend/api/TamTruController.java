package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.AccountModel;
import com.example.cnpm_backend.model.TamTruModel;
import com.example.cnpm_backend.model.dto.CanCuocTamTruDTO;
import com.example.cnpm_backend.service.TamTruService;
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
public class TamTruController {
    public static Logger logger = LoggerFactory.getLogger(TamTruController.class);
    @Autowired
    TamTruService tamTruService;

    @RequestMapping(value = "/tamtru/", method = RequestMethod.GET)
    public ResponseEntity<List<TamTruModel>> listAllTamTru(){
        List<TamTruModel> listTamTru = tamTruService.findAll();
        if(listTamTru.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<TamTruModel>>(listTamTru, HttpStatus.OK);
    }

    //   lấy một liên hệ
    @RequestMapping(value = "/tamtru/{id}", method = RequestMethod.GET)
    public Optional<TamTruModel> findTamTru(@PathVariable("id") int id){
        Optional<TamTruModel> tamTru = tamTruService.findById(id);
        if (tamTru == null){
            ResponseEntity.notFound().build();
        }
        return tamTru;
    }
    //    tạo mới liên hệ
    @RequestMapping(value = "/tamtru/", method = RequestMethod.POST)
    public TamTruModel saveTamTru(@Valid @RequestBody TamTruModel tamTruModel){
        return tamTruService.save(tamTruModel);
    }

    //    update liên hệ
    @RequestMapping(value = "/tamtru/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TamTruModel> updateTamTru(@PathVariable(value = "id") int id,
                                                      @Valid @RequestBody TamTruModel tamTruForm) {
        Optional<TamTruModel> tamTruModel = tamTruService.findById(id);
        if(tamTruService == null) {
            return ResponseEntity.notFound().build();
        }
        tamTruModel.get().setMaTamTru(tamTruForm.getMaTamTru());
        tamTruModel.get().setIdcc(tamTruForm.getIdcc());
        tamTruModel.get().setLyDo(tamTruForm.getLyDo());
        tamTruModel.get().setSoDT(tamTruForm.getSoDT());
        tamTruModel.get().setNgayBatDau(tamTruForm.getNgayBatDau());
        tamTruModel.get().setNgayKetThuc(tamTruForm.getNgayKetThuc());


        TamTruModel updatedTamTru = tamTruService.save(tamTruModel.get());
        return ResponseEntity.ok(updatedTamTru);
    }

    ////    xóa liên hệ
    @RequestMapping(value = "/tamtru/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TamTruModel> deleteTamTru(@PathVariable(value = "id") int id) {
        Optional<TamTruModel> tamTruModel = tamTruService.findById(id);
        if(tamTruModel == null) {
            return ResponseEntity.notFound().build();
        }

        tamTruService.delete(tamTruModel.get());
        return ResponseEntity.ok().build();

    }

    //tìm danh sach tam tru
    @RequestMapping(value = "/tamtru/danhsach", method = RequestMethod.GET)
    public ResponseEntity<List<CanCuocTamTruDTO>> joinCanCuocTamTru(){
        List<CanCuocTamTruDTO> listHoKhauGiaDinhCanCuoc = tamTruService.joinCanCuocTamTru();
        if(listHoKhauGiaDinhCanCuoc.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CanCuocTamTruDTO>>(listHoKhauGiaDinhCanCuoc, HttpStatus.OK);
    }


}
