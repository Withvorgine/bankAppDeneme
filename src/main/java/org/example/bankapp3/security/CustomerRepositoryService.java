package org.example.bankapp3.security;

import org.example.bankapp3.enums.Language;
import org.example.bankapp3.repository.entity.Customer;
import org.example.bankapp3.request.CustomerCreateRequest;
import org.example.bankapp3.request.CustomerUpdateRequest;

import java.util.List;

public interface CustomerRepositoryService {
    Customer createCustomer(Language language, CustomerCreateRequest customerCreateRequest);

    Customer getCustomer(Language language,Long customerId);

    List<Customer> getCustomers(Language language);

    Customer updateCustomer(Language language, long customerId, CustomerUpdateRequest customerUpdateRequest);

    Customer deleteCustomer(Language language, Long CustomerId);
}
