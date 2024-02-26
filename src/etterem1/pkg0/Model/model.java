/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etterem1.pkg0.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author voros.dominik
 */
public class model {
    public String szeparator="-";
    public String Asztalszeparator="=";
    public String space=" ";

    public List<Etel> setList() {
         List<Etel> etelLista = Arrays.asList(
            new Etel("Pizza", 1500),
            new Etel("Hamburger", 850),
            new Etel("Sült krumpli", 450)
            );
        return etelLista;
    }

    public String teljesNyugta( Map<String,List<Etel>> rendelesek) {
        String nyugta=blokse();
                for (Map.Entry<String, List<Etel>> entry : rendelesek.entrySet()) {
            Object key = entry.getKey();
                    nyugta+=Asztalmegnve((String) key);
            Object val = entry.getValue();
                    nyugta+=Tetelek((List<Etel>) val);
            
        }
               
        
        return nyugta;
    }
    
    
    
    public  String blokse(){
    
        return szeparator.repeat(10)+"\n";
    
    }
    
    public String Asztalmegnve(String szín){
    String fejlec="|"+space+szín+"Asztal"+space.repeat(6)+"|\n";
    String sep=   "|"+space   +  Asztalszeparator.repeat(fejlec.length()-5) +space+"|\n";
    
    return fejlec+sep;
    };
    public String Tetelek(List<Etel> etel){
        String rendtetelek="";
        for (Etel item : etel) {
            rendtetelek+="|"+space+item.getElnevezes()+space.repeat(4)+item.getAr()+"FT |\n";
        }
        rendtetelek+="|"+szeparator.repeat(30)+"|\n";
        rendtetelek+= vegoszeg(etel);
        
        return rendtetelek;
    }
    public String vegoszeg(List<Etel> etel){
        int osszeg=0;
        String fizetendo="";
      for (Etel item : etel) {
           osszeg+=item.getAr();
           
        }
      fizetendo="| összesen"+space.repeat(4)+osszeg+"FT |\n"+"|"+szeparator.repeat(30)+"|\n";
                                                            
        return fizetendo;
        
    
    
    };
    
    
}
