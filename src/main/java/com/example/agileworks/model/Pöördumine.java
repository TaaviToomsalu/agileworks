package com.example.agileworks.model;

import java.time.LocalDateTime;

public class Pöördumine {
    private String id;
    private String kirjeldus;
    private LocalDateTime sisestamiseAeg;
    private LocalDateTime lahendamiseTähtaeg;
    private boolean lahendatud;

    // Constructor
    public Pöördumine(String kirjeldus, LocalDateTime lahendamiseTähtaeg) {
        this.kirjeldus = kirjeldus;
        this.sisestamiseAeg = LocalDateTime.now();
        this.lahendamiseTähtaeg = lahendamiseTähtaeg;
        this.lahendatud = false;
    }


    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getKirjeldus() {
        return kirjeldus;
    }

    public void setKirjeldus(String kirjeldus) {
        this.kirjeldus = kirjeldus;
    }

    public LocalDateTime getSisestamiseAeg() {
        return sisestamiseAeg;
    }

    public void setSisestamiseAeg(LocalDateTime sisestamiseAeg) {
        this.sisestamiseAeg = sisestamiseAeg;
    }

    public LocalDateTime getLahendamiseTähtaeg() {
        return lahendamiseTähtaeg;
    }

    public void setLahendamiseTähtaeg(LocalDateTime lahendamiseTähtaeg) {
        this.lahendamiseTähtaeg = lahendamiseTähtaeg;
    }

    public boolean isLahendatud() {
        return lahendatud;
    }

    public void setLahendatud(boolean lahendatud) {
        this.lahendatud = lahendatud;
    }

    @Override
    public String toString() {
        return "Pöördumine{" +
                "kirjeldus='" + kirjeldus + '\'' +
                ", sisestamiseAeg=" + sisestamiseAeg +
                ", lahendamiseTähtaeg=" + lahendamiseTähtaeg +
                ", lahendatud=" + lahendatud +
                '}';
    }
}
