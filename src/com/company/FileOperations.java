package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileOperations implements Serializable{

    private String filename = "plik.txt";
    private String newFile = "";
    public Scanner wpisz = new Scanner(System.in);

    public void tworzPlik() {
        try {
            System.out.print("\nPodaj nazwę nowego pliku:\t");
            newFile = wpisz.nextLine();
            File file = new File(newFile+".txt");
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("\nPlik został poprawnie utworzony\n");
            }
        } catch (IOException e) {
            System.out.println("\nTaki plik już istnieje! Spróbuj ponownie.\n\n");
        }
    }

    public void zapiszDoPliku(List<UserData> lista) {

        String blad = "";

        FileOutputStream strumienZapisu = null;
        File plik = new File("userdata.dat");

        try {
            strumienZapisu = new FileOutputStream(plik);
        } catch (FileNotFoundException e) {
            blad += ("\nNie ma takiego pliku " + e + "\n\n");
        }
        DataOutputStream sd = new DataOutputStream(strumienZapisu);

        try {
            sd.writeInt(lista.size());
        } catch (IOException e) {
            blad += ("\nBłąd zapisu liczebności towarow " + e + "\n\n");
        }
        for (int i = 0; i < lista.size(); i++) {
            try {
                sd.writeUTF(lista.get(i).getImie());
                sd.writeUTF(lista.get(i).getNazwisko());
                sd.writeUTF(lista.get(i).getNip());
                sd.writeUTF(lista.get(i).getPesel());
                sd.writeUTF(lista.get(i).getNazwaFirmy());

            } catch (IOException e) {
                blad += ("\nBłąd zapisu " + (i + 1) + "wyjatek " + e + "\n\n");
            }
        }
        try {
            sd.close();
        } catch (IOException e) {
            blad += ("\nNieudane zamkniecie strumienia danych " + e + "\n\n");
        }
        try {
            strumienZapisu.close();
            System.out.println("\nPoprawnie nadpisano baze\n\n");
        } catch (IOException e) {
            blad += ("\nNieudane zamkniecie strumienia zapisu " + e + "\n\n");
        }

    }


    public void wczytajZPliku(List<UserData> lista) {

        String blad = "";

        int userzy = 0;

            FileInputStream strumienWczytania=null;
            File plik = new File("userdata.dat");

            try
            {
                strumienWczytania = new FileInputStream(plik);
            }
            catch (FileNotFoundException e)
            {
                blad += ("Nie ma takiego pliku "+e+"\n");
            }
            DataInputStream sd = new DataInputStream(strumienWczytania);

            try
            {
                userzy=sd.readInt();
            }
            catch (IOException e)
            {
                blad += ("\nBłąd wczytania "+e+"\n\n");
            }
            for (int i =0 ; i<userzy;i++)
            {
                try
                {
                    UserData tmp = new UserData();
                    tmp.setImie(sd.readUTF());
                    tmp.setNazwisko(sd.readUTF());
                    tmp.setNip(sd.readUTF());
                    tmp.setPesel(sd.readUTF());
                    tmp.setNazwaFirmy(sd.readUTF());
                    lista.add(tmp);
                }
                catch (IOException e)
                {
                    blad += ("\nBłąd wczytania "+ (i+1) +"wyjatek "+ e +"\n\n");
                }
            }
            System.out.println("\nPoprawnie wczytano bazę danych\n\n");

            try
            {
                sd.close();
            }
            catch (IOException e)
            {
                blad += ("\nNieudane zamkniecie strumienia danych "+ e +"\n\n");
            }
            try
            {
                strumienWczytania.close();
            }
            catch (IOException e)
            {
                blad += ("\nNieudane zamkniecie strumienia czytania "+ e +"\n\n");
            }
    }

    public void zapiszCSV(List<UserData> list)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("userdata.csv"), "UTF-8"));
            for (UserData userData : list)
            {
                StringBuffer sb = new StringBuffer();
                sb.append(userData.getImie().trim().length() == 0? "" : userData.getImie());
                sb.append(",");
                sb.append(userData.getNazwisko().trim().length() == 0? "" : userData.getNazwisko());
                sb.append(",");
                sb.append(userData.getNip().trim().length() == 0? "" : userData.getNip());
                sb.append(",");
                sb.append(userData.getPesel().trim().length() == 0? "" : userData.getPesel());
                sb.append(",");
                sb.append(userData.getNazwaFirmy().trim().length() == 0? "" : userData.getNazwaFirmy());

                bw.write(sb.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }
}
