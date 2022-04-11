package com.treeleaf.ecommerce.Repository;

import com.treeleaf.ecommerce.Model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
