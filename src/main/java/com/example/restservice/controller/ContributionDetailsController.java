package com.example.restservice.controller;

import com.example.restservice.model.ContributionRequest;
import com.example.restservice.model.ContributionResponse;
import com.example.restservice.service.ContributionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ContributionDetailsController {

    @Autowired
    private ContributionDetailsService contributionDetailsService;

    @PostMapping("/createContribution")
    public ResponseEntity<ContributionResponse> createContribution(@RequestBody ContributionRequest contributionRequest) {
        ContributionResponse savedContribution = contributionDetailsService.createContribution(contributionRequest);
        return new ResponseEntity<>(savedContribution, HttpStatus.CREATED);
    }
}
