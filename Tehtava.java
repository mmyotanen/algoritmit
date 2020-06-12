
import java.util.Comparator;

public class Tehtava implements Comparable<Tehtava>{
    
    private int kiireellisyys;
    private String nimi;
    
    Tehtava(String nimi, int kiireellisyys) {
        this.kiireellisyys = kiireellisyys;
        this.nimi = nimi;   
    }
    
    public int haeKiireellisyys(){
        return this.kiireellisyys;  
    }
    
    public String haeNimi(){
        return this.nimi;
    }
 
    @Override
    public int compareTo(Tehtava o) {
        if (this.kiireellisyys == o.kiireellisyys) {
            return o.nimi.compareTo(nimi);
        }
        
        if (this.kiireellisyys < o.kiireellisyys) {
            return -1;
        }
        
        return 1;
    }
    
}