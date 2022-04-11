package com.treeleaf.ecommerce.Service;

import com.treeleaf.ecommerce.Model.Registration;
import com.treeleaf.ecommerce.Repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;
    public Registration createRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

}
