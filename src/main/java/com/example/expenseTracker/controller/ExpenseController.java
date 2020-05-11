package com.example.expenseTracker.controller;

import com.example.expenseTracker.Dao.ExpenseDao;
import com.example.expenseTracker.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpenseController {

    @Autowired
    private ExpenseDao expenseDao;

    @GetMapping("/expenses")
    List<Expense> getExpenses(){
        return expenseDao.findAll();
    }

    @DeleteMapping("/expenses/{id}")
    ResponseEntity<?> deleteExpense(@PathVariable Long id){
        expenseDao.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/expenses")
    ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense) throws URISyntaxException{
        Expense result = expenseDao.save(expense);
        return ResponseEntity.created(new URI("/api/expenses" + result.getId())).body(result);
    }

    @PutMapping("/expenses/{id}")
    ResponseEntity<Expense> updateExpense(@RequestBody Expense expense){
        Expense result = expenseDao.save(expense);
        return ResponseEntity.ok().body(result);
    }
}
