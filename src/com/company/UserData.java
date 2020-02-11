package com.company;


import java.io.Serializable;

public class UserData implements Serializable, Comparable<UserData> {
    private String imie, nazwisko, nip;
    private static int idKlienta = 0;
    private static int idJob = 0;

    public UserData(String imie, String nazwisko, String nip) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nip = nip;
    }

    public UserData(){
        this.imie = "";
        this.nazwisko = "";
        this.nip = "";
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

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Override
    public int compareTo(UserData o) {
        return this.getImie().compareTo(o.getImie());
    }

}
