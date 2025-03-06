package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Models.MedicalRecord;
import com.example.demo.Service.MedicalRecordService;

@RestController
@RequestMapping("/api/medicalrecord")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    // Fetch all medical records
    @GetMapping("getallmedicalrecords")
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordService.findAllMedicalRecords();
    }

    // Create a new medical record receving a Json
    @PostMapping(value ="postmedicalrecord", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        medicalRecordService.postMedicalRecord(medicalRecord);
    }

    // Delete a medical record by ID
    @DeleteMapping("deletemedicalrecord/{id}")
    public void deleteMedicalRecord(Long id) {
        medicalRecordService.deleteMedicalRecord(id);
    }


    //update a medical record with a id and a json
    @PutMapping("putmedicalrecord/{id}")
    public void putmedicalrecord(@PathVariable Long id, @RequestBody MedicalRecord medicalRecord) {
        medicalRecordService.putMedicalRecord(medicalRecord,id);
    }
}
