package com.hohong.controller;

import com.hohong.dto.PhuongTienDto;
import com.hohong.model.DiaDiem;
import com.hohong.model.PhuongTien;
import com.hohong.service.IDiaDiemService;
import com.hohong.service.IPhuongTienService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class PhuongTienRestController {

    @Autowired
    private IPhuongTienService phuongTienService;

    @Autowired
    private IDiaDiemService diaDiemService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<PhuongTien>> getPagePhuongTien() {
        List<PhuongTien> phuongTienPage = phuongTienService.findAll();
        if(phuongTienPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(phuongTienPage, HttpStatus.OK);
    }

    @GetMapping(value = "/listDiaDiem")
    public ResponseEntity<List<DiaDiem>> getListDiaDiem() {
        List<DiaDiem> diaDiemList = diaDiemService.findAll();
        if(diaDiemList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(diaDiemList, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<List<FieldError>> createPhuongTien(@Validated @RequestBody PhuongTienDto phuongTienDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NO_CONTENT);
        }

        PhuongTien phuongTien = new PhuongTien();
        BeanUtils.copyProperties(phuongTienDto, phuongTien);
        phuongTienService.save(phuongTien);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "delete")
    public ResponseEntity<Void> deletePhuongTien(@RequestParam int id) {
        if (id == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        phuongTienService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "findById")
    public ResponseEntity<PhuongTien> findById(@RequestParam int id) {
        PhuongTien phuongTien = phuongTienService.findById(id);
        if (phuongTien == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(phuongTien, HttpStatus.OK);
    }

    @PatchMapping(value = "edit")
    public ResponseEntity<Void> editBlog(@RequestBody PhuongTien phuongTien) {
        if (phuongTien == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        phuongTienService.save(phuongTien);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "search")
    public ResponseEntity<List<PhuongTien>> searchPhuongTien(@RequestParam String search) {
        List<PhuongTien> phuongTienPage = phuongTienService.findAllSearch(search);
        if(phuongTienPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(phuongTienPage, HttpStatus.OK);
    }

}
