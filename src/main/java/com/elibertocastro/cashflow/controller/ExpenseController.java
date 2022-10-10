package com.elibertocastro.cashflow.controller;

import com.elibertocastro.cashflow.dto.ExpenseDto;
import com.elibertocastro.cashflow.model.ExpenseModel;
import com.elibertocastro.cashflow.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/despesas")
public class ExpenseController {

    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseModel> createExpense(@RequestBody ExpenseDto expenseDto) {
        var expenseModel = new ExpenseModel();
        BeanUtils.copyProperties(expenseDto,expenseModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.save(expenseModel));
    }

    @GetMapping
    public ResponseEntity<List<ExpenseModel>> getAllExpenses() {
        return ResponseEntity.status(HttpStatus.OK).body(expenseService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getOneExpense(@PathVariable(value = "id") Long id) {
        Optional<ExpenseModel> optionalExpenseModel = expenseService.findById(id);
        if(optionalExpenseModel.isEmpty()) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Despesa não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalExpenseModel.get());
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateExpense(@PathVariable(value = "id") Long id,
                                      @RequestBody ExpenseDto expenseDto) {

        var expenseModel = new ExpenseModel();
        Optional<ExpenseModel> optionalExpenseModel = expenseService.findById(id);
        if(optionalExpenseModel.isEmpty()) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Despesa não encontrada.");
        }
        BeanUtils.copyProperties(expenseDto, expenseModel);
        expenseModel.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(expenseService.save(expenseModel));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteExpense(@PathVariable(value = "id") Long id) {
        Optional<ExpenseModel> optionalExpenseModel = expenseService.findById(id);
        if(optionalExpenseModel.isEmpty()) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Despesa não encontrada.");
        }
        expenseService.delete(optionalExpenseModel.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Despesa deletada");
    }
}
