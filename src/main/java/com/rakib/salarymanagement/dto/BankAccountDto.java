package com.rakib.salarymanagement.dto;

import lombok.Data;

@Data
public class BankAccountDto extends BaseDto {
    private String accountName;
    private String accountNumber;
    private String accountType;
    private double currentBalance;
    private String bankName;
    private String branchName;
}
