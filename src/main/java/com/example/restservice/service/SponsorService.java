package com.example.restservice.service;

import com.example.restservice.crud.DonorType;
import com.example.restservice.crud.Sponsor;
import com.example.restservice.model.SponsorRequest;
import com.example.restservice.model.SponsorResponse;
import com.example.restservice.repository.DonorTypeRepository;
import com.example.restservice.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SponsorService {

    @Autowired
    private SponsorRepository sponsorRepository;

    @Autowired
    private DonorTypeRepository donorTypeRepository;

    public SponsorResponse createSponsor(SponsorRequest sponsorRequest) {
        DonorType donorType = donorTypeRepository.findById(sponsorRequest.getDonorTypeId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Donor Type Id"));

        Sponsor sponsorEntity = toSponsorEntity(sponsorRequest, donorType);

        Sponsor savedSponsor = sponsorRepository.save(sponsorEntity);

        return toSponsorResponse(savedSponsor);
    }

    private Sponsor toSponsorEntity(SponsorRequest sponsorRequest, DonorType donorType) {
        return Sponsor.builder()
                .sponsorName(sponsorRequest.getSponsorName())
                .rhNo(sponsorRequest.getRhNo())
                .panNumber(sponsorRequest.getPanNumber())
                .mobileNo(sponsorRequest.getMobileNo())
                .emailId(sponsorRequest.getEmailId())
                .donorType(donorType)
                .createdOn(LocalDateTime.now())
                .createdBy(sponsorRequest.getCreatedBy())
                .modifiedOn(LocalDateTime.now())
                .modifiedBy(sponsorRequest.getModifiedBy())
                .birthday(sponsorRequest.getBirthday())
                .address(sponsorRequest.getAddress())
                .build();
    }

    private SponsorResponse toSponsorResponse(Sponsor savedSponsor) {
        return SponsorResponse.builder()
                .sponsorId(savedSponsor.getSponsorNo())
                .sponsorName(savedSponsor.getSponsorName())
                .rhNo(savedSponsor.getRhNo())
                .panNumber(savedSponsor.getPanNumber())
                .modifiedOn(savedSponsor.getModifiedOn())
                .modifiedBy(savedSponsor.getModifiedBy())
                .mobileNo(savedSponsor.getMobileNo())
                .emailId(savedSponsor.getEmailId())
                .donorTypeName(savedSponsor.getDonorType().getDonorTypeName())
                .createdOn(savedSponsor.getCreatedOn())
                .createdBy(savedSponsor.getCreatedBy())
                .birthday(savedSponsor.getBirthday())
                .address(savedSponsor.getAddress())
                .build();
    }
}
