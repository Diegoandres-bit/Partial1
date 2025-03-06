package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Doctor;
import com.example.demo.Repository.DoctorInterface;

@Service
public class DoctorService {

    @Autowired
    private DoctorInterface doctorInterface;

    /**
     * Retrieve all doctors from the database.
     * @return List of doctors.
     */
    public List<Doctor> getAllDoctors() {
        return doctorInterface.findAll();
    }

    /**
     * Delete a doctor by ID.
     * @param id The ID of the doctor to delete.
     */
    public void deleteDoctor(Long id) {
        doctorInterface.deleteById(id);
    }

    /**
     * Save a new doctor to the database.
     * @param doctor The doctor object to save.
     */
    public void postDoctor(Doctor doctor){
        doctorInterface.save(doctor);
    }

    /**
     * Update an existing doctor by ID.
     * @param doctor The updated doctor object.
     * @param id The ID of the doctor to update.
     */
    public void putDoctor(Doctor doctor, Long id){
        Optional<Doctor> afterdata = doctorInterface.findById(id);
        if(afterdata.isPresent()) {
            Doctor newData = afterdata.get();
            newData.setFirstName(doctor.getFirstName());
            newData.setLastName(doctor.getLastName());
            newData.setDni(doctor.getDni());
            newData.setEmail(doctor.getEmail());
            newData.setSpecialty(doctor.getSpecialty());
            doctorInterface.save(newData);
        } else {
            throw new RuntimeException("Doctor not found with ID: " + id);
        }
    }
}
