/* Bittimaassa on n kaupunkia, jotka on numeroitu 1, 2, ..., n. Kaupunkien välillä on kaksisuuntaisia teitä, joilla on tietyt pituudet. 
Tehtäväsi on muodostaa lyhimmän reitin kuvaus kaupungista x kaupunkiin y.

Tee luokka LyhinReitti, jossa on seuraavat metodit:

LyhinReitti(int n): kaupunkien määrä annetaan konstruktorissa
void lisaaTie(int a, int b, int p): lisää kaupunkien a ja b välille tien, jonka pituus on p
ArrayList<Integer> muodosta(int x, int y): ilmoittaa lyhimmän reitin kaupungista x kaupunkiin y listana kaupunkeja 
(tai null, jos mitään reittiä ei ole)

*/


import java.util.*;
 
public class LyhinReitti { 
    
    int koko;
    ArrayList<Edge> edges;
    int [] distance;
    int [] paths;
    final int INF = 999999999;
    
    public LyhinReitti(int n) {   
        koko = n;
        edges = new ArrayList<Edge>();
        distance = new int[n+1];
        paths = new int[n+1];
    }
    
    public void lisaaTie(int a, int b, int p) {   
        edges.add(new Edge(a, b, p));
        edges.add(new Edge(b, a, p));
    }
    
    public ArrayList<Integer> muodosta(int x, int y) {
        
        ArrayList<Integer> shortestpath = new ArrayList<>();
        if (koko == 2 && edges.size() == 1) {
            return null;
        }
        
        if (koko == 1) {
            shortestpath.add(x);
            return shortestpath;
        } 
        
        for (int i = 1; i < distance.length; i++) {
            distance[i] = INF;
            paths[i] = 0;
        }
        
        distance[x] = 0;
         
        while (true) {
            boolean shorter = false; 
            boolean found = false;
            for (Edge edge : edges) {
                if (edge.getDistance() == -1) {
                    break;
                }
                int first = edge.getEka();
                int last = edge.getVika();
                int is = distance[first] + edge.getDistance();                
                int was = distance[last];
                if (first == y || last == y) {
                    found = true;
                }
                
                if (is < was) {
                    distance[last] = is;
                    paths[last] = first;
                    shorter = true;    
                }
            } 
            if (!shorter) {
                break;
            }  
            if (!found) {
                return null;
            }          
        }
        if (distance[y] == INF) return null;
        shortestpath.add(y);
        
        int destination = y;
        
        while (destination != x) {
                int min = paths[destination];
                shortestpath.add(min);
                destination = min;
        }
        
        Collections.reverse(shortestpath);
        
        return shortestpath;
    }
    
        
}

public class Edge {
    
    int mista;
    int mihin; 
    int etaisyys;
    
    public Edge(int a, int b, int p) {
        this.mista = a;
        this.mihin = b;
        this.etaisyys = p;
        
    }
    
    public int getEka() {
        return mista;
    }
        
    public int getVika() {
        return mihin;
    }
    
    public int getDistance() {
        return etaisyys;
    }
    
}
