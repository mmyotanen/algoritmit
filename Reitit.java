/* Annettuna on suunnattu syklitön verkko, jossa on n solmua (numeroitu 1, 2, ..., n). Tehtäväsi on laskea,
montako erilaista reittiä on solmusta 1 solmuun n.

Tee luokka Reitit, jossa on seuraavat metodit:

Reitit(int n): konstruktorissa annetaan solmujen määrä
void lisaaKaari(int a, int b): lisää kaaren solmusta a solmuun b
long laske(): ilmoittaa reittien määrän


*/


import java.util.*;
 
public class Reitit {
 
    private int n;
    private ArrayList<Integer> order;
    private ArrayList<Integer>[] vertices;
    private ArrayList<Integer>[] parents;
    private boolean[] kayty;
    private long[] polut;
 
    public Reitit(int n) {
        this.n = n;
        this.order = new ArrayList<>();
        this.vertices = new ArrayList[this.n+1];
        this.parents = new ArrayList[this.n+1];        
        for (int i = 1; i <= n; i++) {
            vertices[i] = new ArrayList<>();
            parents[i] = new ArrayList<>();
        }
        this.kayty = new boolean[n+1];
        for (int i = 0; i < n + 1; i++) {
            this.kayty[i] = false;
        }
        this.polut = new long[n+1];
        this.polut[1] = 1;
    }
 
    public void lisaaKaari(int a, int b) {
        this.vertices[a].add(b);
        parents[b].add(a);
    }
 
    public long laske() {
        
        topoSort(1);
        
        Collections.reverse(order);
        
        for(int i = 0; i < n; i++) {
            if (i == order.size()) break;
            for(int child : parents[order.get(i)]) {
                polut[order.get(i)] += polut[child];
            }
        }   
        return polut[n];
    }
 
    public void topoSort(int solmu) {
 
        if (this.vertices[solmu].isEmpty()) {
            this.order.add(solmu);
            this.kayty[solmu] = true;
            return;
        }
        for (int node : this.vertices[solmu]) {
            if (this.kayty[node]) {
                continue;
            }
            topoSort(node);
        }
        this.kayty[solmu] = true;
        this.order.add(solmu);
        
        
    }
}
