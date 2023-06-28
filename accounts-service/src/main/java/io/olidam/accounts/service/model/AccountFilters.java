package io.olidam.accounts.service.model;

import lombok.Builder;

@Builder
public record AccountFilters(
        Integer customerId,
        String accountType,
        String branchAddress
) {
}
