/* Tietoverkko muodostuu n koneesta, jotka on numeroitu 1, 2, ..., n. Verkossa on joukko yhteyksiä, 
joista kunkin kautta voi lähettää tietoa molempiin suuntiin kahden koneen välillä. Tehtäväsi on selvittää, 
monenko koneen kanssa tietty kone voi viestiä.

Huom! Tässä ja vastaavissa tehtävissä koneet voivat viestiä keskenään, 
jos niiden välillä on reitti mahdollisesti muiden koneiden kautta.

Tee luokka Saavutettavuus, jossa on seuraavat metodit:

Saavutettavuus(int n): koneiden määrä annetaan konstruktorissa
void lisaaYhteys(int a, int b): lisää yhteyden koneiden a ja b välille
int laske(int x): ilmoittaa, monenko koneen kanssa kone x voi viestiä

*/


import java.util.*;

public class Saavutettavuus {  
    private ArrayList<Integer>[] verkko;
    private int[] tila;
    private int yhteydet;
    private int n;
    public Saavutettavuus(int n) {
        this.verkko = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            verkko[i] = new ArrayList<>();
        }
        this.tila = new int[n+1];
        this.n = n;
    }
    
    public void lisaaYhteys(int a, int b) {
        
        verkko[a].add(b);
        verkko[b].add(a);
    }
    
    public int laske(int x) {
        syvyyshaku(x);
        return yhteydet - 1;
    }
    
    public void syvyyshaku(int solmu) {
        //System.out.println("yritetÃ¤Ã¤n mennÃ¤ solmuun "+solmu);
        if (tila[solmu] == 1) return;
        //System.out.println("pÃ¤Ã¤stiin solmuun "+solmu);
        tila[solmu] = 1;
        yhteydet++;
        for (int naapuri : verkko[solmu]) {
            syvyyshaku(naapuri);
        }
    }
}
