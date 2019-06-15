package com.company;

import java.util.Scanner;

public class Menu {

    public boolean flag = false;
    public Scanner wpisz = new Scanner(System.in);
    public String pick, koniec;
    UserRepository user = new UserRepository();

    public void wyswietlaj() {
        for (int i = 0; i < user.lista.size(); i++)
            System.out.println(user.displayUser(i));
    }

    public void menuStart() {

        String menu = "1. Zarządzaj klientami"
                + "\n2. Historia transakcji"
                + "\n3. Zapisz/wczytaj"
                + "\n4. Zakończ program"
                + "\n\nWybierz operacje:";

        do {
            System.out.println(menu);
            pick = wpisz.nextLine();
            if (pick == "4") {
                flag = true;
            } else {
                switch (pick) {
                    case "1":
                        zarzadzajKlientami();
                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                    case "4": {
                        System.out.println("Czy na pewno chcesz wyjść z programu? t/n");
                        koniec = wpisz.nextLine();
                        if (koniec.equals("t")) {
                            System.exit(0);
                        } else
                            flag = false;
                        break;
                    }
                    default:
                        System.out.println("Błąd wprowadzania danych. Spróbuj ponownie.");
                        break;
                }
            }
        } while (!flag);
    }

    public void zarzadzajKlientami() {


        String menu = "1. Dodaj"
                + "\n2. Edytuj"
                + "\n3. Usuń"
                + "\n4. Przegladaj"
                + "\n5. Wróć"
                + "\n\nWybierz operacje:";

        do {
            System.out.println(menu);
            pick = wpisz.nextLine();
            if (pick == "4") {
                flag = true;
            } else {
                switch (pick) {
                    case "1":
                        user.wpiszUsera();
                        break;
                    case "2":

                        break;
                    case "3":
                        user.usunUsera();
                        break;
                    case "4":
                        wyswietlaj();
                        break;
                    case "5":
                        menuStart();
                        break;
                    default:
                        System.out.println("Błąd wprowadzania danych. Spróbuj ponownie.");
                        break;

                }
            }
        } while (!flag);

    }



    public void sortujListe() {


        String menu = "1. Sortuj po imieniu"
                +"\n2. Sortuj po nazwisku"
                +"\n3. Sortuj po nipie"
                +"\n4. Wróć"
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
                        user.sortuj();
                        wyswietlaj();
                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                    case "4":
                        menuStart();
                        break;
                    default:
                        System.out.println("Błąd wprowadzania danych. Spróbuj ponownie.");
                        break;
                }
            }
        }while (!flag);
    }


}
