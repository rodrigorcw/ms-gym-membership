package com.gym.api.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gym.api.domain.enums.MembershipStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MembershipDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal monthlyPrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate startMembership;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate endMembership;
    private MembershipStatusEnum status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(BigDecimal monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }


    public MembershipStatusEnum getStatus() {
        return status;
    }

    public void setStatus(MembershipStatusEnum status) {
        this.status = status;
    }

    public LocalDate getStartMembership() {
        return startMembership;
    }

    public void setStartMembership(LocalDate startMembership) {
        this.startMembership = startMembership;
    }

    public LocalDate getEndMembership() {
        return endMembership;
    }

    public void setEndMembership(LocalDate endMembership) {
        this.endMembership = endMembership;
    }
}
