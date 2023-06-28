package io.olidam.accounts.service.repository;

import io.olidam.accounts.service.model.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    Optional<AccountEntity> findByCustomerId(int customerId);
}
