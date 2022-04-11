package com.treeleaf.ecommerce.Controller;

import com.treeleaf.ecommerce.Exception.ResourceNotFoundException;
import com.treeleaf.ecommerce.Model.Registration;
import com.treeleaf.ecommerce.Repository.RegistrationRepository;
import com.treeleaf.ecommerce.Service.RegistrationService;
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
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RegistrationService registrationService;

    //Using list to get all the user from RegistrationRepository

    @GetMapping("/Registration")
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    @GetMapping("/Registration/{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable(value = "id") Long registrationId)
            throws ResourceNotFoundException {
        Registration registration = registrationRepository.findById(registrationId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + registrationId));
        return ResponseEntity.ok().body(registration);
    }

    @PostMapping("/Registration")
    public ResponseEntity<Registration> createRegistration(@Valid @RequestBody Registration registration) {
        Registration savedRegistration = registrationService.createRegistration(registration);
        return new ResponseEntity<Registration>(savedRegistration, HttpStatus.CREATED);
    }

    @PutMapping("/Registration/{id}")
    public ResponseEntity<Registration> updateRegistration(@PathVariable(value = "id") Long registrationId,
                                             @Valid @RequestBody Registration registrationDetails) throws ResourceNotFoundException {
        Registration registration = registrationRepository.findById(registrationId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + registrationId));

        registration.setFirstName(registrationDetails.getFirstName());
        registration.setLastName(registrationDetails.getLastName());
        registration.setEmail(registrationDetails.getEmail());
        registration.setPassword(registrationDetails.getPassword());
        registration.setConfirmPassword(registrationDetails.getConfirmPassword());
        registration.setPhoneNumber(registrationDetails.getPhoneNumber());

        final Registration updatedRegistration = registrationRepository.save(registration);
        return ResponseEntity.ok(updatedRegistration);
    }
    @DeleteMapping("/Registration/{id}")
    public Map<String, Boolean> deleteRegistration(@PathVariable(value = "id") Long registrationId)
            throws ResourceNotFoundException {
        Registration registration = registrationRepository.findById(registrationId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + registrationId));

        registrationRepository.delete(registration);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
