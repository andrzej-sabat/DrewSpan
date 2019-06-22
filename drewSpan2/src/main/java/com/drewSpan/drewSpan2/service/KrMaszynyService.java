package com.drewSpan.drewSpan2.service;

import com.drewSpan.drewSpan2.model.KrMaszyny;
import com.drewSpan.drewSpan2.repository.KrMaszynyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class KrMaszynyService {

    @Autowired
    private KrMaszynyRepository krMaszynyRepository;



    public void addKrMaszyny(KrMaszyny krMaszyny) {
        krMaszynyRepository.save(krMaszyny);
    }


    public KrMaszyny getKrMaszyny(Integer krm_id) {
        return krMaszynyRepository.findById(krm_id);
    }


    public KrMaszyny updateKrMaszyny(Integer krm_id,KrMaszyny krMaszyny) {
        return krMaszynyRepository.save(krMaszyny);
    }


    public void deleteKrMaszyny(Long krm_id) {
        krMaszynyRepository.deleteById(krm_id);
    }


    public List<KrMaszyny> getAllKrMaszynys() {
        List<KrMaszyny> krMaszynys=new ArrayList<>();
        krMaszynyRepository.findAll().forEach(krMaszynys::add);
        return krMaszynys;
    }

    public KrMaszyny save(KrMaszyny krMaszyny) {
        return krMaszynyRepository.save(krMaszyny);
    }
}
