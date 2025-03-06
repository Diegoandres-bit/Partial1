package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Bill;
import com.example.demo.Service.BillService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/bill")
public class BillController {

    @Autowired
    private BillService billService;

    // Fetch all bills
    @GetMapping("getallbills")
    public List<Bill> getAllBills(){
        return billService.getAllBills();
    }

    // Create a new bill
    @PostMapping("postbill")
    public void postbill(@RequestBody Bill bill) {
        billService.saveBill(bill);
    }

    // Delete a bill by ID
    @DeleteMapping("deletebill/{id}")
    public void deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
    }

    // Update an existing bill by ID
    @PutMapping("putbill/{id}")
    public void putBill(@RequestBody Bill bill, @PathVariable Long id) {
        billService.putBill(id, bill);
    }
}
