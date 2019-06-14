package com.company;


public class UserData {
    private String imie, nazwisko;
    private int nip;
    private static int idKlienta = 0;
    private static int idJob = 0;

    public UserData(String imie, String nazwisko, int nip) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nip = nip;
    }

    public UserData(){
        this.imie = "";
        this.nazwisko = "";
        this.nip = 0;
    }

    public String getImie(){
        return imie;
    }

    public String getNazwisko(){
        return nazwisko;
    }

    public int getNip(){
        return nip;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }
}
