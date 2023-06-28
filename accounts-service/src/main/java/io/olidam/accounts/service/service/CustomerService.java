package io.olidam.accounts.service.service;

import io.olidam.accounts.service.model.entity.CustomerEntity;
import io.olidam.accounts.service.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;

    public List<CustomerEntity> findAll() {
        return repository.findAll();
    }

    public Optional<CustomerEntity> findCustomer(int customerId) {
        return repository.findById(customerId);
    }

    public CustomerEntity createCustomer(CustomerEntity newCustomer) {
        return repository.save(newCustomer);
    }

    public Optional<CustomerEntity> delete(int customerId) {
        Optional<CustomerEntity> customerToDelete = findCustomer(customerId);
        customerToDelete.ifPresent(repository::delete);
        return customerToDelete;
    }
}
