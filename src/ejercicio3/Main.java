package ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> malas_palabras = new ArrayList<>();
        malas_palabras.add("malo0");
        malas_palabras.add("malo1");
        malas_palabras.add("malo2");
        malas_palabras.add("malo3");
        malas_palabras.add("malo4");
        malas_palabras.add("malo5");
        malas_palabras.add("malo6");
        malas_palabras.add("malo7");
        malas_palabras.add("malo8");
        malas_palabras.add("malo9");

        List<String> lista = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while(true){
            String palabra = input.nextLine();
            if(palabra.equals("exit")) break;
            for(String pal : malas_palabras){
                palabra = palabra.replace(pal, "****");
            }
            lista.add(palabra);
        }
        lista.forEach(System.out::println);

    }

}
