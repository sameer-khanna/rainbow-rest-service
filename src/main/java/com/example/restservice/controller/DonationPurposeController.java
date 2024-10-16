package com.example.restservice.controller;

import com.example.restservice.crud.DonationPurpose;
import com.example.restservice.crud.DonationReason;
import com.example.restservice.service.DonationPurposeService;
import com.example.restservice.service.DonationReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DonationPurposeController {

    @Autowired
    private DonationPurposeService donationPurposeService;

    @GetMapping("/donationPurpose")
    public ResponseEntity<List<DonationPurpose>> getAllDonationPurpose(){
        List<DonationPurpose> donationPurposes = donationPurposeService.getAllDonationPurpose();
        return ResponseEntity.ok(donationPurposes);
    }

}
