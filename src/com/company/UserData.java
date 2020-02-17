package com.company;


import java.io.Serializable;
import java.util.Comparator;

public class UserData implements Serializable, Comparable<UserData>{
    private String imie, nazwisko, nip, pesel, nazwaFirmy;
    private static int idKlienta = 0;
    private static int idJob = 0;

    public UserData(String imie, String nazwisko, String nip, String pesel, String nazwaFirmy) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nip = nip;
        this.pesel = pesel;
        this.nazwaFirmy = nazwaFirmy;
    }

    public UserData(){
        this.imie = "";
        this.nazwisko = "";
        this.nip = "";
        this.pesel = "";
        this.nazwaFirmy = "";
    }

    public String getImie(){
        return imie;
    }

    public String getNazwisko(){
        return nazwisko;
    }

    public String getNip(){
        return nip;
    }

    public String getPesel() {
        return pesel;
    }

    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setNazwaFirmy(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
    }

    @Override
    public int compareTo(UserData o) {
        return this.getImie().compareTo(o.getImie());
    }
}
