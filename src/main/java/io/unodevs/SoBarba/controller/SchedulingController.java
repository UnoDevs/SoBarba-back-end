package io.unodevs.SoBarba.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.unodevs.SoBarba.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Controlador de Agendamento")
@RestController
@RequestMapping("/scheduling")
public class SchedulingController {
    @Autowired
    SchedulingService schedulingService;


}
