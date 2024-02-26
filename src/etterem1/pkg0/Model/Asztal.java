/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etterem1.pkg0.Model;

import java.util.List;

/**
 *
 * @author voros.dominik
 */
public class Asztal {
    private String Szín;
    private List<Etel> Rendtetelek;

    public Asztal(String Szín, List<Etel> Rendtetelek) {
        this.Szín = Szín;
        this.Rendtetelek = Rendtetelek;
    }

    @Override
    public String toString() {
        return "Asztal{" + "Sz\u00edn=" + Szín + ", Rendtetelek=" + Rendtetelek + '}';
    }
    
}
