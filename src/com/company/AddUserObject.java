package com.company;

import java.util.ArrayList;
import java.util.List;

public class AddUserObject extends AddUser{

    private static List<AddUser> addUsers = new ArrayList<AddUser>();

    public void dodajDoListy(){

        AddUser nowyUser = new AddUser();
        nowyUser.dodajDaneGlowne();
        addUsers.add(nowyUser);
    }

    public static void main(String[] args) {

        AddUserObject test = new AddUserObject();
        test.dodajDoListy();

        for (int i=0; i<addUsers.size(); i++){
            System.out.println(addUsers.get(i).getImie());
        }
    }
}
