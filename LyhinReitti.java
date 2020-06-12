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
