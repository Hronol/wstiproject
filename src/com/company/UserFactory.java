package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserFactory extends UserService{

    private Scanner wpisz;
    private String wpiszString;
    private int i;
    private List<UserFactory> addUsers;

    public UserFactory() {
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

    public void createUser(){
        UserData userdata = new UserData();
        dodajDaneGlowne();
        //addUsers.add();
    }

    public void dodajDoListy(){

        UserFactory nowyUser = new UserFactory();
        nowyUser.dodajDaneGlowne();
        addUsers.add(nowyUser);
    }



}
