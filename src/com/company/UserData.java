package com.company;

public class UserData {
    private String imie, nazwisko;
    private int nip;
    private static int idKlienta = 0;
    private static int idJob = 0;

    public UserData() {
        imie = " ";
        nazwisko = " ";
        nip = 0;
        idJob = ++idKlienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getIdKlienta() {
        return idKlienta;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }


}
