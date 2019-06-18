package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileOperations {

    private String filename = "plik.txt";

    public void tworzPlik() throws IOException {
        File file = new File("plik.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static void saveToFile(String filename, ArrayList list){
        Path filePath = Paths.get(filename);
        try{
            Files.write(filePath, list, Charset.defaultCharset());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
