package com.example.restservice.service;

import com.example.restservice.crud.DonationPurpose;
import com.example.restservice.repository.DonationPurposeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DonationPurposeService {

    @Autowired
    private DonationPurposeRepository donationPurposeRepository;

    public List<DonationPurpose> getAllDonationPurpose(){
        return donationPurposeRepository.findAll();
    }



}
