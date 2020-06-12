public class PisinToisto {
    int laske(int[] t) {
        int tulos = 0;
        int apu = 1;
        
        for (int i = 0; i < t.length; i++) {
            if (i == t.length - 1) {
                if (tulos < apu) {
                    tulos = apu;
                }
                return tulos;
            }
            if (t[i] != t[i+1]) {
                if (tulos < apu) {
                    tulos = apu;
                }
                apu = 1;
            }
            if (t[i] == t[i+1]) {
                
                apu++;
            }
            
        }
        return 0;
    }
}
