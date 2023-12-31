package com.tourism.tourismtechnology.model.dto;

import com.tourism.tourismtechnology.model.PointDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class TransactionDto {

    private Long id;
    private BigDecimal amount;
    private Date date;
    private String customerId;
    private String businessId;
    private PointDto pointDto;

}
