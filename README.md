# Kasutajatoe Pöördumiste Haldamise Süsteem

See on lihtne veebirakendus kasutajatoe pöördumiste haldamiseks.

## Funktsionaalsus

- Kasutajad saavad esitada kasutajatoe pöördumisi.
- Iga kasutajatoe pöördumine sisaldab kirjeldust, esitamise aega ja tähtaega.
- Esitamise aeg määratakse automaatselt praegusele ajale ja teised kohustuslikud väljad täidetakse kasutaja poolt.
- Kasutajad saavad vaadata aktiivseid kasutajatoe pöördumisi tähtaja järgi kahanevas järjestuses.
- Pöördumised, mis lähenevad või ületavad tähtaega, on punase värviga esile tõstetud.
- Kasutajad saavad märkida kasutajatoe pöördumised lahendatuks, eemaldades need nimekirjast.

## Kasutatud Tehnoloogiad

- Java
- Spring Boot
- Maven

## Alustamine

Lokaalse koopia loomiseks ja käivitamiseks järgige neid lihtsaid samme.

### Eeltingimused

- Java arenduskomplekt (JDK)
- Maven

### Paigaldamine

1. Kloonige repositoorium.
   ```sh
   git clone https://github.com/TaaviToomsalu/agileworks

2. Navigeerige projekti kausta.
    ```sh
   cd agileworks
   
3. Ehitage projekt Maveni abil.
    ```sh
   mvn clean package

### Kasutamine

1. Käivitage rakendus.
    ```sh
   mvn spring-boot:run

2. Pääsete rakendusse juurde oma veebibrauseri kaudu.

   http://localhost:8080/

3. Esitage vajadusel kasutajatoe pöördumisi.

4. Hallake aktiivseid kasutajatoe pöördumisi pakutud liidese kaudu.