/* Joka askeleella muodostat taulukosta uuden taulukon, jonka jokainen alkio on summa kahdesta 
vierekkäisestä alkiosta alkuperäisessä taulukossa. Jatkat näin, kunnes taulukossa on vain yksi alkio.
*/
import java.util.*;

public class Taulukko {
    int laske(int[] t) {
        int[] luvut = t;
        int apuri = t.length - 1;
        int[] apu = new int[luvut.length];
        if (t.length < 2) {
            int kk = t[0];
            return kk;
        }
        
        while (apuri > 0) {
        for (int i = 0; i < t.length - 1; i++) {
            
            apu[i] = luvut[i] + luvut[i + 1];
            
            
        }
        
        
        for (int j = 0; j < t.length - 1; j++) {
            luvut[j] = apu[j];
        }
        luvut[apuri] = 0;
        apuri--;
        }
        
        
        int tulostus = apu[0];
        
        return tulostus;
        
        
        
    }
}
