package com.company;

import java.util.Scanner;

public class Menu2 {
    static void menuStart() {

        boolean flag = false;
        Scanner wpisz = new Scanner(System.in);
        String pick, koniec;

        String menu = "1. Dodaj"
                +"\n2. Edytuj"
                +"\n3. Usuń"
                +"\n4. Przegladaj"
                +"\n5. Wróć"
                +"\n\nWybierz operacje:";

        do {
            System.out.println(menu);
            pick = wpisz.nextLine();
            if (pick == "4"){
                flag=true;
            }
            else {
                switch (pick) {
                    case "1":

                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                    case "4":

                        break;
                    case "5":
                        flag=true;
                        break;
                    default:
                        System.out.println("Błąd wprowadzania danych. Spróbuj ponownie.");
                        break;
                }
            }
        }while (!flag);
    }
}

