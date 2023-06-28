package io.olidam.accounts.service.model.dto;

import lombok.Builder;
import lombok.With;

import java.time.LocalDate;

@With
@Builder
public record AccountDto(
        Long accountNumber,
        Integer customerId,
        String accountType,
        String branchAddress,
        LocalDate createdDate
) {
}
