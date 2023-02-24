package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.AccountModel;
import com.example.cnpm_backend.model.GiaDinhModel;
import com.example.cnpm_backend.model.dto.NhanKhauGiaDinhDTO;
import com.example.cnpm_backend.service.GiaDinhService;
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
public class GiaDinhController {
    public static Logger logger = LoggerFactory.getLogger(GiaDinhController.class);
    @Autowired
    GiaDinhService giaDinhService;

    //    lấy tất cả liên hệ
    @RequestMapping(value = "/giadinh/", method = RequestMethod.GET)
    public ResponseEntity<List<GiaDinhModel>> listAllGiaDinh(){
        List<GiaDinhModel> listGiaDinh = giaDinhService.findAll();
        if(listGiaDinh.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<GiaDinhModel>>(listGiaDinh, HttpStatus.OK);
    }

    //    lấy một liên hệ
//    @RequestMapping(value = "/giadinh/{id}", method = RequestMethod.GET)
//    public Optional<GiaDinhModel> findGiaDinh(@PathVariable("id") int id){
//        Optional<GiaDinhModel> giaDinh = giaDinhService.findById(id);
//        if (giaDinh == null){
//            ResponseEntity.notFound().build();
//        }
//        return giaDinh;
//    }
    
    //    tạo mới liên hệ
    @RequestMapping(value = "/giadinh/", method = RequestMethod.POST)
    public GiaDinhModel saveGiaDinh(@Valid @RequestBody GiaDinhModel giaDinhModel){
        return giaDinhService.save(giaDinhModel);
    }
  

    //    update liên hệ
    @RequestMapping(value = "/giadinh/{id}", method = RequestMethod.PUT)
    public ResponseEntity<GiaDinhModel> updateGiaDinh(@PathVariable(value = "id") int id,
                                                      @Valid @RequestBody GiaDinhModel giaDinhForm) {
        Optional<GiaDinhModel> giaDinhModel = giaDinhService.findById(id);
        if(giaDinhService == null) {
            return ResponseEntity.notFound().build();
        }
        giaDinhModel.get().setId(giaDinhForm.getId());
        giaDinhModel.get().setHoTen(giaDinhForm.getHoTen());
        giaDinhModel.get().setIdNhanKhau((giaDinhForm.getIdNhanKhau()));
        giaDinhModel.get().setDiaChiHienTai(giaDinhForm.getDiaChiHienTai());
        giaDinhModel.get().setIdHoKhau(giaDinhForm.getIdHoKhau());
        giaDinhModel.get().setNgaySinh(giaDinhForm.getNgaySinh());
        giaDinhModel.get().setQuanHeVoiChuHo(giaDinhForm.getQuanHeVoiChuHo());
        giaDinhModel.get().setNgheNghiep(giaDinhForm.getNgheNghiep());

        GiaDinhModel updatedGiaDinh = giaDinhService.save(giaDinhModel.get());
        return ResponseEntity.ok(updatedGiaDinh);
    }

    ////    xóa liên hệ
    @RequestMapping(value = "/giadinh/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<GiaDinhModel> deleteGiaDinh(@PathVariable(value = "id") int id) {
        Optional<GiaDinhModel> giaDinhModel = giaDinhService.findById(id);
        if(giaDinhModel == null) {
            return ResponseEntity.notFound().build();
        }

        giaDinhService.delete(giaDinhModel.get());
        return ResponseEntity.ok().build();

    }

    //    lấy một liên hệ
    @RequestMapping(value = "/giadinh/{maGiaDinh}", method = RequestMethod.GET)
    public ResponseEntity<List<NhanKhauGiaDinhDTO>> listGiaDinhWithMa(@PathVariable("maGiaDinh") String maGiaDinh){
        List<NhanKhauGiaDinhDTO> listGiaDinh = giaDinhService.findGiaDinhByMa(maGiaDinh);
        if(listGiaDinh.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<NhanKhauGiaDinhDTO>>(listGiaDinh, HttpStatus.OK);
    }
}
