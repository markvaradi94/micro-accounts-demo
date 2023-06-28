package io.olidam.accounts.service.controller;

import io.olidam.accounts.service.model.dto.AccountDto;
import io.olidam.accounts.service.model.dto.CustomerDto;
import io.olidam.accounts.service.model.mapper.AccountMapper;
import io.olidam.accounts.service.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountsController {
    private final AccountService service;
    private final AccountMapper mapper;

    @GetMapping
    List<AccountDto> getAll() {
        return mapper.toApi(service.findAll());
    }

    @GetMapping("{accountNumber}")
    AccountDto findByAccountNumber(@PathVariable long accountNumber) {
        return service.findByAccountNumber(accountNumber)
                .map(mapper::toApi)
                .orElseThrow(() -> new RuntimeException("Could not find account with number %s".formatted(accountNumber)));
    }

    @PostMapping("myAccount")
    AccountDto getAccountDetails(@RequestBody CustomerDto customer) {
        return service.findAccountForCustomer(customer.customerId())
                .map(mapper::toApi)
                .orElseThrow(() -> new RuntimeException("Could not find account for customer with id %s".formatted(customer.customerId())));
    }

    @PostMapping
    AccountDto createAccount(@RequestBody AccountDto account) {
        return mapper.toApi(service.createAccount(mapper.toDb(account)));
    }

    @DeleteMapping("{accountNumber}")
    AccountDto deleteAccount(@PathVariable long accountNumber) {
        return service.delete(accountNumber)
                .map(mapper::toApi)
                .orElseThrow(() -> new RuntimeException("Could not find account with number %s".formatted(accountNumber)));
    }
}
