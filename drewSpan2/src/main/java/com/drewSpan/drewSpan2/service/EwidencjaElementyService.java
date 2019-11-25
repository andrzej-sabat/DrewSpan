package com.drewSpan.drewSpan2.service;

import com.drewSpan.drewSpan2.model.EwidencjaElementy;
import com.drewSpan.drewSpan2.repository.EwidencjaElementyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EwidencjaElementyService {
    @Autowired
    EwidencjaElementyRepository ewidencjaElementyRepository;

    public List<EwidencjaElementy> findAllEwidencjaElementy() {
        return ewidencjaElementyRepository.findAll();
    }

    public EwidencjaElementy findById(long id) {
        return ewidencjaElementyRepository.findById(id);
    }

    public EwidencjaElementy save(EwidencjaElementy ewidencjaElementy) {
        return ewidencjaElementyRepository.save(ewidencjaElementy);
    }

    public void remove(EwidencjaElementy ewidencjaElementy) {
        ewidencjaElementyRepository.delete(ewidencjaElementy);
    }

    public void removeEwidencjaElementyById(long id) {
        ewidencjaElementyRepository.deleteById(id);
    }
    
}
