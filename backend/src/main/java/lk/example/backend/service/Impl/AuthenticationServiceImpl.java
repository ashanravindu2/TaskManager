package lk.example.backend.service.Impl;

import lk.example.backend.dto.UserDto;
import lk.example.backend.exception.UserAlreadyExits;
import lk.example.backend.jwtmodels.JwtAuthResponse;
import lk.example.backend.jwtmodels.SignIn;
import lk.example.backend.model.User;
import lk.example.backend.repository.UserRepository;
import lk.example.backend.service.AuthenticationService;
import lk.example.backend.service.JWTService;
import lk.example.backend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private final Mapping mapping;

    @Override
    public JwtAuthResponse signUp(UserDto userDto){
        var user = mapping.map(userDto, User.class);
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UserAlreadyExits("User already exists");
        }
        userRepository.save(user);
        var generatedToken = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JwtAuthResponse signIn(SignIn signIn){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getUsername(), signIn.getPassword()));
        var user = userRepository.findByUsername(signIn.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));
        var generatedToken = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JwtAuthResponse refreshToken(String refreshToken) {
        var userName = jwtService.extractUsername(refreshToken);
        var userEntity =
                userRepository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var newToken = jwtService.refreshToken(userEntity);
        return JwtAuthResponse.builder().token(newToken).build();
    }
}
