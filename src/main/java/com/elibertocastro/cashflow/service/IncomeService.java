package com.elibertocastro.cashflow.service;

import com.elibertocastro.cashflow.model.IncomeModel;
import com.elibertocastro.cashflow.repository.IncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class IncomeService {
    private IncomeRepository repository;

    public IncomeModel save(IncomeModel incomeModel) {
        return repository.save(incomeModel);
    }

    public List<IncomeModel> getAll() {
        return repository.findAll();
    }

    public Optional<IncomeModel> getOne(Long id) {
        return repository.findById(id);
    }

    public void delete(IncomeModel incomeModel) {
        repository.delete(incomeModel);
    }
}
