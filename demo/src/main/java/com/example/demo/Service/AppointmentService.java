package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Appointment;
import com.example.demo.Repository.AppointInterface;

@Service
public class AppointmentService {

    @Autowired
    private AppointInterface appointmentInterface;

    /**
     * Delete an appointment by ID.
     * @param id The ID of the appointment to delete.
     */
    public void deleteAppointment(Long id) {
        appointmentInterface.deleteById(id);
    }

    /**
     * Retrieve all appointments from the database.
     * @return List of appointments.
     */
    public List<Appointment> getAllAppointments(){
        return appointmentInterface.findAll();
    }

    /**
     * Save a new appointment to the database.
     * @param appointment The appointment object to save.
     * @return The saved appointment object.
     */
    public void saveAppointment(Appointment appointment) {
         appointmentInterface.save(appointment);
    }

    /**
     * Update an existing appointment by ID.
     * @param id The ID of the appointment to update.
     * @param appointment The updated appointment object.
     */
    public void putAppointment(Long id, Appointment appointment) {
        Optional<Appointment> option = appointmentInterface.findById(id);
        if(option.isPresent()){
            Appointment newAppointment = option.get();
            newAppointment.setPatient(appointment.getPatient());
            newAppointment.setDateTime(appointment.getDateTime());
            newAppointment.setReason(appointment.getReason());
            appointmentInterface.save(newAppointment);
        } else {
            throw new RuntimeException("Appointment not found with ID: " + id);
        }
    }
}
