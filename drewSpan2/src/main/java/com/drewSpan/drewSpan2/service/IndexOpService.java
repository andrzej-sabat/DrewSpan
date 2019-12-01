package com.drewSpan.drewSpan2.service;

import com.drewSpan.drewSpan2.model.IndexOp;
import com.drewSpan.drewSpan2.model.OpTech;
import com.drewSpan.drewSpan2.repository.IndexOpRepository;
import com.drewSpan.drewSpan2.repository.OpTechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexOpService {
    @Autowired
    private IndexOpRepository indexOpRepository;


    public void addIndexOp(IndexOp indexOp) {
        indexOpRepository.save(indexOp);
    }


    public IndexOp getIndexOp(Integer id_indeksu) {
        return indexOpRepository.findById(id_indeksu);
    }


    public IndexOp updateIndexOp(Integer id_indeksu,IndexOp indexOp) {
        return indexOpRepository.save(indexOp);
    }


    public void deleteIndexOp(Long id_indeksu) {
        indexOpRepository.deleteById(id_indeksu);
    }


    public List<IndexOp> getAllIndexOp() {
        List<IndexOp> indexOps=new ArrayList<>();
        indexOpRepository.findAll().forEach(indexOps::add);
        return indexOps;
    }




    public List<IndexOp> findAllOpTech() {
        return indexOpRepository.findAll();
    }

    public IndexOp findById(long id) {
        return indexOpRepository.findById(id);
    }

    public IndexOp save(IndexOp indexOp) {
        return indexOpRepository.save(indexOp);
    }

    public void remove(IndexOp indexOp) {
        indexOpRepository.delete(indexOp);
    }

    public void removeOpTechById(long id) {
        indexOpRepository.deleteById(id);
    }
}
