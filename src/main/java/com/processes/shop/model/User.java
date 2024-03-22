package com.processes.shop.model;
import com.processes.shop.model.enums.DocumentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private LocalDate birthday;
    private DocumentType documentType;
    private String phoneNumber;
    private String email;
    private String password;
    //private List<Address> address;
}
