import java.util.*;

public class Merkkijonot {  
    private  ArrayList<String> lista = new ArrayList<>();
    public ArrayList<String> muodosta(int n) {
        char[] alphabet = new char[] {'A','B'};
        
        possibleStrings(n, alphabet,"");
        ArrayList<String> tuloste = lista;
        lista = new ArrayList<>();
        return tuloste;
    }
    
    public  ArrayList possibleStrings(int maxLength, char[] alphabet, String curr) {
        
        
        if(curr.length() == maxLength) {
            lista.add(curr);
            //System.out.println(lista);

        
        } else {
            for(int i = 0; i < alphabet.length; i++) {
                String oldCurr = curr;
                curr += alphabet[i];
                possibleStrings(maxLength,alphabet,curr);
                curr = oldCurr;
            }
        }
        return lista;
        
    }
}
