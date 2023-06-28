package io.olidam.accounts.service.model.mapper;

import io.olidam.accounts.service.model.dto.AccountDto;
import io.olidam.accounts.service.model.entity.AccountEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto toApi(AccountEntity entity);

    AccountEntity toDb(AccountDto dto);

    default List<AccountDto> toApi(List<AccountEntity> source) {
        return source.stream()
                .map(this::toApi)
                .toList();
    }

    default List<AccountEntity> toDb(List<AccountDto> source) {
        return source.stream()
                .map(this::toDb)
                .toList();
    }
}
