package org.example.bankapp3.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.bankapp3.enums.Language;
import org.example.bankapp3.exception.enums.FriendlyMessageCodes;
import org.example.bankapp3.exception.enums.exceptions.CustomerNotCreatedException;
import org.example.bankapp3.repository.entity.Customer;
import org.example.bankapp3.repository.entity.CustomerRepository;
import org.example.bankapp3.request.CustomerCreateRequest;
import org.example.bankapp3.service.ICustomerRepositoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerRepositoryServiceImpl implements ICustomerRepositoryService {
    private final CustomerRepository customerRepositoryService;
    @Override
    public Customer createCustomer(Language language, CustomerCreateRequest customerCreateRequest) {
        log.debug("[{}][createCustomer] -> request: {}",this.getClass().getSimpleName(),customerCreateRequest);
        try {
            Customer customer = Customer.builder()
                    .name(customerCreateRequest.getName())
                    .lastname(customerCreateRequest.getLastname())
                    .email(customerCreateRequest.getEmail())
                    .phoneNumber(customerCreateRequest.getPhoneNumber())
                    .deleted(false)
                    .build();
            return customerRepositoryService.save(customer);
        } catch (Exception exception){
            throw new CustomerNotCreatedException(language, FriendlyMessageCodes.CUSTOMER_NOT_CREATED_EXCEPTION,"customer is not created");

        }
    }

    @Override
    public Customer getCustomer(Language language, Long customerId) {
        return null;
    }

    @Override
    public List<Customer> getCustomers(Language language) {
        return null;
    }

    @Override
    public Customer updateCustomer(Language language, Long customerId, CustomerCreateRequest customerCreateRequest) {
        return null;
    }

    @Override
    public Customer deleteCustomer(Language language, Long customerId) {
        return null;
    }
}
