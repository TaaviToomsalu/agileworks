package com.example.agileworks.service;

import com.example.agileworks.model.Pöördumine;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SupportTicketService {

    public Pöördumine processSupportTicket(Pöördumine pöördumine) {
        // Generate a unique identifier for the new support ticket
        String id = UUID.randomUUID().toString();

        // Set the unique identifier
        pöördumine.setId(id);

        // Set the current time as sisestamiseAeg
        pöördumine.setSisestamiseAeg(LocalDateTime.now());

        // Convert the lahendamiseTähtaeg string into a ZonedDateTime object with timezone
        ZonedDateTime lahendamiseTähtaeg = ZonedDateTime.parse(pöördumine.getFormattedLahendamiseTähtaeg());

        // Set the parsed lahendamiseTähtaeg
        pöördumine.setLahendamiseTähtaeg(lahendamiseTähtaeg.withZoneSameInstant(ZoneId.systemDefault()));

        return pöördumine;
    }

    public List<Pöördumine> sortTicketsByDeadlineDescending(List<Pöördumine> pöördumised) {

        Collections.sort(pöördumised, Comparator.comparing(Pöördumine::getLahendamiseTähtaeg));

        return pöördumised;
    }

    public List<Pöördumine> getActiveSupportTickets(List<Pöördumine> pöördumised) {
        ZonedDateTime now = ZonedDateTime.now();
        return pöördumised.stream()
                .map(p -> {
                    // Calculate time difference between current time and deadline
                    Duration duration = Duration.between(now, p.getLahendamiseTähtaeg());
                    long hoursRemaining = duration.toHours();

                    // Set flag based on time remaining
                    if ((hoursRemaining < 1)) {
                        p.setAegunudVõiVähemKuiTundJäänud(true);
                    } else {
                        p.setAegunudVõiVähemKuiTundJäänud(false);
                    }

                    return p;
                })
                .collect(Collectors.toList());
    }

    /*
    public Pöördumine markSupportTicketAsSolved(List<Pöördumine> pöördumised, String id) {
        for (Pöördumine pöördumine : pöördumised) {
            if (pöördumine.getId().equals(id)) {
                // Mark the support ticket as solved
                pöördumine.setLahendatud(true);
                return pöördumine;
            }
        }
        return null; // Support ticket with the given ID not found
    }
    */


    public void deleteSupportTicket(List<Pöördumine> pöördumised, String id) {
        // Remove the support ticket with the given ID
        pöördumised.removeIf(p -> p.getId().equals(id));
    }
}