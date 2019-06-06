package com.company;

import java.util.ArrayList;
import java.util.List;

public class AddUserObject {

    private List<AddUser> addUsers = new ArrayList<AddUser>();

    public void dodajDoListy(){

        AddUser nowyUser = new AddUser();
        nowyUser.dodajDaneGlowne();
        addUsers.add(nowyUser);
    }

    public static void main(String[] args) {

        AddUserObject test = new AddUserObject();
        test.dodajDoListy();
        System.out.println(test.);
        for(AddUser i : )
    }
}
