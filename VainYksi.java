// Jokainen taulukon luku esiintyy tasan kahdesti, paitsi yksi luku esiintyy vain kerran. Mikä on tämä luku?

import java.util.*;

public class VainYksi {
    int etsi(int[] t) {
        Arrays.sort(t);
        
        for (int i = 0; i < t.length; i++) {
            if (i == t.length - 1) {
                return t[i];
            }
            if (t[i] != t[i+1]) {
                return t[i];
            }
            i++;
        }
        return 0;
        
        
    }
}
