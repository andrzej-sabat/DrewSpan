package com.drewSpan.drewSpan2.repository;

import com.drewSpan.drewSpan2.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface EwidencjaRepository extends JpaRepository<Ewidencja, Long> {
    Ewidencja findById(long id);
    Ewidencja findEwidencjaByUser(User user);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update ewidencja SET e_id = ?1, e_czas_pracy = ?2, e_data=?3, e_zmiana=?4, kr_maszyny_id=?5, user_id = ?6 WHERE e_id = ?7", nativeQuery = true)
    void updateEwidencja(Long e_id, Integer e_czas_pracy, Date e_data, Integer e_zmiana, Long kr_maszyny_id, Long user_id, Long e_ide);


    @Query(value = "SELECT * FROM ewidencja WHERE user_id = ?1 AND e_data = ?2", nativeQuery = true)
    List<Ewidencja> findAllByUserIdAndData(Long user_id,Date date);
}
