package com.example.ticket.controller;

import org.springframework.web.bind.annotation.*;

import com.example.ticket.model.dto.*;
import com.example.ticket.repository.entity.Ticket;
import com.example.ticket.service.TicketService;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping
    public Ticket criar(@RequestBody TicketCreateRequest dto) {
        return service.criar(dto);
    }

    @PatchMapping("/{id}/status")
    public Ticket atualizarStatus(@PathVariable Long id,
            @RequestBody TicketStatusUpdateRequest dto) {
        return service.atualizarStatus(id, dto);
    }
}