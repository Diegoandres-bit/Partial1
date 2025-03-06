package com.example.demo.Models;

import jakarta.persistence.*;
/*
created an entity class for bill
this class will be used to create a bill table in the database
 */
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //created a column for the amount with a not null constraint
    @Column(name = "amount")
    private double amount;

    //created a column for the payment date with a not null constraint
    @Column(name = "payment_date")
    private String paymentDate;

    //created a many to one relationship with the patient table
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Bill() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
}
