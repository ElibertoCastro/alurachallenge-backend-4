package com.elibertocastro.cashflow.controller;

import com.elibertocastro.cashflow.dto.IncomeDto;
import com.elibertocastro.cashflow.model.IncomeModel;
import com.elibertocastro.cashflow.service.IncomeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/receitas")
public class IncomeController {

    private IncomeService incomeService;

    @PostMapping
    public ResponseEntity<IncomeModel> createIncome(@RequestBody IncomeDto incomeDto) {
        var incomeModel = new IncomeModel();
        BeanUtils.copyProperties(incomeDto,incomeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(incomeService.save(incomeModel));
    }

    @GetMapping
    public ResponseEntity<List<IncomeModel>> getAllIncomes() {
        return ResponseEntity.status(HttpStatus.OK).body(incomeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneIncome(@PathVariable(value = "id") Long id) {
        Optional<IncomeModel> optionalIncomeModel = incomeService.getOne(id);
        if(optionalIncomeModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receita não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalIncomeModel.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateIncome(@PathVariable(value = "id") Long id,
                                               @RequestBody IncomeDto incomeDto) {
        Optional<IncomeModel> optionalIncomeModel = incomeService.getOne(id);
        if(optionalIncomeModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receita não encontrada.");
        }
        BeanUtils.copyProperties(incomeDto,optionalIncomeModel.get());
        return ResponseEntity.status(HttpStatus.OK).body(incomeService.save(optionalIncomeModel.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteIncome(@PathVariable(value = "id") Long id) {
        Optional<IncomeModel> optionalIncomeModel = incomeService.getOne(id);
        if(optionalIncomeModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receita não encontrada.");
        }
        incomeService.delete(optionalIncomeModel.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
