package com.example.restservice.service;

import com.example.restservice.crud.RainbowHome;
import com.example.restservice.crud.UserInfo;
import com.example.restservice.model.RainbowHomeResponse;
import com.example.restservice.model.UserInfoResponse;
import com.example.restservice.repository.RainbowHomeRepository;
import com.example.restservice.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private RainbowHomeRepository rainbowHomeRepository;

    public UserInfoResponse getUserInfo(Integer userId) {
        Optional<UserInfo> userInfoOptionalEntity = userInfoRepository.findByUserNo(userId);
        if (!userInfoOptionalEntity.isPresent()) {
            throw new RuntimeException("UserInfo not found for the given userId");
        }

        UserInfo userInfoEntity = userInfoOptionalEntity.get();
        Integer orgId = userInfoEntity.getOrgId();
        Optional<RainbowHome> rainbowHomeOptionalEntity = rainbowHomeRepository.findByrhNo(orgId);
        if (!rainbowHomeOptionalEntity.isPresent()) {
            throw new RuntimeException("RainbowHome not found for the given orgId");
        }
        RainbowHome rainbowHome = rainbowHomeOptionalEntity.get();

        // converting from entity to response
        UserInfoResponse userInfoResponse = convertToDTO(userInfoEntity);
        userInfoResponse.setRainbowHome(convertToDTO(rainbowHome));
        return userInfoResponse;
    }

    private UserInfoResponse convertToDTO(UserInfo userInfoEntity) {
        return UserInfoResponse.builder()
                .userId(userInfoEntity.getUserNo())
                .userName(userInfoEntity.getUserName())
                .orgId(userInfoEntity.getOrgId())
                .orgLevelId(userInfoEntity.getOrgLevelNo())
                .build();
    }

    private RainbowHomeResponse convertToDTO(RainbowHome rainbowHome) {
        // Convert RainbowHome to RainbowHomeResponse
        return RainbowHomeResponse.builder()
                .rhNo(rainbowHome.getRhNo())
                .rhName(rainbowHome.getRhName())
                .rhCode(rainbowHome.getRhCode())
                .stateNetworkNo(rainbowHome.getStateNetworkNo())
                .status(rainbowHome.getStatus())
                .city(rainbowHome.getCity())
                .build();
    }

}
