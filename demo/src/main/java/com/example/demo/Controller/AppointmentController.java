package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Appointment;
import com.example.demo.Service.AppointmentService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Fetch all appointments
    @GetMapping("getallappointments")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Create a new appointment
    @PostMapping("postappointment")
    public void postAppointment(@RequestBody Appointment appointment) {
        appointmentService.saveAppointment(appointment);
    }

    // Delete an appointment by ID
    @DeleteMapping("deleteappointment/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }

    // Update an existing appointment by ID
    @PutMapping("putappointment/{id}")
    public void putappointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        appointmentService.putAppointment(id, appointment);
    }
}
