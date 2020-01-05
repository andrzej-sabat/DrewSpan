package com.drewSpan.drewSpan2.service;

import com.drewSpan.drewSpan2.model.Wydajnosc;
import com.drewSpan.drewSpan2.model.WydajnoscElement;
import com.drewSpan.drewSpan2.repository.WydajnoscRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Date;
import java.util.List;

@Service
public class WydajnoscService {

    @Autowired
    WydajnoscRepository wydajnoscRepository;

    public void createXxx() { wydajnoscRepository.createXxx();}
    public List<Object> listXxx() { return wydajnoscRepository.listXxx();}

    public void createWykonanieNormy() { wydajnoscRepository.createWykonanieNormy();}
    public List<Object> listWykonanieNormy() { return wydajnoscRepository.listWykonanieNormy();}


    public void createWykonanieNormySearchIndex(int id_indeksu,int id_operacji) { wydajnoscRepository.createWykonanieNormySearchIndex(id_indeksu,id_operacji);}

    public void createCzasCalkowity() { wydajnoscRepository.createCzasCalkowity();}
    public List<Object> listCzasCalkowity() { return wydajnoscRepository.listCzasCalkowity();}

    public void createCzasCalkowitySearchIndex(){ wydajnoscRepository.createCzasCalkowitySearchIndex();}

    public void createWydajnosc() { wydajnoscRepository.createWydajnosc();}
    public List<Object> listWydajnosc() { return  wydajnoscRepository.listWydajnosc();}
    public List<Object> listWydajnoscSearchIndex() { return wydajnoscRepository.listWydajnoscSearchIndex();}
    public void createWydajnoscSearchIndex() { wydajnoscRepository.createWydajnoscSearchIndex();}

    public void createSumowanieSearchIndex() { wydajnoscRepository.createSumowanieSearchIndex();}
    public void dropTempTables() { wydajnoscRepository.dropTempTables();}
    public List<Wydajnosc> findWydajnosc() { return wydajnoscRepository.findWydajnosc();}

    public List<WydajnoscElement> findWydajnoscSearchIndex() throws SQLException {
        return  wydajnoscRepository.findWydajnoscSearchIndex();
    }

    public List<Wydajnosc> findWydajnoscByDate(int year,int month) { return  wydajnoscRepository.findWydajnoscByDate(year,month);}
}
