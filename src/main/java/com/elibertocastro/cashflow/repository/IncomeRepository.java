package com.elibertocastro.cashflow.repository;

import com.elibertocastro.cashflow.model.IncomeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeModel, Long> {
}
