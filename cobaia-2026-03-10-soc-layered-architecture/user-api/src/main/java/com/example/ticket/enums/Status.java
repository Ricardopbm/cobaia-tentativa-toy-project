package com.example.ticket.enums;

public enum Status {

    PENDENTE,
    EM_ANDAMENTO,
    RESOLVIDO,
    CANCELADO;

    public boolean podeIrPara(Status novo) {
        return switch (this) {

            case PENDENTE ->
                novo == EM_ANDAMENTO || novo == CANCELADO;

            case EM_ANDAMENTO ->
                novo == RESOLVIDO;

            case RESOLVIDO, CANCELADO ->
                false;
        };
    }
}