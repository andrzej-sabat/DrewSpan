package com.drewSpan.drewSpan2.repository;

import com.drewSpan.drewSpan2.model.KrMaszyny;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KrMaszynyRepository extends JpaRepository<KrMaszyny, Long> {
    KrMaszyny findById(long id);
}

