package com.drewSpan.drewSpan2.service;

import com.drewSpan.drewSpan2.model.Wydajnosc;
import com.drewSpan.drewSpan2.repository.WydajnoscRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WydajnoscService {

    @Autowired
    WydajnoscRepository wydajnoscRepository;

    public void createXxx() { wydajnoscRepository.createXxx();}
    public List<Object> listXxx() { return wydajnoscRepository.listXxx();}

    public void createWykonanieNormy() { wydajnoscRepository.createWykonanieNormy();}
    public List<Object> listWykonanieNormy() { return wydajnoscRepository.listWykonanieNormy();}

    public void createCzasCalkowity() { wydajnoscRepository.createCzasCalkowity();}
    public List<Object> listCzasCalkowity() { return wydajnoscRepository.listCzasCalkowity();}

    public void createWydajnosc() { wydajnoscRepository.createWydajnosc();}
    public List<Object> listWydajnosc() { return  wydajnoscRepository.listWydajnosc();}

    public void dropTempTables() { wydajnoscRepository.dropTempTables();}
    public List<Wydajnosc> findWydajnosc() { return wydajnoscRepository.findWydajnosc();}
}
