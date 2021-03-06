/* Tehtäväsi on laskea, monellako tavalla voit saada summan n heittämällä yhden tai useamman kerran noppaa. 
Jokainen nopan heitto tuottaa silmäluvun 1–6. Esimerkiksi jos n = 4, tapoja on kaikkiaan 8: 
[1,1,1,1], [1,1,2], [1,2,1], [2,1,1], [2,2], [1,3], [3,1] ja [4].

Tee luokka Nopanheitto, jossa on seuraavat metodit:

long laske(int n): palauttaa heittotapojen määrän

*/


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
