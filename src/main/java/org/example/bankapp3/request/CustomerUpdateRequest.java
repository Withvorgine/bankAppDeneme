package org.example.bankapp3.request;

import lombok.Data;

@Data
public class CustomerUpdateRequest {
    private long customerId;
    private String name;
    private String Lastname;
    private String email;
    private int phoneNumber;
    private int accountId;
}
