public class PilhaDinamica {
    private NoPilha topo;
    public boolean vazia() {
        return topo == null;
    }

    public boolean cheia() {
        return false;
    }

    public void inserir(int valor) {
        NoPilha novo = new NoPilha(valor);
        novo.proximo = topo;
        topo = novo;
    }

    public int remover() {
        if (vazia()) {
            return -1;
        }
        int valor = topo.valor;
        topo = topo.proximo;
        return valor;
    }

    public int buscar(int valor) {
        NoPilha atual = topo;
        while (atual != null) {
            if (atual.valor == valor) {
                return atual.valor;
            }
            atual = atual.proximo;
        }
        return -1;
    }

    public void imprimir() {
        NoPilha atual = topo;
        System.out.print("Topo -> ");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public void liberar() {
        topo = null;
    }
}