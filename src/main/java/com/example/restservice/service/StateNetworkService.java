package com.example.restservice.service;

import com.example.restservice.crud.StateNetwork;
import com.example.restservice.model.StateNetworkResponse;
import com.example.restservice.repository.StateNetworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StateNetworkService {
    @Autowired
    private StateNetworkRepository stateNetworkRepository;

    @Transactional(readOnly = true)
    public List<StateNetworkResponse> getAllStateNetworks() {
        List<StateNetwork> stateNetworksEntity =  stateNetworkRepository.findAll();
        return stateNetworksEntity.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public StateNetworkResponse getStateNetworkById(Short stateNetworkNo) {
        Optional<StateNetwork> stateNetworkOptionalEntity = stateNetworkRepository.findByStateNetworkNo(stateNetworkNo);
        if (!stateNetworkOptionalEntity.isPresent()) {
            throw new RuntimeException("StateNetwork not found for the given StateNetworkNo");
        }
        return convertToDTO(stateNetworkOptionalEntity.get());
    }

    private StateNetworkResponse convertToDTO(StateNetwork stateNetworkEntity) {
        return StateNetworkResponse.builder()
                .stateNetworkNo(stateNetworkEntity.getStateNetworkNo())
                .stateNetworkName(stateNetworkEntity.getStateNetworkName())
                .stateNetworkCode(stateNetworkEntity.getStateNetworkCode())
                .build();
    }
}
