package com.gym.api.application.service;

import com.gym.api.application.dto.MembershipDto;
import com.gym.api.domain.enums.MembershipStatusEnum;
import com.gym.api.domain.model.Membership;
import com.gym.api.domain.service.MembershipService;
import com.gym.api.exception.ResourceNotFoundException;
import com.gym.api.infra.adapter.MembershipAdapter;
import com.gym.api.infra.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipServiceImpl implements MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    @Override
    public List<MembershipDto> findAll() {
        List<MembershipDto> listMembership =
                membershipRepository.findAll()
                        .stream()
                        .map(MembershipAdapter::toDto)
                        .toList();
        return listMembership;
    }

    @Override
    public MembershipDto findById(Long id) {

        var membershipId = membershipRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID " + id + " Membership not found"));
        return MembershipAdapter.toDto(membershipId);
    }

    @Override
    public MembershipDto createMembership(Membership membership) {
        membership.setStatus(MembershipStatusEnum.ACTIVE);
        var saved = membershipRepository.save(membership);
        return MembershipAdapter.toDto(saved);
    }

    @Override
    public void updateStatus(Long id, MembershipStatusEnum status) {
        Membership membership = membershipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membership not found"));
        membership.setStatus(status);
        membershipRepository.save(membership);
    }

    @Override
    public void deleteById(Long id) {
        if (membershipRepository.existsById(id)) {
            membershipRepository.deleteById(id);
            throw new ResourceNotFoundException("ID " + id + " Membership Deleted");
        } else
            throw new ResourceNotFoundException("ID " + id + " No exists this Membership");
    }
}


