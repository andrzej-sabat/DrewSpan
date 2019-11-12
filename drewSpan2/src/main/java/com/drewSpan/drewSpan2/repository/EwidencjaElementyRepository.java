package com.drewSpan.drewSpan2.repository;

import com.drewSpan.drewSpan2.model.Ewidencja;
import com.drewSpan.drewSpan2.model.EwidencjaElementy;
import com.drewSpan.drewSpan2.model.IndexOp;
import com.drewSpan.drewSpan2.model.OpTech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EwidencjaElementyRepository extends JpaRepository<EwidencjaElementy, Long> {
    EwidencjaElementy findById(long id);
}
