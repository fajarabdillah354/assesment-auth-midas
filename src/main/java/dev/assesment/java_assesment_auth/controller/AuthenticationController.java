package dev.assesment.java_assesment_auth.controller;


import dev.assesment.java_assesment_auth.entity.Users;
import dev.assesment.java_assesment_auth.payload.request.LoginRequest;
import dev.assesment.java_assesment_auth.payload.request.RegisterRequest;
import dev.assesment.java_assesment_auth.payload.response.LoginResponse;
import dev.assesment.java_assesment_auth.service.AuthenticationService;
import dev.assesment.java_assesment_auth.service.JwtService;
import dev.assesment.java_assesment_auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:63342")
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }


    @PostMapping("/signup")
    public ResponseEntity<Users> register(@RequestBody RegisterRequest registerRequest){
        Users users = authenticationService.signup(registerRequest);
        return ResponseEntity.ok(users);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        Users users = authenticationService.authenticate(loginRequest);

        String jwtToken = jwtService.generateToken(users);

        LoginResponse response = new LoginResponse();
        response.setToken(jwtToken);
        response.setExpiresIn(jwtService.getJwtExpiration());

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/verified/{id}/verify")
    public ResponseEntity<Void> verifiedUser(@PathVariable String id, @RequestParam Boolean verify){
        return userService.verifiedUser(id, verify);
    }


}
