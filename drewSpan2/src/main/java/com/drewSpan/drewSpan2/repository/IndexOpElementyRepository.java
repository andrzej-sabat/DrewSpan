package com.drewSpan.drewSpan2.repository;

import com.drewSpan.drewSpan2.model.IndexOpElementy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndexOpElementyRepository extends JpaRepository<IndexOpElementy, Long> {
    IndexOpElementy findById(long id);
}
