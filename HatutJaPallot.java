/* Sinulla on 109 hattua, jotka on numeroitu 1, 2, ..., 109. Aluksi jokainen hattu on tyhjä, mutta sitten niihin aletaan lisätä palloja.


Tee luokka HatutJaPallot, jossa on seuraavat metodit:

void lisaaPallo(int x): lisää pallon hattuun x
int monessakoYksi(): palauttaa, monessako hatussa on ainakin yksi pallo
int suurinMaara(): palauttaa, mikä on suurin pallojen määrä yhdessä hatussa

*/



import java.util.*;

public class HatutJaPallot {
    private HashMap<Integer, Integer> pallot;
    private int yksi = 0;
    private int suurin = 0;
    public HatutJaPallot() {
        pallot = new HashMap<>();
    }
   
    void lisaaPallo(int x) {
        
        
        if (pallot.containsKey(x)) {
            pallot.replace(x, pallot.get(x) + 1);
            
        }else {
        pallot.put(x, 1);
        }
        if (suurin < pallot.get(x)) {
            suurin = pallot.get(x);
        }
    }
        
    
    
    int monessakoYksi() {
        
        return pallot.size();
    }
    
    int suurinMaara() {
        return suurin;
    }
}
