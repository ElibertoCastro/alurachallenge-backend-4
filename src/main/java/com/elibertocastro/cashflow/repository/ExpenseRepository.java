package com.elibertocastro.cashflow.repository;

import com.elibertocastro.cashflow.model.ExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseModel, Long> {
}
