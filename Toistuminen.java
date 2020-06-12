import java.util.*;

public class Toistuminen {
    private HashMap<Integer, Integer> apuri;
    
    private int viimeksi = 1;
    
    public Toistuminen() {
        apuri = new HashMap<>();
    }
    int uusiLuku(int x) {
        
        if (apuri.containsKey(x)) {
            int apu = viimeksi - apuri.get(x) - 1;
            apuri.replace(x, viimeksi);
            viimeksi++;
            return apu;
        }
        apuri.putIfAbsent(x, viimeksi);
        viimeksi++;
        
        return -1;
    }
}
