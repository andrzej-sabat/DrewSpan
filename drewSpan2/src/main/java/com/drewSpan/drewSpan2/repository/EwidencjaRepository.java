package com.drewSpan.drewSpan2.repository;

import com.drewSpan.drewSpan2.model.Ewidencja;
import com.drewSpan.drewSpan2.model.IndexOp;
import com.drewSpan.drewSpan2.model.OpTech;
import com.drewSpan.drewSpan2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.crypto.Data;

public interface EwidencjaRepository extends JpaRepository<Ewidencja, Long> {
    Ewidencja findById(long id);
    Ewidencja findEwidencjaByUser(User user);

}
