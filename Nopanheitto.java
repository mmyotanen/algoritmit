import java.util.*;

public class Nopanheitto {  
    int[] lista = {1, 2 , 3, 4 , 5, 6}; 
    public long laske(int n) {
        long[] maara = new long[n + 1]; 
          
        
        maara[0] = 1; 
          
         
        for (int i = 1; i <= n; i++) 
            for (int j = 0; j < lista.length; j++) 
      
                
                if (i >= lista[j]) 
                    maara[i] += maara[i - lista[j]]; 
          
        
        return maara[n]; 
    }
}
