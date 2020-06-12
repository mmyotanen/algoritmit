import java.util.*;

public class Kunnostus {     
    WeightedGraph graph = new WeightedGraph();
    int n;
    int laskuri;
    public Kunnostus(int n) {
        this.n = n;
    }
    
    public void lisaaTie(int a, int b, int x) {
        if (!(a == b)) {
            graph.addNode(a);
            graph.addNode(b);
            graph.addEdge(a, b, x);
            laskuri++;
        }
    }
    
    public int laske() {
        if (n == 2 && laskuri == 0) return -1;
        
        return graph.getMinimumSpanningTree();
        
    }

}
