package com.company;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner wpisz = new Scanner(System.in);
        char pick;

        switch (pick) {
            do {
                case 1:
                    AddUserObject.main(null);
                    break;
                case 2:

                    break;
                default:
                    System.out.println("Błąd wprowadzania danych. Spróbuj ponownie.");
                    break;
            }while (pick!='q')
        }
    }
}
