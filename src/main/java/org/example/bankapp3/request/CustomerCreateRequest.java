package org.example.bankapp3.request;

import lombok.Data;

@Data
public class CustomerCreateRequest {
    private String name;
    private String Lastname;
    private String email;
    private String phoneNumber;
    private int accountId;

}
