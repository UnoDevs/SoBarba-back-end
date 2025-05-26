package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.dto.security.AccountCredentialsDTO;
import io.unodevs.SoBarba.dto.security.TokenDTO;
import io.unodevs.SoBarba.model.User;
import io.unodevs.SoBarba.repository.UserRepository;
import io.unodevs.SoBarba.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private UserRepository userRepository;

    public TokenDTO signIn(AccountCredentialsDTO credentialsDTO){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        credentialsDTO.getUsername(),
                        credentialsDTO.getPassword()
                )
        );

        User user = userRepository.findByUsername(credentialsDTO.getUsername());
        if (user == null) throw new UsernameNotFoundException("Username " + credentialsDTO.getUsername() + " not found");

        return tokenProvider.createAccessToken(user.getUsername(),user.getRoles());
    }
}
