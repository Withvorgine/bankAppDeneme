package org.example.bankapp3.service;

import org.example.bankapp3.enums.Language;
import org.example.bankapp3.repository.entity.Customer;
import org.example.bankapp3.request.CustomerCreateRequest;

import java.util.List;

public interface ICustomerRepositoryService {
    Customer createCustomer(Language language, CustomerCreateRequest customerCreateRequest);

    Customer getCustomer(Language language, Long customerId);

    List<Customer> getCustomers(Language language);

    Customer updateCustomer(Language language, Long customerId, CustomerCreateRequest customerCreateRequest);

    Customer deleteCustomer(Language language, Long customerId);
}
