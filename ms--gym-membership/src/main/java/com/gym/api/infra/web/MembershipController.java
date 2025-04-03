package com.gym.api.infra.web;


import com.gym.api.application.dto.MembershipDto;
import com.gym.api.domain.enums.MembershipStatusEnum;
import com.gym.api.domain.model.Membership;
import com.gym.api.domain.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memberships")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;


    @GetMapping
    public ResponseEntity<List<MembershipDto>> findAll() {
        return ResponseEntity.ok(membershipService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembershipDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(membershipService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MembershipDto> createMembership(@RequestBody Membership membership) {
        return ResponseEntity.ok(membershipService.createMembership(membership));
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity activateMembership(@PathVariable Long id) {
        membershipService.updateStatus(id, MembershipStatusEnum.ACTIVE);
        return ResponseEntity.ok("This Membership is Activate");
    }

    @PutMapping("/{id}/inactivate")
    public ResponseEntity inactivateMembership(@PathVariable Long id) {
        membershipService.updateStatus(id, MembershipStatusEnum.CANCELED);
        return ResponseEntity.ok("This Membership is Inactivate");
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        membershipService.deleteById(id);
    }
}
