package com.treeleaf.ecommerce.Controller;

import com.treeleaf.ecommerce.Exception.ResourceNotFoundException;
import com.treeleaf.ecommerce.Model.Login;
import com.treeleaf.ecommerce.Repository.LoginRepository;
import com.treeleaf.ecommerce.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private LoginService loginService;

    //Using list to get all the user from LoginRepository

    @GetMapping("/Login")
    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }

    @GetMapping("/Login/{id}")
    public ResponseEntity<Login> getLoginById(@PathVariable(value = "id") Long loginId)
            throws ResourceNotFoundException {
        Login login = loginRepository.findById(loginId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + loginId));
        return ResponseEntity.ok().body(login);
    }

    @PostMapping("/Login")
    public ResponseEntity<Login> createLogin(@Valid @RequestBody Login login) {
        Login savedLogin = loginService.createLogin(login);
        return new ResponseEntity<Login>(savedLogin, HttpStatus.CREATED);
    }

    @PutMapping("/Login/{id}")
    public ResponseEntity<Login> updateLogin(@PathVariable(value = "id") Long loginId,
                                             @Valid @RequestBody Login loginDetails) throws ResourceNotFoundException {
        Login login = loginRepository.findById(loginId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + loginId));

        login.setEmail(loginDetails.getEmail());
        login.setPassword(loginDetails.getPassword());
        final Login updatedLogin = loginRepository.save(login);
        return ResponseEntity.ok(updatedLogin);
    }
    @DeleteMapping("/Login/{id}")
    public Map<String, Boolean> deleteLogin(@PathVariable(value = "id") Long loginId)
            throws ResourceNotFoundException {
        Login login = loginRepository.findById(loginId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + loginId));

        loginRepository.delete(login);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
