package io.olidam.accounts.service.model.mapper;

import io.olidam.accounts.service.model.dto.CustomerDto;
import io.olidam.accounts.service.model.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toApi(CustomerEntity entity);

    CustomerEntity toDb(CustomerDto dto);

    default List<CustomerDto> toApi(List<CustomerEntity> source) {
        return source.stream()
                .map(this::toApi)
                .toList();
    }

    default List<CustomerEntity> toDb(List<CustomerDto> source) {
        return source.stream()
                .map(this::toDb)
                .toList();
    }
}

