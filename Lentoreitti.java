import java.util.*;

public class Lentoreitti {  
    private ArrayDeque<Integer> jono = new ArrayDeque<>();
    private ArrayList<Integer>[] verkko;
    private int[] tila;
    private int[] etaisyys;
    public Lentoreitti(int n) {
        this.verkko = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            verkko[i] = new ArrayList<>();
        }
        this.tila = new int[n+1];
        this.etaisyys = new int[n+1];
        
        
    }
    
    public void lisaaYhteys(int a, int b) {
        verkko[a].add(b);
        verkko[b].add(a);
    }
    
    public int laske(int x, int y) {
        leveyshaku(x);
        return etaisyys[y] - 1;
    }
    
    public void leveyshaku(int alku) {
        jono.add(alku);
        tila[alku] = 1;
        etaisyys[alku] = 0;
        while (true) {
            if (jono.isEmpty()) {
                break;
            }
            int solmu = jono.poll();
            
            for (int naapuri : verkko[solmu]) {
                if (tila[naapuri] == 1) {
                    continue;
                }
                jono.add(naapuri);
                tila[naapuri] = 1;
                
                etaisyys[naapuri] = etaisyys[solmu] + 1;
                
            }
        }
    }
}
