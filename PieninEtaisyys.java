import java.util.*;

public class PieninEtaisyys {
    private TreeSet<Integer> taulu;
    private int pienin = 0;
    public PieninEtaisyys() {
        this.taulu = new TreeSet<>();
    }
    public void lisaa(int x) {
        
        taulu.add(x);
        
        
        int ali = 0;
        int yli = 0;
        if (!(taulu.higher(x) == null)) {
            yli = taulu.higher(x) - x;
            
        }
        if (!(taulu.lower(x) == null)) {
            ali = x - taulu.lower(x);
        }
        
        if (pienin == 0) {
            if (ali == 0) {
                pienin = yli;
            } else {
                pienin = ali;
            }
            
            
        }
        
        if (pienin > ali && ali > 0) {
            pienin = ali;
        }
        if (pienin > yli && yli > 0) {
            pienin = yli;
        }
    }

    public int laske() {
        return pienin;
    }
}
