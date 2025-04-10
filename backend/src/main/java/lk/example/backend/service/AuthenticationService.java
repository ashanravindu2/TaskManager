package lk.example.backend.service;


import lk.example.backend.dto.UserDto;
import lk.example.backend.jwtmodels.JwtAuthResponse;
import lk.example.backend.jwtmodels.SignIn;

public interface AuthenticationService {
    JwtAuthResponse signUp(UserDto userDto);

    JwtAuthResponse signIn(SignIn signIn);

    JwtAuthResponse refreshToken(String refreshToken);
}
