public class FilaDinamica {
    private NoFila inicio;
    private NoFila fim;

    public boolean vazia() {
        return inicio == null;
    }

    public boolean cheia() {
        return false;
    }

    public void inserir(int valor) {
        NoFila novo = new NoFila(valor);
        if (fim == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
    }

    public int remover() {
        if (vazia()) {
            return -1;
        }
        int valor = inicio.valor;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        return valor;
    }

    public int buscar(int valor) {
        NoFila atual = inicio;
        while (atual != null) {
            if (atual.valor == valor) {
                return atual.valor;
            }
            atual = atual.proximo;
        }
        return -1;
    }

    public void imprimir() {
        NoFila atual = inicio;
        System.out.print("Inicio -> ");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println("<- Fim");
    }

    public void liberar() {
        inicio = null;
        fim = null;
    }
}