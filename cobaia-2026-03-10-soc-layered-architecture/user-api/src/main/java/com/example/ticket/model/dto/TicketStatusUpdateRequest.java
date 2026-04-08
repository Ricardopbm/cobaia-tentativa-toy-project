package com.example.ticket.model.dto;

import com.example.ticket.enums.Status;

public class TicketStatusUpdateRequest {

    private Status novoStatus;
    private Long responsavelId;

    public Status getNovoStatus() {
        return novoStatus;
    }

    public void setNovoStatus(Status novoStatus) {
        this.novoStatus = novoStatus;
    }

    public Long getResponsavelId() {
        return responsavelId;
    }

    public void setResponsavelId(Long responsavelId) {
        this.responsavelId = responsavelId;
    }
}