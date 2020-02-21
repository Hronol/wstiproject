package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrdersRepository {

    public List<Orders> ordersList = new ArrayList<Orders>();
    public Scanner wpisz = new Scanner(System.in);
    public String set = "";
    public double sprawdzCyfry = 0.0;
    private boolean done = false;

    public void addOrder(Orders orders) {
        ordersList.add(orders);
    }

    public void addOrder(String nazwaUslugi, String nazwaCzesci, double kwota1) {
        Orders tmp = new Orders(nazwaUslugi, nazwaCzesci, kwota1);
        ordersList.add(tmp);
    }

    public void dodajZamowienie() {
        done = false;
        wpisz = new Scanner(System.in);
        Orders tmp = new Orders();
        System.out.print("Podaj nazwę usługi:\t");
        tmp.setNazwaUslugi(wpisz.nextLine());
        System.out.print("Podaj nazwę części:\t");
        tmp.setNazwaCzesci(wpisz.nextLine());
        while (!done){
            System.out.print("Podaj kwotę w PLN z groszami oddzielone ',':\t");
            while (!wpisz.hasNextDouble()){
                System.out.println("Niepoprawne dane - podaj kwotę ponownie\n");
                wpisz.next();
            }
            sprawdzCyfry = wpisz.nextDouble();
            if (sprawdzCyfry > 0.0) {
                tmp.setKwota1(sprawdzCyfry);
                done = true;
            } else {
                System.out.println("\nBłąd wprowadzania danych - wpisz poprawną kwotę\n\n");
            }
        }
        addOrder(tmp);
        System.out.println("\nDodano zamówienie!\n\n");
    }

    public String displayAllOrders(int element) {
        String tmp = "";

        if (element < 0 || element > ordersList.size()-1)
        {
            tmp += "\nNie istnieje element o danym indeksie "+element+"\n\n";
        }
        else
        {
            tmp+= "\nZamówienie nr: "+(element+1)+"\n";
            tmp+= "Nazwa usługi\t\t\t"+ ordersList.get(element).getNazwaUslugi()+"\n";
            tmp+= "Nazwa części\t\t\t"+ ordersList.get(element).getNazwaCzesci()+"\n";
            tmp+= "Kwota\t\t\t\t\t"+ ordersList.get(element).getKwota1()+"\n";
        }
        return tmp;
    }

    public String displayOneOrder(int element){
        String tmp = "";

        tmp+= "\nZamówienie nr: "+(element+1)+"\n";
        tmp+= "Nazwa usługi\t\t\t"+ ordersList.get(element).getNazwaUslugi()+"\n";
        tmp+= "Nazwa części\t\t\t"+ ordersList.get(element).getNazwaCzesci()+"\n";
        tmp+= "Kwota\t\t\t\t\t"+ ordersList.get(element).getKwota1()+"\n";
        System.out.println(tmp);
        return tmp;
    }

    public void edytujZamowienie(int element){
        wpisz = new Scanner(System.in);
        System.out.println("Edytuj nazwę usługi:\t *enter pominie krok");
        set = wpisz.nextLine();
        if (!set.isEmpty()) {
            ordersList.get(element).setNazwaUslugi(set);
        }
        System.out.println("Edytuj nazwę części:\t *enter pominie krok");
        set = wpisz.nextLine();
        if (!set.isEmpty()) {
            ordersList.get(element).setNazwaCzesci(set);
        }
        while (!done) {
            System.out.println("Edytuj kwotę:\t *enter pominie krok");
            sprawdzCyfry = wpisz.nextDouble();
            if ((sprawdzCyfry > 0.0)) {
                ordersList.get(element).setKwota1(sprawdzCyfry);
                done = true;
            }
        }
        System.out.println("\nPoprawnie zaktualizowano zamówienie\n");
    }

    public void usuńZamówienie(int element){

        if(ordersList.size() >= 0) {
            ordersList.remove(element);
        }
        else{
            System.out.println("\nLista pusta\n\n");
        }
    }

}

