package com.drewSpan.drewSpan2.repository;

import com.drewSpan.drewSpan2.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Max;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface EwidencjaElementyRepository extends JpaRepository<EwidencjaElementy, Long> {
    EwidencjaElementy findById(long id);

    EwidencjaElementy deleteByEwidencja(Ewidencja ewidencja);
    EwidencjaElementy findByEwidencja(Ewidencja ewidencja);
    List<EwidencjaElementy> findAllByUserId(Long user_id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update ewidencja_elementy SET id_element = ?1, kr_maszyny_id = ?2, czas=?3, data=?4, ilosc=?5, id_indeksu = ?6, user_id = ?7, opt_id = ?8, e_id = ?9  WHERE id_element = ?10", nativeQuery = true)
    void updateEwidencjaElementy(Long id_element, Long krMaszyny_id, Integer czas, Date data, Integer ilosc, Long id_indeksu, Long user_id, Long opt_id, Long e_id,Long id_elementu);

    @Query(value = "SELECT * FROM ewidencja_elementy WHERE user_id = ?1 AND data = ?2", nativeQuery = true)
    List<EwidencjaElementy> findAllByUserIdAndData(Long user_id,Date date);

}
