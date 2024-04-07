package com.example.agileworks.controller;

import com.example.agileworks.model.Pöördumine;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;


@RestController
@RequestMapping("/api/support-tickets")
public class SupportTicketController {

    private List<Pöördumine> pöördumised = new ArrayList<>();

    @GetMapping
    public List<Pöördumine> getActiveSupportTickets() {
        // Filter active support tickets (not solved and not expired)
        return pöördumised.stream()
                .filter(p -> !p.isLahendatud() && p.getLahendamiseTähtaeg().isAfter(LocalDateTime.now()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public Pöördumine addSupportTicket(@RequestBody Pöördumine pöördumine) {
        // Generate a unique identifier for the new support ticket
        String id = UUID.randomUUID().toString();

        // Set the unique identifier and insertion time to the support ticket
        pöördumine.setId(id);
        pöördumine.setSisestamiseAeg(LocalDateTime.now());

        // Add the support ticket to the list
        pöördumised.add(pöördumine);

        return pöördumine;
    }


    @PutMapping("/{id}")
    public Pöördumine markSupportTicketAsSolved(@PathVariable String id) {
        // Find the support ticket by ID
        for (Pöördumine pöördumine : pöördumised) {
            if (pöördumine.getId().equals(id)) {
                // Mark the support ticket as solved
                pöördumine.setLahendatud(true);
                return pöördumine;
            }
        }
        return null; // Support ticket with the given ID not found
    }

    @DeleteMapping("/{id}")
    public void deleteSupportTicket(@PathVariable String id) {
        // Remove the support ticket with the given ID
        pöördumised.removeIf(p -> p.getId().equals(id));
    }
}
