package com.company;

import java.util.Scanner;

public class Menu {
        static void menuStart() {

            boolean flag = false;
        Scanner wpisz = new Scanner(System.in);
        String pick, koniec;

        String menu = "1. Zarządzaj klientami"
                +"\n2. Historia transakcji"
                +"\n3. Zapisz/wczytaj"
                +"\n4. Zakończ program"
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
                        Menu2.menuStart();
                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                    case "4":{
                        System.out.println("Czy na pewno chcesz wyjść z programu? t/n");
                        koniec = wpisz.nextLine();
                        if (koniec == "t") {
                            System.exit(0);
                        } else
                            flag=false;
                            break;}
                    default:
                        System.out.println("Błąd wprowadzania danych. Spróbuj ponownie.");
                        break;
                }
            }
        }while (!flag);
    }
}
