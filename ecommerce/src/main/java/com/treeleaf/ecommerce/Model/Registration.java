package com.treeleaf.ecommerce.Model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Registration", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name ="fname", nullable = false, length = 20 )
    private String firstName;

    @NotEmpty
    @Column(name ="lname", nullable = false, length = 20 )
    private String lastName;

    @NotEmpty
    @Email
    @Size(min = 8, max=30)
    private String email;
    
    @NotEmpty
    @Size(min = 8, message = "password should have at least 8 characters")
    private String password;
    
    @NotEmpty
    @Size(min = 8, message = "password should have at least 8 characters")
    private String confirmPassword;

    @Column(name = "phone",nullable = false)
    private long phoneNumber;

    public Registration(){}

    public Registration(long id, String firstName, String lastName, String email, String password, String confirmPassword, long phoneNumber) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
