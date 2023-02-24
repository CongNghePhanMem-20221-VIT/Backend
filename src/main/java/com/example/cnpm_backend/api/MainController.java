package com.example.cnpm_backend.api;

import com.example.cnpm_backend.model.CanCuocModel;
import com.example.cnpm_backend.model.GiaDinhModel;
import com.example.cnpm_backend.model.NhanKhauModel;
import com.example.cnpm_backend.model.dto.NhanKhauThemMoiDTO;
import com.example.cnpm_backend.service.CanCuocService;
import com.example.cnpm_backend.service.GiaDinhService;
import com.example.cnpm_backend.service.HoKhauService;
import com.example.cnpm_backend.service.NhanKhauService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MainController {
    public static Logger logger = LoggerFactory.getLogger(NhanKhauController.class);
    @Autowired
    NhanKhauService nhanKhauService;
    @Autowired
    CanCuocService canCuocService;
    @Autowired
    GiaDinhService giaDinhService;

    @RequestMapping(value = "/nhankhau/themmoi", method = RequestMethod.POST)
    public ResponseEntity<NhanKhauThemMoiDTO> saveCanCuoc(@Valid @RequestBody NhanKhauThemMoiDTO nk){
        System.out.println(nk.getCanCuoc());
        CanCuocModel canCuocModel = new CanCuocModel(0, nk.getCanCuoc(), nk.getNgayCap(), nk.getNoiCap());
        int idcc = canCuocService.save(canCuocModel).getId();

        NhanKhauModel nhanKhauModel = new NhanKhauModel(0, idcc, nk.getHoTen(),nk.getNgaySinh(),
                nk.getNguyenQuan(),nk.getDanToc(),nk.getQuocTich(), nk.getNgheNghiep(), nk.getDiaChiHienTai(),
                nk.getDiaChiThuongTru(),nk.getGioiTinh());

        int idNhanKhau = nhanKhauService.save(nhanKhauModel).getId();

        GiaDinhModel giaDinhModel =new GiaDinhModel(0, nk.getMaGiaDinh(), nk.getIdHoKhau(), idNhanKhau, nk.getHoTen(),
                nk.getNgaySinh(), nk.getNgheNghiep(), nk.getQuanHeVoiChuHo(), nk.getDiaChiHienTai());

        giaDinhService.save(giaDinhModel);
        return ResponseEntity.ok(nk);
    }



}
