package com.elibertocastro.cashflow.dto;

import com.elibertocastro.cashflow.category.ExpenseCateory;
import com.elibertocastro.cashflow.category.IncomeCategory;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class IncomeDto {

    private String description;
    private IncomeCategory category;
    private BigDecimal amount;
    private LocalDate date;

}
