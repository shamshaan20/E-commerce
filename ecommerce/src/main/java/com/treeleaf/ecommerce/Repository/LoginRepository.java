package com.treeleaf.ecommerce.Repository;

import com.treeleaf.ecommerce.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {

}
