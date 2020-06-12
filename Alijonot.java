/* Annettuna on taulukko lukuja ja tehtäväsi on selvittää, kuinka pitkä on pisin alijono, 
jossa jokaisen peräkkäisen luvun ero on tasan 1.

Esimerkiksi taulukossa [6,2,3,5,2,4,1,8] vastaus on 4, koska voimme muodostaa alijonon [2,3,2,1].

*/


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
        
        
        
    }
    
    public void haku(int indeksi, int[] t) {
        if (indeksi == t.length) {
            return;
        }
        long apuri = 1;
        long vertaus = t[indeksi];
        for (int i = indeksi + 1; i < t.length; i++) {
            if (Math.abs(vertaus - t[i]) == 1) {
                
                apuri++;
                vertaus = t[i];
            }
            
        }
        if (suurin < apuri) {
            
            suurin = apuri;
           
        }
            
        haku(indeksi + 1, t);
        
        
    }
}
