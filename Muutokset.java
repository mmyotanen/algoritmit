public class Muutokset {
    int laske(int[] t) {
        int tulos = 0;
        
        for (int i = 0; i < t.length; i++) {
            
            if (i == t.length - 1) {
                return tulos;
            }
            if (t[i] == t[i+1]) {
                t[i + 1]++;
                if (i == t.length - 2) {
                    tulos++;
                    return tulos;
                }
                if (t[i + 1] == t[i + 2]) {
                    t[i + 1]++;
                }
                tulos++;
            }
        }
        return 0;
    }
}
