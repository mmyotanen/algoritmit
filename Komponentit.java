/* Tietoverkko muodostuu n koneesta, jotka on numeroitu 1, 2, ..., n. Verkossa on joukko yhteyksiä, 
joista kunkin kautta voi lähettää tietoa molempiin suuntiin kahden koneen välillä. Kaksi konetta kuuluvat samaan komponenttiin, 
jos niiden välillä voi viestiä yhteyksiä käyttäen. Tehtäväsi on laskea verkon komponenttien määrä.

Tee luokka Komponentit, jossa on seuraavat metodit:

Komponentit(int n): koneiden määrä annetaan konstruktorissa
void lisaaYhteys(int a, int b): lisää yhteyden koneiden a ja b välille
int laske(): palauttaa komponenttien määrän


*/


import java.util.*;

public class Komponentit {  
    private ArrayList<Integer>[] verkko;
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int[] tila;
    private int yhteydet;
    private int n;
    private int laskuri;
    
    public Komponentit(int n) {
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
        laskuri++;
        
    }
    
    public int laske() {
        int apuri = 0;
        if (n == 1) {
            return 1;
        }
        if (n > 1 && laskuri == 0) {
            return n;
        }
        for (int i = 1; i < n; i++) {
            
            syvyyshaku(i);
            //System.out.println(yhteydet);
            map.put(yhteydet, 1);
            
        }
        return map.size();
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
