import java.util.*;

public class Mediaani {
    PriorityQueue<Integer> iso = new PriorityQueue<>(10, Collections.reverseOrder());
    PriorityQueue<Integer> pieni = new PriorityQueue<>();
    int mediaani = 0;
    public Mediaani() {
        this.iso = new PriorityQueue<>(10, Collections.reverseOrder());
        this.pieni = new PriorityQueue<>();
    }
    public void lisaa(int x) {
        if(x>mediaani) {
            pieni.add(x);
        }
        
        if(x<mediaani) {
            iso.add(x);
        }
        if (x == mediaani) {
            pieni.add(x);
        }
        if(Math.abs(iso.size()-pieni.size()) > 1) {
            if(iso.size()>pieni.size()) {
                pieni.add(iso.poll());
            } if(pieni.size()>iso.size()) {
                iso.add(pieni.poll());
            }
        }
        
        if(pieni.size() == iso.size()) {
            mediaani = iso.peek();
        }
        
        if(pieni.size() > iso.size()) {
            mediaani = pieni.peek();
        }
        
        if(iso.size() > pieni.size()) {
            mediaani = iso.peek();
        }
    }
    
    public int mediaani() {
        return mediaani;
    }
}
