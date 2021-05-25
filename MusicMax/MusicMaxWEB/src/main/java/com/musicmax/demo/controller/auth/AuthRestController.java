package com.musicmax.demo.controller.auth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicmax.demo.message.request.LoginForm;
import com.musicmax.demo.message.request.SignUpForm;
import com.musicmax.demo.message.response.JwtResponse;
import com.musicmax.demo.repository.ClientRepository;
import com.musicmax.demo.repository.RoleRepository;
import com.musicmax.demo.security.jwt.JwtProvider;

import model.Client;
import model.Role;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		return ResponseEntity.ok(new JwtResponse(jwt));
	}

	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (clientRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<String>("Fail -> Email is already in use!", HttpStatus.BAD_REQUEST);
		}
		

		// Creating user's account
		Client client = new Client();
		client.setFirstName(signUpRequest.getFirstName());
		client.setLastName(signUpRequest.getLastName());
		client.setBirthDate(signUpRequest.getBirthDate());
		client.setEmail(signUpRequest.getEmail());
		client.setPassword(encoder.encode(signUpRequest.getPassword()));

		String strRole = signUpRequest.getRole();
		Role role = null;
		switch (strRole) {
		case "ADMIN":
			role = roleRepository.findByTitle("administrator")
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			break;
		default:
			role = roleRepository.findByTitle("user")
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
		}

		client.setRole(role);
		System.out.println(client);
		clientRepository.save(client);

		return ResponseEntity.ok().body("User registered successfully!");
	}
}