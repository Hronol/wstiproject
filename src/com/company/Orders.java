package com.company;

public class Orders extends UserData {

    private String nazwaUslugi, nazwaCzesci;
    private int liczenie;
    private double kwota1, kwota2;
    private int idUsera;

    public Orders(String imie, String nazwisko, String nip, String pesel, String nazwaFirmy, String nazwaUslugi, String nazwaCzesci, double kwota1) {
        super(imie, nazwisko, nip, pesel, nazwaFirmy);
        this.nazwaUslugi = nazwaUslugi;
        this.nazwaCzesci = nazwaCzesci;
        this.kwota1 = kwota1;
    }

    public Orders(String nazwaUslugi, String nazwaCzesci, double kwota1) {
        this.nazwaUslugi = nazwaUslugi;
        this.nazwaCzesci = nazwaCzesci;
        this.kwota1 = kwota1;
    }

    public Orders(){
        this.nazwaUslugi = "";
        this.nazwaCzesci = "";
        this.kwota1 = 0.0;
    }

    public String getNazwaUslugi() {
        return nazwaUslugi;
    }

    public void setNazwaUslugi(String nazwaUslugi) {
        this.nazwaUslugi = nazwaUslugi;
    }

    public String getNazwaCzesci() {
        return nazwaCzesci;
    }

    public void setNazwaCzesci(String nazwaCzesci) {
        this.nazwaCzesci = nazwaCzesci;
    }

    public int getLiczenie() {
        return liczenie;
    }

    public void setLiczenie(int liczenie) {
        this.liczenie = liczenie;
    }

    public double getKwota1() {
        return kwota1;
    }

    public void setKwota1(double kwota1) {
        this.kwota1 = kwota1;
    }

    public double getKwota2() {
        return kwota2;
    }

    public void setKwota2(double kwota2) {
        this.kwota2 = kwota2;
    }

    public int getIdUsera() {
        return idUsera;
    }

    public void setIdUsera(int idUsera) {
        this.idUsera = idUsera;
    }

}
