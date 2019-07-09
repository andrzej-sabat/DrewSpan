package com.drewSpan.drewSpan2.service;

import com.drewSpan.drewSpan2.model.Ewidencja;
import com.drewSpan.drewSpan2.model.OpTech;
import com.drewSpan.drewSpan2.repository.EwidencjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EwidencjaService {
    @Autowired
    EwidencjaRepository ewidencjaRepository;

    public List<Ewidencja> findAllEwidencja() {
        return ewidencjaRepository.findAll();
    }

    public Ewidencja findById(long id) {
        return ewidencjaRepository.findById(id);
    }

    public Ewidencja save(Ewidencja ewidencja) {
        return ewidencjaRepository.save(ewidencja);
    }

    public void remove(Ewidencja ewidencja) {
        ewidencjaRepository.delete(ewidencja);
    }

    public void removeEwidencjaById(long id) {
        ewidencjaRepository.deleteById(id);
    }
}
