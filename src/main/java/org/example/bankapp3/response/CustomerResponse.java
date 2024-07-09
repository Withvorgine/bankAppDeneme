package org.example.bankapp3.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CustomerResponse {
    private String customerId;
    private String customerName;
    private String phoneNumber;
    private String email;
    private Long createdDate;
    private Long updatedDate;
}
