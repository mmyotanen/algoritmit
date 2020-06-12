/* Bittimaassa on n kaupunkia (numeroitu 1, 2, ..., n), joiden välillä on teitä. Tiet ovat kuitenkin huonossa kunnossa, 
ja niitä aletaan kunnostaa.

Tavoitteena on, että kunnostuksen jälkeen minkä tahansa kahden kaupungin välillä pystyy liikkumaan kunnostettuja teitä. 
Mikä on pienin mahdollinen kustannus, kun tiedät jokaisesta tiestä, paljonko sen kunnostus maksaa?

Tee luokka Kunnostus, jossa on seuraavat metodit:

Kunnostus(int n): kaupunkien määrä annetaan konstruktorissa
void lisaaTie(int a, int b, int x): lisää kaupunkien a ja b välille tien, jonka kunnostaminen maksaa x
int laske(): ilmoittaa pienimmän kustannuksen teiden kunnostukseen (tai –1, jos tavoite ei ole mahdollinen)


*/


import java.util.*;
 
public class Kunnostus {     
    int n;
    int[] vanhempi, koko;
 
    int edustaja(int x) {
        while (x != vanhempi[x]) x = vanhempi[x];
        return x;
    }
    
    void yhdista(int a, int b) {
        a = edustaja(a);
        b = edustaja(b);
        if (a == b) return;
        if (koko[a] > koko[b]) {
            koko[a] += koko[b];
            vanhempi[b] = a;
        } else {
            koko[b] += koko[a];
            vanhempi[a] = b;
        }
    }    
    
    class Kaari implements Comparable<Kaari> {
        int alku, loppu, paino;
        
        public Kaari(int alku, int loppu, int paino) {
            this.alku = alku;
            this.loppu = loppu;
            this.paino = paino;
        }
        
        public int compareTo(Kaari k) {
            return paino-k.paino;
        }
    }
    
    ArrayList<Kaari> kaaret = new ArrayList<>();
    
    public Kunnostus(int n) {
        this.n = n;
        vanhempi = new int[n+1];
        koko = new int[n+1];
        for (int i = 1; i <= n; i++) {
            vanhempi[i] = i;
            koko[i] = 1;
        }
    }
    
    public void lisaaTie(int a, int b, int x) {
        kaaret.add(new Kaari(a,b,x));
    }
    
    public int laske() {
        Collections.sort(kaaret);
        int tulos = 0;
        int maara = 0;
        for (Kaari k : kaaret) {
            if (edustaja(k.alku) != edustaja(k.loppu)) {
                maara++;
                tulos += k.paino;
                yhdista(k.alku,k.loppu);
            }
        }
        return maara == n-1 ? tulos : -1;
    }
 
}
