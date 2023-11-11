package com.tourism.tourismtechnology.mapper;

import com.tourism.tourismtechnology.entity.Transaction;
import com.tourism.tourismtechnology.model.TransactionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(source = "client.id", target = "customerId")
    @Mapping(source = "business.id", target = "businessId")
    TransactionDto toDto(Transaction transaction);

    Transaction toEntity(TransactionDto transactionDto);
}