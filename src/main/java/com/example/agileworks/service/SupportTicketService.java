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
        // Genereerib unikaalse ID pöördumisele
        String id = UUID.randomUUID().toString();

        // Sätib ID
        pöördumine.setId(id);

        // Sätib praeguse aja sisestamiseAeg-le
        pöördumine.setSisestamiseAeg(LocalDateTime.now());

        // Teisendab lahendamiseTähtaeg stringi ZonedDateTime objekti timezonega
        ZonedDateTime lahendamiseTähtaeg = ZonedDateTime.parse(pöördumine.getFormattedLahendamiseTähtaeg());

        // Sätib teisendatud lahendamiseTähtaeg
        pöördumine.setLahendamiseTähtaeg(lahendamiseTähtaeg.withZoneSameInstant(ZoneId.systemDefault()));

        return pöördumine;
    }

    public List<Pöördumine> sortTicketsByDeadlineDescending(List<Pöördumine> pöördumised) {

        // Sorteerib pöördumised kõige esmast tähelepanu vajavatest hilisemateks.
        Collections.sort(pöördumised, Comparator.comparing(Pöördumine::getLahendamiseTähtaeg));

        return pöördumised;
    }

    public List<Pöördumine> getActiveSupportTickets(List<Pöördumine> pöördumised) {
        ZonedDateTime now = ZonedDateTime.now();
        return pöördumised.stream()
                .map(p -> {
                    // Kalkuleerib aja erinevuse praeguse aja ja deadline-ga
                    Duration duration = Duration.between(now, p.getLahendamiseTähtaeg());
                    long hoursRemaining = duration.toHours();

                    // Sättib aegunud mudelivälja
                    if ((hoursRemaining < 1)) {
                        p.setAegunud(true);
                    } else {
                        p.setAegunud(false);
                    }

                    return p;
                })
                .collect(Collectors.toList());
    }


    public void deleteSupportTicket(List<Pöördumine> pöördumised, String id) {
        // Eemaldab pöördumise antud ID-ga
        pöördumised.removeIf(p -> p.getId().equals(id));
    }
}