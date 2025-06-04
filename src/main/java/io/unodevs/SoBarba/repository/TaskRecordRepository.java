package io.unodevs.SoBarba.repository;

import io.unodevs.SoBarba.model.TaskRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRecordRepository extends JpaRepository<TaskRecord,Long> {

}
