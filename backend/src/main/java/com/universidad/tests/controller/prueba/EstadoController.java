package com.universidad.tests.controller.prueba;

import com.universidad.tests.dto.prueba.EstadoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estado")
class EstadoController {

    @GetMapping(produces = "application/json")
    EstadoResponse estado() {
        return new EstadoResponse("ok");
    }
}
