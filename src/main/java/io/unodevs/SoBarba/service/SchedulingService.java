package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.mapper.SchedulingMapper;
import io.unodevs.SoBarba.repository.PersonRepository;
import io.unodevs.SoBarba.repository.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulingService {

    @Autowired
    private SchedulingRepository schedulingRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private SchedulingMapper schedulingMapper;


}
