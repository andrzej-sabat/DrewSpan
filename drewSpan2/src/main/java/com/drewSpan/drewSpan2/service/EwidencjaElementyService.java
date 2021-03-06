package com.drewSpan.drewSpan2.service;

import com.drewSpan.drewSpan2.model.Ewidencja;
import com.drewSpan.drewSpan2.model.EwidencjaElementy;
import com.drewSpan.drewSpan2.model.OpTech;
import com.drewSpan.drewSpan2.model.User;
import com.drewSpan.drewSpan2.repository.EwidencjaElementyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class EwidencjaElementyService {
    @Autowired
    EwidencjaElementyRepository EwidencjaElementyRepository;

    public List<EwidencjaElementy> findAllEwidencjaElementy() {
        return EwidencjaElementyRepository.findAll();
    }
    public List<EwidencjaElementy> findAllByUser(Long user_id) { return EwidencjaElementyRepository.findAllByUserId(user_id);}
    public EwidencjaElementy findById(long id) {
        return EwidencjaElementyRepository.findById(id);
    }
    public List<EwidencjaElementy> findAllByUserAndData(Long user_id) { return  EwidencjaElementyRepository.findAllByUserIdAndData(user_id);}
    public void updateEwidencjaElementy(Long id_element, Long krMaszyny_id, Integer czas, Date data, Integer ilosc, Long id_indeksu, Long user_id, Long opt_id, Long e_id,Long id_elementu) {
         EwidencjaElementyRepository.updateEwidencjaElementy(id_element,  krMaszyny_id,  czas,  data,  ilosc,  id_indeksu,  user_id,  opt_id,  e_id, id_elementu);
    }
    public EwidencjaElementy findByEwidencja(Ewidencja ewidencja) { return EwidencjaElementyRepository.findByEwidencja(ewidencja);}

    public EwidencjaElementy save(EwidencjaElementy EwidencjaElementy) {
        return EwidencjaElementyRepository.save(EwidencjaElementy);
    }

    public void remove(EwidencjaElementy EwidencjaElementy) {
        EwidencjaElementyRepository.delete(EwidencjaElementy);
    }

    public void removeEwidencjaElementyById(long id) {
        EwidencjaElementyRepository.deleteById(id);
    }

    public void removeEwidencjaElementyByEwidencja(Ewidencja ewidencja) { EwidencjaElementyRepository.deleteByEwidencja(ewidencja);


    }
    public void deleteAllById(Long e_id) { EwidencjaElementyRepository.deleteAllById(e_id);};
}
