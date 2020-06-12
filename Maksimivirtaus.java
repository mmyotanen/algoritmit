import java.util.*;

public class Maksimivirtaus {     
    public static class Edge {
    public Edge residual;
    public int to, capacity;
    public final int originalCapacity;
    public Edge(int to, int capacity) {
      this.to = to; 
      this.capacity = capacity;
      this.originalCapacity = capacity;
    }
  }
    private int n, source, sink;

  // Internal
  private int visitedToken = 1;
  private int[] visited;
  private boolean solved;

  // Outputs
  private int maxFlow;
  private boolean[] minCut;
  private List<List<Edge>> graph;
    public Maksimivirtaus(int n) {
        this.n = n+1;
    initializeGraph();
    this.source = 1;
    this.sink = n;
    }
    

    public void lisaaKaari(int a, int b, int p) {
        Edge e1 = new Edge(b, p);
    Edge e2 = new Edge(a, 0);
    e1.residual = e2;
    e2.residual = e1;
    graph.get(a).add(e1);
    graph.get(b).add(e2);
    }
    
    
    public int laske() {
        
        return getMaxFlow();
    }
    public List<List<Edge>> getGraph() {
    solve();
    return graph;
  }

  // Returns the maximum flow from the source to the sink.
  public int getMaxFlow() {
    solve();
    return maxFlow;
  }

  // Returns the min-cut of this flow network in which the nodes on the "left side"
  // of the cut with the source are marked as true and those on the "right side" 
  // of the cut with the sink are marked as false.
  public boolean[] getMinCut() {
    solve();
    return minCut;
  }

  // Performs the Ford-Fulkerson method applying a depth first search as
  // a means of finding an augmenting path. The input consists of a directed graph
  // with specified capacities on the edges.
  public void solve() {
    if (solved) return;

    maxFlow = 0;
    visited = new int[n];
    minCut = new boolean[n];

    // Find max flow.
    int flow;
    do {
      // Try to find an augmenting path from source to sink
      flow = dfs(source, Integer.MAX_VALUE);
      visitedToken++;
      maxFlow += flow;
    } while(flow != 0);

    // Find min cut.
    for(int i = 0; i < n; i++)
      if (visited[i] == visitedToken-1)
        minCut[i] = true;

    solved = true;
  }

  private int dfs(int node, int flow) {
    // At sink node, return augmented path flow.
    if (node == sink) return flow;

    List<Edge> edges = graph.get(node);
    visited[node] = visitedToken;

    for (Edge edge : edges) {
      if (visited[edge.to] != visitedToken && edge.capacity > 0) {

        // Update flow to be bottleneck 
        if (edge.capacity < flow) flow = edge.capacity;
        int dfsFlow = dfs(edge.to, flow);

        // Update edge capacities
        if (dfsFlow > 0) {
          Edge res = edge.residual;
          edge.capacity -= dfsFlow;
          res.capacity  += dfsFlow;
          return dfsFlow;
        }

      }
    }
    return 0;
  }

  // Construct an empty graph with n nodes including the source and sink nodes.
  private void initializeGraph() {
    graph = new ArrayList<>(n);
    for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
  }
    
}
