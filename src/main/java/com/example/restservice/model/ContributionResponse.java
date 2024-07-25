package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ContributionResponse {
    @JsonProperty("contributionId")
    private Integer contributionId;

    @JsonProperty("rhNo")
    private Integer rhNo;

    @JsonProperty("sponsorshipTypeID")
    private Integer sponsorshipTypeID;

    @JsonProperty("sponsorName")
    private String sponsorName;

    @JsonProperty("contributionDate")
    private LocalDateTime contributionDate;

    @JsonProperty("inkindId")
    private Integer inkindId;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("createdOn")
    private LocalDateTime createdOn;

    @JsonProperty("createdBy")
    private Integer createdBy;

    @JsonProperty("modifiedBy")
    private Integer modifiedBy;

    @JsonProperty("modifiedOn")
    private LocalDateTime modifiedOn;

    @JsonProperty("status")
    private Boolean status;

    @JsonProperty("donationReasonId")
    private Integer donationReasonId;

    @JsonProperty("donationOccasion")
    private String donationOccasion;

    @JsonProperty("programTypeId")
    private Integer programTypeId;

    @JsonProperty("donorPreferenceId")
    private Integer donorPreferenceId;

    @JsonProperty("sponsorId")
    private Integer sponsorId;
}
