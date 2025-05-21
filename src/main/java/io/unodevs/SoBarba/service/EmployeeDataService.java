package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.repository.EmployeeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDataService {
    @Autowired
    private EmployeeDataRepository employeeDataRepository;
}
