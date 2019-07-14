package com.drewSpan.drewSpan2.service;

import com.drewSpan.drewSpan2.model.IndexOpElementy;
import com.drewSpan.drewSpan2.model.OpTech;
import com.drewSpan.drewSpan2.repository.IndexOpElementyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexOpElementyService {
    @Autowired
    private IndexOpElementyRepository indexOpElementyRepository;


    public void addIndexOpElementy(IndexOpElementy indexOp) {
        indexOpElementyRepository.save(indexOp);
    }


    public IndexOpElementy getIndexOpElementy(Integer id_indeksu) {
        return indexOpElementyRepository.findById(id_indeksu);
    }


    public IndexOpElementy updateIndexOpElementy(Integer id_indeksu,IndexOpElementy indexOp) {
        return indexOpElementyRepository.save(indexOp);
    }


    public void deleteIndexOpElementy(Long id_indeksu) {
        indexOpElementyRepository.deleteById(id_indeksu);
    }


    public List<IndexOpElementy> getAllIndexOpElementy() {
        List<IndexOpElementy> indexOpElementies=new ArrayList<>();
        indexOpElementyRepository.findAll().forEach(indexOpElementies::add);
        return indexOpElementies;
    }





    public List<IndexOpElementy> findAllOpTech() {
        return indexOpElementyRepository.findAll();
    }

    public IndexOpElementy findById(long id) {
        return indexOpElementyRepository.findById(id);
    }

    public IndexOpElementy save(IndexOpElementy indexOp) {
        return indexOpElementyRepository.save(indexOp);
    }

    public void remove(IndexOpElementy indexOp) {
        indexOpElementyRepository.delete(indexOp);
    }

    public void removeOpTechById(long id) {
        indexOpElementyRepository.deleteById(id);
    }
}
