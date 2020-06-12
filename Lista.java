


public class Lista {
    private int[] lista = new int[20000000];
    private int alku = 0;
    private int loppu = 1;
    
    void lisaaAlkuun(int x) {
        int apu = lista.length / 2;
        lista[apu - alku] = x;
        alku++;
        
    }

    void lisaaLoppuun(int x) {
        int apu = lista.length/2;
        lista[apu+loppu] = x;
        loppu++;
        
    }

    int haeAlkio(int k) {
        int apu = lista.length/2 - alku;
        return lista[apu + k + 1];
    }    
}
