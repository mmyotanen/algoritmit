import java.util.*;

public class HatutJaPallot {
    private HashMap<Integer, Integer> pallot;
    private int yksi = 0;
    private int suurin = 0;
    public HatutJaPallot() {
        pallot = new HashMap<>();
    }
   
    void lisaaPallo(int x) {
        
        
        if (pallot.containsKey(x)) {
            pallot.replace(x, pallot.get(x) + 1);
            
        }else {
        pallot.put(x, 1);
        }
        if (suurin < pallot.get(x)) {
            suurin = pallot.get(x);
        }
    }
        
    
    
    int monessakoYksi() {
        
        return pallot.size();
    }
    
    int suurinMaara() {
        return suurin;
    }
}
