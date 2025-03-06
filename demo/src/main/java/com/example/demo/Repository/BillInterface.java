package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Bill;
//created a repository for the bill class
//this will be used to interact with the database
@Repository

public interface BillInterface  extends JpaRepository<Bill, Long> {
    
}
