package com.drewSpan.drewSpan2.repository;

import com.drewSpan.drewSpan2.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Max;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface EwidencjaElementyRepository extends JpaRepository<EwidencjaElementy, Long> {
    EwidencjaElementy findById(long id);

    EwidencjaElementy deleteByEwidencja(Ewidencja ewidencja);
    EwidencjaElementy findByEwidencja(Ewidencja ewidencja);
    List<EwidencjaElementy> findAllByUserId(Long user_id);

    @Query(value = "SELECT * FROM ewidencja_elementy WHERE user_id = ?1 AND data = ?2", nativeQuery = true)
    List<EwidencjaElementy> findAllByUserIdAndData(Long user_id,Date date);

}
