package com.drewSpan.drewSpan2.service;

import com.drewSpan.drewSpan2.model.IndexOp;
import com.drewSpan.drewSpan2.model.OpTech;
import com.drewSpan.drewSpan2.repository.IndexOpRepository;
import com.drewSpan.drewSpan2.repository.OpTechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexOpService {
    @Autowired
    private IndexOpRepository indexOpRepository;

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
