package lk.example.backend.contoller;


import jakarta.validation.Valid;
import lk.example.backend.dto.UserDto;
import lk.example.backend.jwtmodels.JwtAuthResponse;
import lk.example.backend.jwtmodels.SignIn;
import lk.example.backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/sign-up")
    public ResponseEntity<JwtAuthResponse> signUp(@Valid @RequestBody UserDto userDto){
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        JwtAuthResponse jwtAuthResponse = authenticationService.signUp(userDto);
        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<JwtAuthResponse> signIn(@Valid @RequestBody UserDto userDto){
        JwtAuthResponse jwtAuthResponse = authenticationService.signIn(new SignIn(userDto.getUsername(), userDto.getPassword()));
        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthResponse> refreshToken(@RequestParam("refreshToken") String refreshToken) {
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.refreshToken(refreshToken));
    }
}
