package com.elibertocastro.cashflow.service;

import com.elibertocastro.cashflow.model.ExpenseModel;
import com.elibertocastro.cashflow.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ExpenseService {
    private ExpenseRepository repository;

    @Transactional
    public ExpenseModel save(ExpenseModel expenseModel) {
        return repository.save(expenseModel);
    }

    public List<ExpenseModel> getAll() {
        return repository.findAll();
    }

    public Optional<ExpenseModel> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void delete(ExpenseModel expenseModel) {
        repository.delete(expenseModel);
    }
}
