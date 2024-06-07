package com.processes.shop.service;

import com.processes.shop.exceptions.AuthenticationFailedException;
import com.processes.shop.model.User;
import com.processes.shop.model.dto.AuthRequest;
import com.processes.shop.model.dto.AuthResponse;
import com.processes.shop.model.enums.ErrorMessages;
import com.processes.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(AuthRequest authRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authRequest.getEmail(), authRequest.getPassword()
            ));
        }catch (Exception e){
            throw new AuthenticationFailedException(ErrorMessages.CREDENTIAL_INVALID.getMessage());
        }
        Optional<User> user = userRepository.findByEmail(authRequest.getEmail());
        if (user.isEmpty()){
            throw new AuthenticationFailedException(ErrorMessages.CREDENTIAL_INVALID.getMessage());
        }
        UserDetails userDetails = user.get();
        String token = jwtService.getToken(userDetails);
        return AuthResponse.builder()
                .token(token)
                .build();
    }
}
