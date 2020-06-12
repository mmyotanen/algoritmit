/* Tien varrella on n taloa, joista jokaisella on tietty sijainti (kohta x-akselilla). Tehtäväsi on rakentaa tielle bussipysäkkejä niin, 
että jokaisen talon etäisyys lähimpään pysäkkiin on enintään k. Mikä on pienin mahdollinen määrä pysäkkejä?
*/

import java.util.*;

public class Pysakit {
    int laske(int[] t, int k) {
        Arrays.sort(t);
        int pysakki = 1;
        int apu = t[0]+k;
        for (int i = 0; i < t.length; i++) {
            
            if (apu >= t[i]) {
               continue; 
            }
            
            if (apu + k >= t[i]) {
                if (i == t.length -1) {
                    return pysakki;
                }
                i++;
            }
            
            if (apu + k < t[i]) {
                apu = t[i] + k;
                pysakki++;
                
            }
            
            
           
            
            
            
            
            
        }
        return pysakki;
    }
}
