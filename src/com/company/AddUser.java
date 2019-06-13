package com.company;

import java.util.ArrayList;
import java.util.List;

public class AddUser {

    public List<UserData> lista{
      lista = new ArrayList<UserData>;
    };

    public void addUser(UserData userData) {
        UserData userek;
        userek.createUser();
        lista.add(userek);
    }

    public void displayUSser(ArrayList<UserData> lista) {
        for (int i = 0; i < lista.size(); i++) {
            UserData userData = lista.get();

           // System.out.println(userData.getImie() + " " + userData.getNazwisko() + " "
           //         + userData.getNip());
        }

    }
}