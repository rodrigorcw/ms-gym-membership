package com.gym.api.infra.adapter;

import com.gym.api.application.dto.MembershipDto;
import com.gym.api.domain.model.Membership;

public class MembershipAdapter {

    public static MembershipDto toDto(Membership membership) {
        MembershipDto toDto = new MembershipDto();
        toDto.setId(membership.getId());
        toDto.setName(membership.getName());
        toDto.setDescription(membership.getDescription());
        toDto.setMonthlyPrice(membership.getMonthlyPrice());
        toDto.setStartMembership(membership.getStartMembership());
        toDto.setEndMembership(membership.getEndMembership());
        toDto.setStatus(membership.getStatus());
        return toDto;
    }

    public static Membership toEntity(MembershipDto membershipDto) {
        Membership toEntity = new Membership();
        toEntity.setId(membershipDto.getId());
        toEntity.setName(membershipDto.getName());
        toEntity.setDescription(membershipDto.getDescription());
        toEntity.setMonthlyPrice(membershipDto.getMonthlyPrice());
        toEntity.setStartMembership(membershipDto.getStartMembership());
        toEntity.setEndMembership(membershipDto.getEndMembership());
        toEntity.setStatus(membershipDto.getStatus());
        return toEntity;
    }
}
