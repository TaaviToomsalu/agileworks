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
        // Get active support tickets from the stored list and update the flag for expired tickets
        List<Pöördumine> activeTickets = supportTicketService.getActiveSupportTickets(pöördumised);

        // Sort the active tickets by deadline descending
        activeTickets = supportTicketService.sortTicketsByDeadlineDescending(activeTickets);

        return activeTickets;
    }

    @PostMapping
    public Pöördumine addSupportTicket(@RequestBody Pöördumine pöördumine) {
        Pöördumine processedTicket = supportTicketService.processSupportTicket(pöördumine);
        pöördumised.add(processedTicket);
        return processedTicket;
    }

    /*
    @PutMapping("/{id}")
    public Pöördumine markSupportTicketAsSolved(@PathVariable String id) {
        return supportTicketService.markSupportTicketAsSolved(id);
    }
    */

    /*
    @DeleteMapping("/{id}")
    public void deleteSupportTicket(@PathVariable String id) {
        supportTicketService.deleteSupportTicket(id);
    }
    */
}