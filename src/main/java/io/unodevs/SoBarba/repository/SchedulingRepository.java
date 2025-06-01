package io.unodevs.SoBarba.repository;

import io.unodevs.SoBarba.model.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling,Long> {
    
}
