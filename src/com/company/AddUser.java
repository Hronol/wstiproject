package com.company;

import java.util.Scanner;

public class AddUser {

    private Scanner wpisz;
    private String wpiszString;
    public  UserData newUser = new UserData();

    public AddUser() {
        wpisz = new Scanner(System.in);
    }

    public void dodajDaneGlowne(){

        newUser.setImie(wpisz.nextLine());
        newUser.setNazwisko(wpisz.nextLine());
        newUser.setNip(wpisz.nextInt());
    }

    public void wyswietlDaneGlowne(){

        System.out.println(newUser.getImie());
        System.out.println(newUser.getNazwisko());
        System.out.println(newUser.getNip());

    }
}
