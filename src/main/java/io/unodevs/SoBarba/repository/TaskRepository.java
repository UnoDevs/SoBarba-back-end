package io.unodevs.SoBarba.repository;

import io.unodevs.SoBarba.model.Product;
import io.unodevs.SoBarba.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t JOIN FETCH t.category WHERE t.id = :id")
    Optional<Task> findByIdWithCategory(@Param("id") Long id);

    @Query("SELECT t FROM Task t JOIN FETCH t.category")
    List<Task> findAllWithCategory();
}
