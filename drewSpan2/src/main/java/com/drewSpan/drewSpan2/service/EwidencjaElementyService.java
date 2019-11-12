package com.drewSpan.drewSpan2.service;

import com.drewSpan.drewSpan2.model.EwidencjaElementy;
import com.drewSpan.drewSpan2.model.OpTech;
import com.drewSpan.drewSpan2.repository.EwidencjaElementyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EwidencjaElementyService {
    @Autowired
    EwidencjaElementyRepository EwidencjaElementyRepository;

    public List<EwidencjaElementy> findAllEwidencjaElementy() {
        return EwidencjaElementyRepository.findAll();
    }

    public EwidencjaElementy findById(long id) {
        return EwidencjaElementyRepository.findById(id);
    }

    public EwidencjaElementy save(EwidencjaElementy EwidencjaElementy) {
        return EwidencjaElementyRepository.save(EwidencjaElementy);
    }

    public void remove(EwidencjaElementy EwidencjaElementy) {
        EwidencjaElementyRepository.delete(EwidencjaElementy);
    }

    public void removeEwidencjaElementyById(long id) {
        EwidencjaElementyRepository.deleteById(id);
    }
}
