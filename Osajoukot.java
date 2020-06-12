import java.util.*;
import java.util.List;

public class Osajoukot extends SumSet{  
    
    
    
    
    public int laske(int[] t, int x) {
        ArrayList<Integer> tulos = new ArrayList<>();
        for (int i = 0; i < t.length; i++) {
            tulos.add(t[i]);
        }
        SumSet o = new SumSet();
        o.sum_up(tulos, x);
        
        return o.getMaara();
    }
     
}
