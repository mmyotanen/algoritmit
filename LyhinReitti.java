/* Bittimaassa on n kaupunkia, jotka on numeroitu 1, 2, ..., n. Kaupunkien välillä on kaksisuuntaisia teitä, 
joilla on tietyt pituudet. Tehtäväsi on selvittää lyhimmän reitin pituus kaupungista x kaupunkiin y.

Tee luokka LyhinReitti, jossa on seuraavat metodit:

LyhinReitti(int n): kaupunkien määrä annetaan konstruktorissa
void lisaaTie(int a, int b, int p): lisää kaupunkien a ja b välille tien, jonka pituus on p
int laske(int x, int y): ilmoittaa lyhimmän reitin pituuden kaupungista x kaupunkiin y (tai –1, jos mitään reittiä ei ole)


*/


import java.util.*;
class Kaari {
    int alku;
    int loppu;
    int pituus;

    public Kaari(int alku, int loppu, int pituus) {
        this.alku = alku;
        this.loppu = loppu;
        this.pituus = pituus;
    }
}
public class LyhinReitti {  
    int n;
    ArrayList<Kaari> kaaret = new ArrayList<>();
    public LyhinReitti(int n) {
        this.n = n;
    }
    
    public void lisaaTie(int a, int b, int p) {
        kaaret.add(new Kaari(a,b,p));
    }
    
    public int laske(int x, int y) {
         return laskeReitit(x,y);
    }
    int laskeReitit(int mista, int mihin) {
        int n = this.n;
        int[] etaisyys = new int[n+1];
        int INF = 999999999;
        for (int i = 1; i <= n; i++) {
            etaisyys[i] = INF;
        }
        etaisyys[mista] = 0;
        while (true) {
            boolean muutos = false;
            for (Kaari k : kaaret) {
                if (etaisyys[k.alku]+k.pituus < etaisyys[k.loppu]) {
                    etaisyys[k.loppu] = etaisyys[k.alku]+k.pituus;
                    muutos = true;
                }
                if (etaisyys[k.loppu]+k.pituus < etaisyys[k.alku]) {
                    etaisyys[k.alku] = etaisyys[k.loppu]+k.pituus;
                    muutos = true;
                }
            }
            if (!muutos) break;
        }
        if (etaisyys[mihin] == INF) return -1;
        return etaisyys[mihin];
    }
}
