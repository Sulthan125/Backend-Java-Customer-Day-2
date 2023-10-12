package com.multipolar.bootcamp.kyc.controller;

import com.multipolar.bootcamp.kyc.domain.Kyc;
import com.multipolar.bootcamp.kyc.service.KycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kyc")
public class KycController {

    private final KycService kycService;

    @Autowired
    public KycController(KycService kycService) {
        this.kycService = kycService;
    }

    @PostMapping
    public ResponseEntity<?> createKyc(@Validated @RequestBody Kyc kyc,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ArrayList<String> validationErrors = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                validationErrors.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(validationErrors);
        }
        Kyc createdKyc = kycService.createOrUpdateKyc(kyc);
        return ResponseEntity.ok(createdKyc);
    }

    @GetMapping
    public List<Kyc> getAllKyc(){
        return kycService.getAllKyc();
    }

    //get KYC by Id lewat pathvariabel/segment
    @GetMapping("/{id}")
    public ResponseEntity<Kyc> getKycById(@PathVariable("id") String id){
        return kycService.getKycById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Edit KYC by Customer
    @PutMapping("/{id}")
    public Kyc updateKycById(@PathVariable String id,@RequestBody Kyc kyc){
        return kycService.createOrUpdateKyc(kyc);
    }

    //delete KYC by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKycById(@PathVariable("id") String id){
        kycService.deleteKycById(id);
        return ResponseEntity.noContent().build();

    }
    @GetMapping("/nik/{nik}")
    public ResponseEntity<Kyc> getKycByNik(@PathVariable String nik){
        return kycService.getKycByNik(nik)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Kyc>> getKycByName(@PathVariable String name){
        return ResponseEntity.ok(kycService.getKycByName(name));
    }

}
