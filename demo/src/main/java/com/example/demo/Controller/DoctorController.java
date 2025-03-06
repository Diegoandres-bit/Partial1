package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Models.Doctor;
import com.example.demo.Service.DoctorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Fetch all doctors
    @GetMapping("getalldoctors")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // Delete a doctor by ID
    @DeleteMapping("deletedoctor/{id}")
    public void deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
    }

    // Create a new doctor
    @PostMapping("postdoctor")
    public void postDoctor(@RequestBody Doctor doctor) {
        doctorService.postDoctor(doctor);
    }

    // Update an existing doctor by ID
    @PutMapping("putdoctor/{id}")
    public void putDoctor(@RequestBody Doctor doctor, @PathVariable Long id) {
        doctorService.putDoctor(doctor, id);
    }
}
