package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//this interface will be used to create the repository for the Pet class
//this will be used to interact with the database

import com.example.demo.Models.Appointment;
//created a repository for the Appointment class
//this will be used to interact with the database
@Repository
public interface AppointInterface extends JpaRepository<Appointment, Long> {

}
