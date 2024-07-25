package com.example.restservice.service;


import com.example.restservice.crud.ContributionDetails;
import com.example.restservice.model.ContributionRequest;
import com.example.restservice.model.ContributionResponse;
import com.example.restservice.repository.ContributionDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContributionDetailsService {

    @Autowired
    private ContributionDetailsRepository contributionDetailsRepository;

    @Transactional
    public ContributionResponse createContribution(ContributionRequest contributionRequest) {
        ContributionDetails requestEntity = toRequestEntity(contributionRequest);
        ContributionDetails savedContributionEntity = contributionDetailsRepository.save(requestEntity);
        return toContributionResponse(savedContributionEntity);
    }

    private ContributionDetails toRequestEntity(ContributionRequest contributionRequest) {
        return ContributionDetails.builder()
                .rhNo(contributionRequest.getRHNo())
                .sponsorshipTypeId(contributionRequest.getSponsorshipTypeID())
                .sponsorName(contributionRequest.getSponsorName())
                .contributionDate(contributionRequest.getContributionDate())
                .inkindID(contributionRequest.getInkindId())
                .quantity(contributionRequest.getQuantity())
                .amount(contributionRequest.getAmount())
                .createdOn(contributionRequest.getCreatedOn())
                .createdBy(contributionRequest.getCreatedBy())
                .modifiedBy(contributionRequest.getModifiedBy())
                .modifiedOn(contributionRequest.getModifiedOn())
                .status(true)
                .donationReasonId(contributionRequest.getDonationReasonId())
                .donationOccasion(contributionRequest.getDonationOccasion())
                .programTypeId(contributionRequest.getProgramTypeId())
                .donorPreferenceId(contributionRequest.getDonorPreferenceId())
                .sponsorId(contributionRequest.getSponsorId())
                .build();
    }

    private ContributionResponse toContributionResponse(ContributionDetails savedContributionEntity) {
        return ContributionResponse.builder()
                .contributionId(savedContributionEntity.getContributionNo())
                .rhNo(savedContributionEntity.getRhNo())
                .sponsorshipTypeID(savedContributionEntity.getSponsorshipTypeId())
                .sponsorName(savedContributionEntity.getSponsorName())
                .contributionDate(savedContributionEntity.getContributionDate())
                .inkindId(savedContributionEntity.getInkindID())
                .quantity(savedContributionEntity.getQuantity())
                .amount(savedContributionEntity.getAmount())
                .createdOn(savedContributionEntity.getCreatedOn())
                .createdBy(savedContributionEntity.getCreatedBy())
                .modifiedBy(savedContributionEntity.getModifiedBy())
                .modifiedOn(savedContributionEntity.getModifiedOn())
                .donationReasonId(savedContributionEntity.getDonationReasonId())
                .donationOccasion(savedContributionEntity.getDonationOccasion())
                .programTypeId(savedContributionEntity.getProgramTypeId())
                .donorPreferenceId(savedContributionEntity.getDonorPreferenceId())
                .sponsorId(savedContributionEntity.getSponsorId())
                .status(savedContributionEntity.getStatus())
                .build();
    }
}
