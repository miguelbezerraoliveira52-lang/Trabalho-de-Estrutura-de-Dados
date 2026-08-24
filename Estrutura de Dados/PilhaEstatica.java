public class PilhaEstatica {
    private int[] elementos;
    private int topo;
    public PilhaEstatica(int capacidade) {
        elementos = new int[capacidade];
        topo = -1;
    }

    public boolean vazia() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == elementos.length - 1;
    }
    // PUSH

    public boolean inserir(int valor) {
        if (cheia()) {
            return false;
        }
        topo++;
        elementos[topo] = valor;
        return true;
    }

    // POP
    public int remover() {
        if (vazia()) {
            return -1;
        }
        int valor = elementos[topo];
        topo--;
        return valor;
    }

    public int buscar(int valor) {
        for (int i = topo; i >= 0; i--) {
            if (elementos[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public void imprimir() {
        System.out.print("Topo -> ");
        for (int i = topo; i >= 0; i--) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }

    public void liberar() {
        elementos = null;
        topo = -1;
    }
}