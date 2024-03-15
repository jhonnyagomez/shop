package com.processes.shop.model;
import com.processes.shop.model.enums.DocumentType;
import lombok.Builder;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class User {

    private String fullName;
    private Date birthday;
    private DocumentType documentType;
    private String document;
    private String phoneNumber;
    private String email;
    private String password;
    private List<Address> address;
}
