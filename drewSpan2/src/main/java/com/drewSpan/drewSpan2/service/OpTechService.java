package com.drewSpan.drewSpan2.service;

import com.drewSpan.drewSpan2.model.OpTech;
import com.drewSpan.drewSpan2.repository.OpTechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpTechService {
    @Autowired
    private OpTechRepository opTechRepository;



    public void addOpTech(OpTech opTech) {
        opTechRepository.save(opTech);
    }


    public OpTech getOpTech(Integer opt_id) {
        return opTechRepository.findById(opt_id);
    }


    public OpTech updateOpTech(Integer opt_id,OpTech opTech) {
        return opTechRepository.save(opTech);
    }


    public void deleteOpTech(Long opt_id) {
        opTechRepository.deleteById(opt_id);
    }


    public List<OpTech> getAllOpTechs() {
        List<OpTech> opTechs=new ArrayList<>();
        opTechRepository.findAll().forEach(opTechs::add);
        return opTechs;
    }

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
