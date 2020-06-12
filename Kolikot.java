import java.util.*;

public class Kolikot {  
    
    int laskuri;
    
    public int laske(int[] t) {
        kolikkojenMaara(t,t.length);
        
        int tulos = laskuri - 1;
        laskuri = 0;
        
        return tulos;
    }
    
     
     
     void kolikkojenMaara(int arr[], int n) 
    { 
        int sum = 0; 
        for (int i = 0; i < n; i++) 
            sum += arr[i]; 
  
        
        boolean[][] dp = new boolean[n + 1][sum + 1]; 
  
        
        for (int i = 0; i <= n; i++) 
            dp[i][0] = true; 
  
         
        for (int i = 1; i <= n; i++)  
        { 
            dp[i][arr[i - 1]] = true; 
            for (int j = 1; j <= sum; j++)  
            { 
                 
                if (dp[i - 1][j] == true)  
                { 
                    dp[i][j] = true; 
                    dp[i][j + arr[i - 1]] = true; 
                } 
            } 
        } 
  
        
        for (int j = 0; j <= sum; j++) 
            if (dp[n][j] == true) 
                laskuri++;
                
    }
}
