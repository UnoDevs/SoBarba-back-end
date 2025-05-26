package io.unodevs.SoBarba.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.unodevs.SoBarba.dto.security.AccountCredentialsDTO;
import io.unodevs.SoBarba.dto.security.TokenDTO;
import io.unodevs.SoBarba.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Controlador de Autenticação")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @Operation(summary = "Autenticar usuário para retorno do TOKEN")
    @PostMapping("/singin")
    public ResponseEntity<?> singIn(@RequestBody AccountCredentialsDTO credentialsDTO){
        if (credentialsDTO == null || StringUtils.isBlank(credentialsDTO.getPassword()) || StringUtils.isBlank(credentialsDTO.getUsername()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Client Request!");

        TokenDTO token = authService.signIn(credentialsDTO);

        if (token == null) ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Client Request!");

        return ResponseEntity.ok(token);
    }
}
