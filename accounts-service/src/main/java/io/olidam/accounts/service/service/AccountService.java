package io.olidam.accounts.service.service;

import io.olidam.accounts.service.model.entity.AccountEntity;
import io.olidam.accounts.service.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository repository;

    public List<AccountEntity> findAll() {
        return repository.findAll();
    }

    public Optional<AccountEntity> findByAccountNumber(long accountNumber) {
        return repository.findById(accountNumber);
    }

    public Optional<AccountEntity> findAccountForCustomer(int customerId) {
        return repository.findByCustomerId(customerId);
    }

    public AccountEntity createAccount(AccountEntity newAccount) {
        return repository.save(newAccount);
    }

    public Optional<AccountEntity> delete(long accountNumber) {
        Optional<AccountEntity> accountToDelete = findByAccountNumber(accountNumber);
        accountToDelete.ifPresent(repository::delete);
        return accountToDelete;
    }
}
