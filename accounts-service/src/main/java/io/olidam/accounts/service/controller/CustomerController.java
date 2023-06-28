package io.olidam.accounts.service.controller;

import io.olidam.accounts.service.model.dto.CustomerDto;
import io.olidam.accounts.service.model.mapper.CustomerMapper;
import io.olidam.accounts.service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;
    private final CustomerMapper mapper;

    @GetMapping
    List<CustomerDto> getAll() {
        return mapper.toApi(service.findAll());
    }

    @GetMapping("{id}")
    CustomerDto getOne(@PathVariable int id) {
        return service.findCustomer(id)
                .map(mapper::toApi)
                .orElseThrow(() -> new RuntimeException("Could not find customer with id " + id));
    }

    @PostMapping
    CustomerDto createCustomer(@RequestBody CustomerDto customer) {
        return mapper.toApi(service.createCustomer(mapper.toDb(customer)));
    }

    @DeleteMapping("{id}")
    CustomerDto deleteCustomer(@PathVariable int id) {
        return service.delete(id)
                .map(mapper::toApi)
                .orElseThrow(() -> new RuntimeException("Could not find customer with id " + id));
    }
}
