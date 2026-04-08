package com.example.ticket.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ticket.model.dto.TicketCreateRequest;
import com.example.ticket.model.dto.TicketStatusUpdateRequest;
import com.example.ticket.repository.TicketRepository;
import com.example.ticket.repository.entity.Ticket;
import com.example.ticket.enums.Status;
import com.example.user.repository.entity.User;

import jakarta.persistence.EntityManager;

@Service
public class TicketService {

    private final TicketRepository repository;
    private final EntityManager em;

    public TicketService(TicketRepository repository, EntityManager em) {
        this.repository = repository;
        this.em = em;
    }

    // 🔵 CRIAR TICKET
    public Ticket criar(TicketCreateRequest dto) {

        Ticket ticket = new Ticket();

        ticket.setAcao(dto.getAcao());
        ticket.setObjeto(dto.getObjeto());
        ticket.setDetalhes(dto.getDetalhes());

        // 🔥 AQUI ESTÁ A CORREÇÃO REAL
        User criador = em.getReference(User.class, dto.getCriadorId());
        User destinatario = em.getReference(User.class, dto.getDestinatarioId());

        ticket.setCriador(criador);
        ticket.setDestinatario(destinatario);

        // 🔵 OBSERVADORES
        if (dto.getObservadoresIds() != null) {
            List<User> observadores = dto.getObservadoresIds().stream()
                    .map(id -> em.getReference(User.class, id))
                    .toList();

            ticket.setObservadores(observadores);
        }

        ticket.setStatus(Status.PENDENTE);
        ticket.setCreatedAt(LocalDateTime.now());

        return repository.save(ticket);
    }

    // 🟡 ATUALIZAR STATUS
    public Ticket atualizarStatus(Long id, TicketStatusUpdateRequest dto) {

        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }

        Ticket ticket = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket não encontrado"));

        if (!ticket.getStatus().podeIrPara(dto.getNovoStatus())) {
            throw new RuntimeException("Transição inválida");
        }

        ticket.setStatus(dto.getNovoStatus());

        if (dto.getResponsavelId() != null) {
            User responsavel = em.getReference(User.class, dto.getResponsavelId());
            ticket.setResponsavel(responsavel);
        }

        ticket.setUpdatedAt(LocalDateTime.now());

        return repository.save(ticket);
    }
}