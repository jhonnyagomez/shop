package com.processes.shop.model;
import jakarta.persistence.*;
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
    private String fullName;
    private String document;
    private LocalDate birthday;
    private String documentType;
    private String phoneNumber;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Address> address;
}
