/* Annettuna on taulukko, jossa on n lukua, ja tehtäväsi on selvittää, monellako tavalla voit valita osajoukon luvuista niin, 
että summa on x.

Tee luokka Osajoukot, jossa on seuraavat metodit:

int laske(int[] t, int x): laskee osajoukkojen määrän

*/


import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Osajoukot extends SumSet{  
    
    
    
    
    public int laske(int[] t, int x) {
        ArrayList<Integer> tulos = new ArrayList<>();
        for (int i = 0; i < t.length; i++) {
            tulos.add(t[i]);
        }
        SumSet o = new SumSet();
        o.sum_up(tulos, x);
        
        return o.getMaara();
    }
     
}
class SumSet {
    private int maara;
    public void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
       int s = 0;
       for (int x: partial) s += x;
       if (s == target)
           maara++;
            
       if (s >= target)
            return;
       for(int i=0;i<numbers.size();i++) {
             ArrayList<Integer> remaining = new ArrayList<Integer>();
             int n = numbers.get(i);
             for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
             ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
             partial_rec.add(n);
             sum_up_recursive(remaining,target,partial_rec);
       }
    }
    public void sum_up(ArrayList<Integer> numbers, int target) {
        sum_up_recursive(numbers,target,new ArrayList<Integer>());
    }
    
    public int getMaara() {
        return this.maara;
    }
    
}
