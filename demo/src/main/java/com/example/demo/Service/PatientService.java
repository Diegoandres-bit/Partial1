package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Patient;
import com.example.demo.Repository.PatientInterface;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PatientService {
    @Autowired
    private PatientInterface patientInterface;

    // Retrieve all patients from the database
    public List<Patient> getAllPatients() {
        return patientInterface.findAll();
    }

    // Retrieve a single patient by ID, throw an exception if not found
    public Patient getPatient(Long id) {
        return patientInterface.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + id));
    }

    // Delete a patient by ID
    public void deletePatient(Long id) {
        patientInterface.deleteById(id);
    }

    // Save a new patient to the database
    public void postPatient(Patient patient) {
        patientInterface.save(patient);
    }

    // Update an existing patient's information
    public void updatePatient(Patient patient, Long id) {
        Optional<Patient> afterdata = patientInterface.findById(id);
        if (afterdata.isPresent()) {
            Patient newdata = afterdata.get();
            newdata.setFirstName(patient.getFirstName());
            newdata.setLastName(patient.getLastName());
            newdata.setPhone(patient.getPhone());
            newdata.setEmail(patient.getEmail());
            newdata.setDni(patient.getDni());
            patientInterface.save(newdata);
        } else {
            throw new RuntimeException("Patient not found with ID: " + id);
        }
    }
}

