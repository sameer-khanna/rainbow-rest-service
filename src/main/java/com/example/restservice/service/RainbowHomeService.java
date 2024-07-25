package com.example.restservice.service;

import com.example.restservice.crud.RainbowHome;
import com.example.restservice.model.RainbowHomeResponse;
import com.example.restservice.repository.RainbowHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RainbowHomeService {

    @Autowired
    private RainbowHomeRepository rainbowHomeRepository;

    public List<RainbowHomeResponse> getRainbowHomes(List<Short> stateNetworkNos) {
        List<RainbowHome> rainbowHomesEntity = rainbowHomeRepository.findByStateNetworkNoInAndStatus(stateNetworkNos, 1);
        if(rainbowHomesEntity.isEmpty()) {
            throw new RuntimeException("No Rainbow homes found");
        }
        return rainbowHomesEntity.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private RainbowHomeResponse convertToDTO(RainbowHome rainbowHomeEntity) {
        return RainbowHomeResponse.builder()
                .rhNo(rainbowHomeEntity.getRhNo())
                .rhName(rainbowHomeEntity.getRhName())
                .rhCode(rainbowHomeEntity.getRhCode())
                .city(rainbowHomeEntity.getCity())
                .status(rainbowHomeEntity.getStatus())
                .stateNetworkNo(rainbowHomeEntity.getStateNetworkNo())
                .build();
    }
}
