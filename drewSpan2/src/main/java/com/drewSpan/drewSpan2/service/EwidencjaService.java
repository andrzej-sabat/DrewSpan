package com.drewSpan.drewSpan2.service;

import com.drewSpan.drewSpan2.model.Ewidencja;
import com.drewSpan.drewSpan2.model.User;
import com.drewSpan.drewSpan2.repository.EwidencjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class EwidencjaService {
    @Autowired
    EwidencjaRepository ewidencjaRepository;

    public List<Ewidencja> findAllEwidencja() {
        return ewidencjaRepository.findAll();
    }
    public List<Ewidencja> findAllByUserAndData(Long user_id,Date date) { return  ewidencjaRepository.findAllByUserIdAndData(user_id,date);}
    public Ewidencja findEwidencjaByUser(User user){ return  ewidencjaRepository.findEwidencjaByUser(user);};
    public Ewidencja findById(long id) {
        return ewidencjaRepository.findById(id);
    }
    public LocalDate getLocalDate() {
        return LocalDate.now();
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
