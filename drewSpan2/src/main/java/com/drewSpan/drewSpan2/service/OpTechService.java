package com.drewSpan.drewSpan2.service;

import com.drewSpan.drewSpan2.model.OpTech;
import com.drewSpan.drewSpan2.repository.OpTechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpTechService {
    @Autowired
    private OpTechRepository opTechRepository;

    public List<OpTech> findAllOpTech() {
        return opTechRepository.findAll();
    }

    public OpTech findById(long id) {
        return opTechRepository.findById(id);
    }

    public OpTech save(OpTech opTech) {
        return opTechRepository.save(opTech);
    }

    public void remove(OpTech opTech) {
        opTechRepository.delete(opTech);
    }

    public void removeOpTechById(long id) {
        opTechRepository.deleteById(id);
    }
}
