package com.multipolar.bootcamp.kyc.service;

import com.multipolar.bootcamp.kyc.domain.Kyc;
import com.multipolar.bootcamp.kyc.repository.KycRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KycService {

    private final KycRepository kycRepository;

    @Autowired
    public KycService(KycRepository kycRepository) {
        this.kycRepository = kycRepository;
    }

    //Fungsi to get All KYC
    public List<Kyc> getAllKyc(){
        return kycRepository.findAll();
    }

    //Fungsi to gel KYC by id
    public Optional<Kyc> getKycById(String id){
        return kycRepository.findById(id);
    }

    //Fungsi to create KYC Baru
    public Kyc createOrUpdateKyc(Kyc kyc){
        return kycRepository.save(kyc);
    }

    //Fungsi to delete KYC
    public void deleteKycById(String id){
        kycRepository.deleteById(id);
    }
}
