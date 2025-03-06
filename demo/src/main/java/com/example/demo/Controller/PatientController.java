package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Patient;
import com.example.demo.Service.PatientService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    /**
     * Get a list of all patients.
     * @return List of patients.
     */
    @GetMapping("getallpatients")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    /**
     * Delete a patient by ID.
     * @param id The ID of the patient to delete.
     */
    @DeleteMapping("deletepatient/{id}")
    public void deletPatient(@PathVariable Long id){
        patientService.deletePatient(id);
    }

    /**
     * Add a new patient to the database.
     * @param patient The patient object to save.
     */
    @PostMapping("postpatient")
    public void postPatient(@RequestBody Patient patient){
        patientService.postPatient(patient);
    }

    /**
     * Update an existing patient's information.
     * @param patient The updated patient object.
     * @param id The ID of the patient to update.
     */
    @PutMapping("putpatient/{id}")
    public void updatePatient(@RequestBody Patient patient, @PathVariable Long id){
        patientService.updatePatient(patient, id);
    }
}
