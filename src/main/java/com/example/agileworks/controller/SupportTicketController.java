package com.example.agileworks.controller;

import com.example.agileworks.model.Pöördumine;
import com.example.agileworks.service.SupportTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/support-tickets")
public class SupportTicketController {

    private List<Pöördumine> pöördumised = new ArrayList<>();

    @Autowired
    private SupportTicketService supportTicketService;

    @GetMapping
    public List<Pöördumine> getActiveSupportTickets() {
        // Võta aktiivsed pöördumised listist ja uuenda aegunud välja
        List<Pöördumine> activeTickets = supportTicketService.getActiveSupportTickets(pöördumised);

        // Sorteerib aktiivsed pöördumised vähenevas järjestikuses
        activeTickets = supportTicketService.sortTicketsByDeadlineDescending(activeTickets);

        return activeTickets;
    }

    @PostMapping
    public Pöördumine addSupportTicket(@RequestBody Pöördumine pöördumine) {
        Pöördumine processedTicket = supportTicketService.processSupportTicket(pöördumine);
        pöördumised.add(processedTicket);
        return processedTicket;
    }

    @DeleteMapping("/{id}")
    public void deleteSupportTicket(@PathVariable String id) {
        supportTicketService.deleteSupportTicket(pöördumised, id);
    }

}