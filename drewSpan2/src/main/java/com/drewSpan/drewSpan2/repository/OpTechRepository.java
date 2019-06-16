package com.drewSpan.drewSpan2.repository;

import com.drewSpan.drewSpan2.model.OpTech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpTechRepository extends JpaRepository<OpTech, Long> {
    OpTech findById(long id);
}
