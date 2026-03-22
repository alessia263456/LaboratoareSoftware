package lab1;

import java.util.Arrays;

public class Application
{
    public static void main()
    {
        String alfabet="";
        for(int i=0; i<26; i++)
        {
            alfabet+= (char)('a'+i);
        }
        System.out.println(alfabet);
        System.out.println(alfabet.toUpperCase());

        String[] array=new String[26];
        String vocale="aeiou";
        int ct=0;
        Arrays.fill(array,"");
        for(int i=0; i<alfabet.length(); i++)
        {
            array[ct]+=(alfabet.charAt(i));
            if(i<alfabet.length()-1 && vocale.indexOf(alfabet.charAt(i+1))>=0)
                ct++;
        }
        System.out.println("Array:");
        for(int i=0; i<ct; i++)
            System.out.println(array[i]);
    }
}
