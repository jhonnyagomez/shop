package com.processes.shop.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Please provide the full name")
    @Size(min = 10, max = 200)
    private String fullName;
    @NotNull(message = "please provide the document")
    @Size(min = 5, max = 10)
    private String document;
    @NotNull(message = "please provide the document type")
    private String documentType;
    private LocalDate birthday;
    private String phoneNumber;
    @NotNull(message = "please provide the email")
    @Email(message = "please provide the email")
    private String email;
    @NotNull(message = "please provide the password")
    @Size(min = 8, max = 15)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Address> address;
}
