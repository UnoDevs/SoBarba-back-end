package io.unodevs.SoBarba.repository;

import io.unodevs.SoBarba.model.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling,Long> {

    @Query("SELECT s FROM Scheduling s JOIN FETCH s.client JOIN FETCH s.barber WHERE s.id = :id")
    Optional<Scheduling> findByIdWithPersons(@Param("id") Long id);

    @Query("SELECT s FROM Scheduling s JOIN FETCH t.client JOIN FETCH s.barber")
    List<Scheduling> findAllWithPersons();
}
