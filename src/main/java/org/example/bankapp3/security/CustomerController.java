package org.example.bankapp3.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.bankapp3.enums.Language;
import org.example.bankapp3.exception.enums.FriendlyMessageCodes;
import org.example.bankapp3.exception.enums.utils.FriendlyMessageUtils;
import org.example.bankapp3.repository.entity.Customer;
import org.example.bankapp3.request.CustomerCreateRequest;
import org.example.bankapp3.response.CustomerResponse;
import org.example.bankapp3.response.FriendlyMessage;
import org.example.bankapp3.response.InternalApiResponse;
import org.example.bankapp3.service.ICustomerRepositoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/customerManagement")
@RequiredArgsConstructor
public class CustomerController {
    private final ICustomerRepositoryService customerRepositoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{language}/create")
    public InternalApiResponse<CustomerResponse> createCustomer(@PathVariable("language")Language language,
                                                                @RequestBody CustomerCreateRequest customerCreateRequest){
        log.debug("customer create request");
        Customer customer = customerRepositoryService.createCustomer(language,customerCreateRequest);
        CustomerResponse customerResponse = convertCustomerResponse(customer);
        log.debug("customer created");
        return InternalApiResponse.<CustomerResponse>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(language, FriendlyMessageCodes.OK))
                        .description(FriendlyMessageUtils.getFriendlyMessage(language,FriendlyMessageCodes.CUSTOMER_SUCCESSFULLY_CREATED))
                        .build())
                .hasError(false)
                .httpStatus(HttpStatus.CREATED)
                .payload(customerResponse)
                .build();
    }

    private CustomerResponse convertCustomerResponse(Customer customer){
        return CustomerResponse.builder()
                .customerId(customer.getCustomerId().toString())
                .customerName(customer.getName())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .build();
    }
}

