package com.drewSpan.drewSpan2.repository;

import com.drewSpan.drewSpan2.model.Ewidencja;
import com.drewSpan.drewSpan2.model.IndexOp;
import com.drewSpan.drewSpan2.model.OpTech;
import com.drewSpan.drewSpan2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface EwidencjaRepository extends JpaRepository<Ewidencja, Long> {
    Ewidencja findById(long id);
    Ewidencja findEwidencjaByUser(User user);

    @Query(value = "SELECT * FROM ewidencja WHERE user_id = ?1 AND e_data = ?2", nativeQuery = true)
    List<Ewidencja> findAllByUserIdAndData(Long user_id,Date date);
}
