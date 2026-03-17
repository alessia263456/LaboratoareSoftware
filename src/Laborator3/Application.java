package Laborator3;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Application {

    public static void main()
    {
        List<String> lista1 = new ArrayList<>();
        List<String> lista2 = new ArrayList<>();
        String text_citit="";
        try
        {
            Path path= Paths.get("in.txt");
            try(Scanner sc=new Scanner(path))
            {
                while (sc.hasNextLine())
                {
                    text_citit+=sc.nextLine()+"\n";
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String[] text_split= text_citit.split("\n");
        for(String s:text_split)
        {
            lista1.add(s);
            lista1.add("\n");
        }
        System.out.println(lista1);

        String[] text_split2 = text_citit.split("\\.");
        for(String s:text_split2)
        {
            lista2.add(s);
            lista2.add("\n");
        }
        System.out.println(lista2);
    }
}
