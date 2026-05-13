package com.bank.cbs.dto;

import lombok.Data;

@Data
public class TransactionRequestDTO {

    private Long accountId;
    private Double amount;

    // for transfer
    private Long toAccountId;
}