package io.unodevs.SoBarba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRecordRepository extends JpaRepository<TaskRepository,Long> {

}
