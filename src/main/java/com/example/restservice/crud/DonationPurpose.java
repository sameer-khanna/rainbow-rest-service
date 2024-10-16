package com.example.restservice.crud;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "DonationPurpose", schema = "dbo")
public class DonationPurpose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer donationReasonId;

    @Column(name = "purpose_name")
    private String purposeName;


    @Column(name = "is_default")
    private Integer isDefault;


    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "created_by")
    private Integer createdBy;



    public Integer getDonationReasonId() {
        return donationReasonId;
    }

    public void setDonationReasonId(Integer donationReasonId) {
        this.donationReasonId = donationReasonId;
    }

    public String getPurposeName() {
        return purposeName;
    }

    public void setPurposeName(String purposeName) {
        this.purposeName = purposeName;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }



}
