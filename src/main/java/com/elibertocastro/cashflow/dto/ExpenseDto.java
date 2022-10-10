package com.elibertocastro.cashflow.dto;

import com.elibertocastro.cashflow.category.ExpenseCateory;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExpenseDto {

    private String description;
    private ExpenseCateory category;
    private BigDecimal amount;
    private LocalDate date;

}
