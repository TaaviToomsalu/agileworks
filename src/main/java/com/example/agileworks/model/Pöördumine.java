package com.example.agileworks.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Pöördumine {
    private String id;
    private String kirjeldus;
    private LocalDateTime sisestamiseAeg;
    private ZonedDateTime lahendamiseTähtaeg;
    private boolean lahendatud;
    private boolean aegunudVõiVähemKuiTundJäänud;

    // Constructor
    public Pöördumine(String kirjeldus, ZonedDateTime lahendamiseTähtaeg) {
        this.kirjeldus = kirjeldus;
        this.lahendamiseTähtaeg = lahendamiseTähtaeg;
        this.lahendatud = false;
        this.aegunudVõiVähemKuiTundJäänud = false;
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

    public ZonedDateTime getLahendamiseTähtaeg() {
        return lahendamiseTähtaeg;
    }

    @JsonIgnore
    public String getFormattedLahendamiseTähtaeg() {
        return lahendamiseTähtaeg.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public void setLahendamiseTähtaeg(ZonedDateTime lahendamiseTähtaeg) {
        this.lahendamiseTähtaeg = lahendamiseTähtaeg;
    }

    public boolean isLahendatud() {
        return lahendatud;
    }

    public void setLahendatud(boolean lahendatud) {
        this.lahendatud = lahendatud;
    }

    public boolean isAegunudVõiVähemKuiTundJäänud() {
        return aegunudVõiVähemKuiTundJäänud;
    }

    public void setAegunudVõiVähemKuiTundJäänud(boolean aegunudVõiVähemKuiTundJäänud) {
        this.aegunudVõiVähemKuiTundJäänud = aegunudVõiVähemKuiTundJäänud;
    }

    @Override
    public String toString() {
        return "Pöördumine{" +
                "kirjeldus='" + kirjeldus + '\'' +
                ", sisestamiseAeg=" + sisestamiseAeg +
                ", lahendamiseTähtaeg=" + lahendamiseTähtaeg +
                ", lahendatud=" + lahendatud +
                ", aegunudVõiVähemKuiTundJäänud=" + aegunudVõiVähemKuiTundJäänud +
                '}';
    }
}
