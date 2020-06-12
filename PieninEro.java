import java.util.*;

public class PieninEro {
    int laske(int[] t) {
        Arrays.sort(t);
        int pienin = t[1] - t[0];
        
        for (int i = 1; i < t.length - 1; i++) {
            int apu = t[i+1] - t[i];
            if (apu < pienin) {
                pienin = apu;
            }
        }
        return pienin;
    }
}
