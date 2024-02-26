/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etterem1.pkg0.Controlú.Control;

import etterem1.pkg0.Model.Asztal;
import etterem1.pkg0.Model.Etel;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;

/**
 *
 * @author voros.dominik
 */
public class Etterem {

    List<Asztal> Astalok;
    List<Etel> Étlap;

    public List<Etel> etelekBeolvasasa(String fajlNev) {
        List<Etel> etelLista = new ArrayList<>();
        try {
            List<String> sorok = Files.readAllLines(Paths.get(fajlNev));
            for (String sor : sorok) {
                String[] adatok = sor.split("\\|");
                if (adatok.length == 2) {
                    String nev = adatok[0];
                    double ar = Integer.parseInt(adatok[1]);
                    etelLista.add(new Etel(nev, (int) ar));
                }
            }
        } catch (IOException e) {
            System.err.println("Hiba történt a fájl olvasása közben: " + e.getMessage());
        }
        return etelLista;
    }

    public Map<String, List<String>> rendelesekBeolvasasa(String fajlNev) {
        Map<String, List<String>> rendelesek = new HashMap<>();
        try {
            List<String> sorok = Files.readAllLines(Paths.get(fajlNev));
            String aktualisKategoria = null;
            for (String sor : sorok) {

                if (sor.isEmpty()) {
                    aktualisKategoria = null;
                } else if (aktualisKategoria == null) {

                    aktualisKategoria = sor;
                    rendelesek.putIfAbsent(aktualisKategoria, new ArrayList<>());
                } else {

                    rendelesek.get(aktualisKategoria).add(sor);
                }
            }
        } catch (IOException e) {
            System.err.println("Hiba történt a fájl olvasása közben: " + e.getMessage());
        }
        return rendelesek;

    }

  public Map<String, List<Etel>> asztalokLetrehozasa() {
    List<Etel> Étlap = etelekBeolvasasa("Etelek.txt");
    Map<String, List<String>> rendelesek = rendelesekBeolvasasa("Rendelesek.txt");
    Map<String, List<Etel>> asztalokEtelei = new HashMap<>();

    for (Map.Entry<String, List<String>> asztal : rendelesek.entrySet()) {
        List<Etel> etelekListaja = new ArrayList<>();
        for (String rendeltEtel : asztal.getValue()) {
            for (Etel etel : Étlap) {
                if (etel.getElnevezes().equals(rendeltEtel)) {
                    etelekListaja.add(etel);
                }
            }
        }
        if (!etelekListaja.isEmpty()) {
            asztalokEtelei.put(asztal.getKey(), etelekListaja);
        }
    }

    return asztalokEtelei;
}
    

   

}
