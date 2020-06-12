/*Sinun tulee pitää yllä tehtävälistaa, jossa jokaisella tehtävällä on nimi ja kiireellisyys. 
Voit lisätä listalle uuden tehtävän ja hakea seuraavaksi suoritettavan tehtävän.

Tee luokka Tehtavat, jossa on seuraavat metodit:

void lisaa(String nimi, int kiireellisyys): lisää listalle uuden tehtävän
String hae(): hakee ja poistaa kiireellisimmän tehtävän (jos on monta yhtä kiireellistä tehtävää, 
valitaan aakkosjärjestyksessä ensimmäinen)

*/


import java.util.Comparator;
import java.util.*;

public class Tehtava implements Comparable<Tehtava>{
    
    private int kiireellisyys;
    private String nimi;
    
    Tehtava(String nimi, int kiireellisyys) {
        this.kiireellisyys = kiireellisyys;
        this.nimi = nimi;   
    }
    
    public int haeKiireellisyys(){
        return this.kiireellisyys;  
    }
    
    public String haeNimi(){
        return this.nimi;
    }
 
    @Override
    public int compareTo(Tehtava o) {
        if (this.kiireellisyys == o.kiireellisyys) {
            return o.nimi.compareTo(nimi);
        }
        
        if (this.kiireellisyys < o.kiireellisyys) {
            return -1;
        }
        
        return 1;
    }
    
}

public class Tehtavat {
    private PriorityQueue<Tehtava> kasaS;
    
    
    public Tehtavat() {
        this.kasaS = new PriorityQueue(10, Collections.reverseOrder());
        
    }
    public void lisaa(String nimi, int kiireellisyys) {
        kasaS.add(new Tehtava(nimi, kiireellisyys));
    }
    
    public String hae() {
        return kasaS.poll().haeNimi();
    }
}
