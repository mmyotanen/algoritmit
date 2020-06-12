/* Sinulle annetaan tiedot yliopiston kursseista ja niiden esitietovaatimuksista, ja tehtäväsi on etsiä järjestys, 
jossa voit suorittaa kaikki kurssit vaatimusten mukaisesti.

Tee luokka Kurssit, jossa on seuraavat metodit:

void lisaaKurssi(String s): lisää suoritettavaksi kurssin nimeltä s
void lisaaVaatimus(String a, String b): määrittää, että kurssi a tulee suorittaa ennen kurssia b
ArrayList<String> muodosta(): ilmoittaa tavan suorittaa kurssit vaatimusten mukaisesti (tai null jos tämä on mahdotonta)

*/


import java.util.*;

public class Kurssit {
    private class Node {
    private String label;

    public Node(String label) {
      this.label = label;
    }
    }
    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();
    private String root = "a";
    
    public Kurssit() {
        
    }
    
    public void lisaaKurssi(String s) {
        if (root.equals("a")) {
            root = s;
        }
        Node node = new Node(s);
        nodes.putIfAbsent(s, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }
 
    public void lisaaVaatimus(String a, String b) {
        Node fromNode = nodes.get(a);
    if (fromNode == null)
      throw new IllegalArgumentException();

    Node toNode = nodes.get(b);
    if (toNode == null)
      throw new IllegalArgumentException();

    adjacencyList.get(fromNode).add(toNode);
    }
    
    public ArrayList<String> muodosta() {
        if (hasCycle()) return null;
        traverseDepthFirstRec(root);
        ArrayList<String> tulostus = topologicalSort();
        return tulostus;
        
    }
    public void traverseDepthFirstRec(String root) {
    Node node = nodes.get(root);
    if (node == null)
      return;

    traverseDepthFirstRec(node, new HashSet<>());
  }

  private void traverseDepthFirstRec(Node root, Set<Node> visited) {
    //System.out.println(root);
    visited.add(root);

    for (Node node : adjacencyList.get(root))
      if (!visited.contains(node))
        traverseDepthFirstRec(node, visited);
  }
  public ArrayList<String> topologicalSort() {
    Stack<Node> stack = new Stack<>();
    Set<Node> visited = new HashSet<>();

    for (Node node : nodes.values())
      topologicalSort(node, visited, stack);

    ArrayList<String> sorted = new ArrayList<>();
    while (!stack.empty())
      sorted.add(stack.pop().label);

    return sorted;
  }

  private void topologicalSort(
      Node node, Set<Node> visited, Stack<Node> stack) {
    if (visited.contains(node))
      return;

    visited.add(node);

    for (Node neighbour : adjacencyList.get(node))
      topologicalSort(neighbour, visited, stack);

    stack.push(node);
  }
  public boolean hasCycle() {
    Set<Node> all = new HashSet<>();
    all.addAll(nodes.values());

    Set<Node> visiting = new HashSet<>();
    Set<Node> visited = new HashSet<>();

    while (!all.isEmpty()) {
      Node current = all.iterator().next();
      if (hasCycle(current, all, visiting, visited))
        return true;
    }

    return false;
  }

  private boolean hasCycle(Node node, Set<Node> all,
                 Set<Node> visiting, Set<Node> visited) {
    all.remove(node);
    visiting.add(node);

    for (Node neighbour : adjacencyList.get(node)) {
      if (visited.contains(neighbour))
        continue;

      if (visiting.contains(neighbour))
        return true;

      if (hasCycle(neighbour, all, visiting, visited))
        return true;
    }

    visiting.remove(node);
    visited.add(node);

    return false;
  }
    
    
 
}

