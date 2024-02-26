/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etterem1.pkg0;

import etterem1.pkg0.Controlú.Control.Etterem;
import etterem1.pkg0.Model.Etel;
import etterem1.pkg0.Model.model;
import java.util.List;
import java.util.Map;

/**
 *
 * @author voros.dominik
 */
public class consolraIr {
    public static void main(String[] args) {
        model m1= new model();
        Etterem t1=new Etterem();
      
    Map<String, List<Etel>> rendelesek = t1.asztalokLetrehozasa();
        System.out.println(m1.teljesNyugta(rendelesek));

    
       
        
        
        
    }
}
