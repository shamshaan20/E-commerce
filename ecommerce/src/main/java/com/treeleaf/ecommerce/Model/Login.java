package com.treeleaf.ecommerce.Model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "LoginUser", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "r_id")

    @Autowired
    private Registration registration;

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }




    // email should be a valid email format
    // email should not be null or empty or not more than 30 character

    @NotEmpty
    @Email
    @Size(max=30)
    private String email;

    // password should not be null or empty
    // password should have at least 8 characters

    @NotEmpty
    @Size(min = 8, message = "password should have at least 8 characters")
    private String password;

    public Login(){

    }

    public Login(String email, String password){
        super();
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
