package com.example.ticket.model.dto;

import java.util.List;

public class TicketCreateRequest {

    private String acao;
    private String objeto;
    private String detalhes;

    private Long criadorId;
    private Long destinatarioId;
    private List<Long> observadoresIds;


    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Long getCriadorId() {
        return criadorId;
    }

    public void setCriadorId(Long criadorId) {
        this.criadorId = criadorId;
    }

    public Long getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(Long destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    public List<Long> getObservadoresIds() {
        return observadoresIds;
    }

    public void setObservadoresIds(List<Long> observadoresIds) {
        this.observadoresIds = observadoresIds;
    }
}