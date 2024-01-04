package ru.test.psychology.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.psychology.dto.RefreshResponse;
import ru.test.psychology.dto.SigninRequest;
import ru.test.psychology.dto.SigninResponse;
import ru.test.psychology.dto.SignupRequest;
import ru.test.psychology.services.AuthService;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/signup")
    public ResponseEntity<SigninResponse> registerUser(
            @Valid @RequestBody SignupRequest request
    ) {
        System.out.println(request);
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<SigninResponse> authenticateUser(
            @Valid @RequestBody SigninRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<RefreshResponse> refreshToken(
            HttpServletRequest request
    ) {
        return ResponseEntity.ok(service.refreshToken(request));
    }

    @GetMapping("/test")
    public String test() {
        return "Hello";
    }
}
