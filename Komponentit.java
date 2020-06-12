import java.util.*;

public class Komponentit {     
    int n;
    
    int[] vanhempi;
    int[] koko;
    public Komponentit(int n) {
        vanhempi = new int[n+1];
        koko = new int[n+1];
        for (int i = 1; i <= n; i++) {
            vanhempi[i] = i;
            koko[i] = 1;
        }
        this.n = n;
    }
    public int etsiHuippu(int x) {
        while (vanhempi[x] != x) {
            x = vanhempi[x];
        }
        return x;
    }

    public void yhdista(int a, int b) {
        a = etsiHuippu(a);
        b = etsiHuippu(b);
        if (a == b) {
            return;
        }
        if (koko[a] > koko[b]) {
            vanhempi[b] = a;
            koko[a] += koko[b];
            this.n--;
        } else {
            vanhempi[a] = b;
            koko[b] += koko[a];
            this.n--;
        }
        
    }    
    
    public int laske() {
        return n;
    }

}
