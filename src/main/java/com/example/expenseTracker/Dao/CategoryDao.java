package com.example.expenseTracker.Dao;

import com.example.expenseTracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Long> {

    Category getByName(String name);
}