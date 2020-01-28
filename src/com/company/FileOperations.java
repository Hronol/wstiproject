package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

    private String filename = "plik.txt";

    public void tworzPlik() throws IOException {
        File file = new File("plik.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void saveToFile(String filename, ArrayList list){
        Path filePath = Paths.get(filename);

        try{
            Files.write(filePath, list, Charset.defaultCharset());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void zapiszDoPliku(List<UserData> list){
        try
        {
            FileOutputStream fos = new FileOutputStream("UserData");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public void wczytajZPliku(List<UserData> list){
        try
        {
            FileInputStream fis = new FileInputStream("UserData");
            ObjectInputStream ois = new ObjectInputStream(fis);

            list = (ArrayList<UserData>)ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Nie znaleziono klasy");
            c.printStackTrace();
            return;
        }
        
    }
    public void wielkosclisty(List<UserData> list){
        System.out.println("Wielkosc listy : "+list.size());
    }
}
