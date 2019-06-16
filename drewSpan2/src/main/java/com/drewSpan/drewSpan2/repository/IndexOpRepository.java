package com.drewSpan.drewSpan2.repository;

import com.drewSpan.drewSpan2.model.IndexOp;
import com.drewSpan.drewSpan2.model.OpTech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndexOpRepository extends JpaRepository<IndexOp, Long> {
    IndexOp findById(long id);
}
