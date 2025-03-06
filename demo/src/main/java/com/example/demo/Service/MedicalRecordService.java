package com.example.demo.Service;

import com.example.demo.Models.MedicalRecord;
import com.example.demo.Repository.MedicalRecordInterface;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordInterface medicalRecordInterface;

    // Retrieve all medical records from the database
    public List<MedicalRecord> findAllMedicalRecords() {
        return medicalRecordInterface.findAll();
    }

    // Delete a medical record by ID
    public void deleteMedicalRecord(Long id){
        if(id == null){
            throw new RuntimeException("Medical Record not found with ID: " + id);
        }
        medicalRecordInterface.deleteById(id);
    }

    // Save a new medical record to the database
    public MedicalRecord postMedicalRecord(MedicalRecord medicalRecord){
        return medicalRecordInterface.save(medicalRecord);
    }

    // Update an existing medical record by ID
    public void putMedicalRecord(MedicalRecord medicalRecord, Long id){
        Optional<MedicalRecord> afterdata = medicalRecordInterface.findById(id);
        if(afterdata.isPresent()){
            MedicalRecord newdata = afterdata.get();
            newdata.setPatient(medicalRecord.getPatient());
            newdata.setDiagnosis(medicalRecord.getDiagnosis());
            newdata.setTreatment(medicalRecord.getTreatment());
            newdata.setDate(medicalRecord.getDate());
            medicalRecordInterface.save(newdata);
        } else {
            throw new RuntimeException("Medical Record not found with ID: " + id);
        }
    }
}