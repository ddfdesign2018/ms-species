package com.ddfdesign.msspecies.repository;

import com.ddfdesign.msspecies.entity.Specy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpeciesRepository extends JpaRepository<Specy, Long> {
}
