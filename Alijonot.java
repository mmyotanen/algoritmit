import java.util.*;

public class Alijonot {
    long suurin = 1;
    public long laske(int[] t) {
        int n = t.length;
        int[] pisinJono = new int[n];
        int pisin = 1;
        for (int i = 0; i < n; i++) {
            pisinJono[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pisinJono[j]+1 > pisinJono[i] && (t[j] == t[i]+1 || t[j] == t[i]-1)) {
                    pisinJono[i] = pisinJono[j] + 1;
                }
               
            pisin = Math.max(pisin,pisinJono[i]);
           
            }
        }
        
        return pisin;
        
        
        /*haku(0,t);
        long tulos = suurin;
        suurin = 1;
        return tulos;*/
    }
    
    public void haku(int indeksi, int[] t) {
        if (indeksi == t.length) {
            return;
        }
        long apuri = 1;
        long vertaus = t[indeksi];
        for (int i = indeksi + 1; i < t.length; i++) {
            if (Math.abs(vertaus - t[i]) == 1) {
                //System.out.println("kasvatan " + apuri);
                apuri++;
                vertaus = t[i];
            }
            
        }
        if (suurin < apuri) {
            //System.out.println("apuri" + apuri);
            suurin = apuri;
            //System.out.println("suurin " + suurin);
            //System.out.println("muutos");
        }
            
        haku(indeksi + 1, t);
        
        
    }
}
