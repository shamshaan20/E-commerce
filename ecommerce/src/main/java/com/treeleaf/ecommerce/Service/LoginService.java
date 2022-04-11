package com.treeleaf.ecommerce.Service;

import com.treeleaf.ecommerce.Model.Login;
import com.treeleaf.ecommerce.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public Login createLogin(Login login) {
        return loginRepository.save(login);
    }

}
