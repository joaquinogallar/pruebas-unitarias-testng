package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> frutas = new ArrayList<>();
        frutas.add("Manzana");
        frutas.add("Banana");
        frutas.add("Naranja");
        frutas.add("Mandarina");

        // ConcurrentModificationException
/*        for (String fruta : frutas) {
            if (fruta.equals("Banana")) {
                frutas.remove(fruta);
            }
            System.out.println(fruta);
        }*/

        // solucion
        Iterator<String> it = frutas.iterator();

        while(it.hasNext()) {
            String fruta = it.next();
            if (fruta.charAt(0) == 'M') it.remove();
            System.out.println(fruta);
        }
        System.out.println(frutas);
    }
}
