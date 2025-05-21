package io.unodevs.SoBarba.repository;

import io.unodevs.SoBarba.model.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDataRepository extends JpaRepository<EmployeeData,Long> {
}
