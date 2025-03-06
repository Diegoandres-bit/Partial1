package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.MedicalRecord;
//created a repository for the Doctor class
//this will be used to interact with the database
@Repository
public interface MedicalRecordInterface  extends JpaRepository<MedicalRecord, Long> {
    
}
