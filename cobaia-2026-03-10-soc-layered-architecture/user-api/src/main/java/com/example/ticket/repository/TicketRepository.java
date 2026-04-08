package com.example.ticket.repository;

import org.springframework.stereotype.Repository;

import com.example.ticket.repository.entity.Ticket;
import jakarta.persistence.EntityManager;

import java.util.Optional;

@Repository
public class TicketRepository {

    private final EntityManager em;

    public TicketRepository(EntityManager em) {
        this.em = em;
    }

    public Ticket save(Ticket t) {
        if (t.getId() == null) {
            em.persist(t);
            return t;
        }
        return em.merge(t);
    }

    public Optional<Ticket> findById(Long id) {
        return Optional.ofNullable(em.find(Ticket.class, id));
    }
}