package com.gym.api.domain.service;

import com.gym.api.application.dto.MembershipDto;
import com.gym.api.domain.enums.MembershipStatusEnum;
import com.gym.api.domain.model.Membership;

import java.util.List;

public interface MembershipService {

    List<MembershipDto> findAll();

    MembershipDto findById(Long id);

    MembershipDto createMembership(Membership membership);

    void updateStatus(Long id, MembershipStatusEnum status);

    void deleteById(Long id);

}
