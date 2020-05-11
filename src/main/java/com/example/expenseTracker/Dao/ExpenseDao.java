package com.example.expenseTracker.Dao;

import com.example.expenseTracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseDao extends JpaRepository<Expense,Long> {
}
