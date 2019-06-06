package com.company;

import java.util.Scanner;

public class AddUser extends UserService{

    private Scanner wpisz;
    private String wpiszString;
    private int i;

    public AddUser() {
        wpisz = new Scanner(System.in);
    }

    public void dodajDaneGlowne(){

        i++;
        setImie(wpisz.nextLine());
        setNazwisko(wpisz.nextLine());
        setNip(wpisz.nextInt());
    }

    public void wyswietlDaneGlowne(){
    }

    public void dodajDaneDodatkowe(){

    }



}
