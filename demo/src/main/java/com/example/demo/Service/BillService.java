package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Bill;
import com.example.demo.Repository.BillInterface;

@Service
public class BillService {

    @Autowired
    private BillInterface billInterface;

    /**
     * Save a new bill to the database.
     * @param bill The bill object to save.
     * @return The saved bill object.
     */
    public Bill saveBill(Bill bill) {
        return billInterface.save(bill);
    }

    /**
     * Delete a bill by ID.
     * @param id The ID of the bill to delete.
     */
    public void deleteBill(Long id) {
        billInterface.deleteById(id);
    }

    /**
     * Retrieve all bills from the database.
     * @return List of all bills.
     */
    public List<Bill> getAllBills(){
        return billInterface.findAll();
    }

    /**
     * Update an existing bill by ID.
     * @param id The ID of the bill to update.
     * @param bill The updated bill object.
     */
    public void putBill(Long id, Bill bill) {
        Optional<Bill> afterBill = billInterface.findById(id);
        if(afterBill.isPresent()){
            Bill newBill = afterBill.get();
            newBill.setPatient(bill.getPatient());
            newBill.setAmount(bill.getAmount());
            newBill.setPaymentDate(bill.getPaymentDate());
            billInterface.save(newBill);
        } else {
            throw new RuntimeException("Bill not found with ID: " + id);
        }
    }
}
