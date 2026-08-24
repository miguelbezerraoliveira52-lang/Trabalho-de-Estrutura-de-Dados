public class ListaEstatica {

    private int[] elementos;
    private int tamanho;

    public ListaEstatica(int capacidade) {
        elementos = new int[capacidade];
        tamanho = 0;
    }
    public boolean vazia() {
        return tamanho == 0;
    }

    public boolean cheia() {
        return tamanho == elementos.length;
    }

    // Inserção no final da lista
    public boolean inserir(int valor) {
        if (cheia()) {
            return false;
        }
        elementos[tamanho] = valor;
        tamanho++;
        return true;
    }

    // Insere mantendo a lista em ordem crescente
    public boolean inserirOrdenado(int valor) {
        if (cheia()) {
            return false;
        }
        int i = tamanho - 1;
        while (i >= 0 && elementos[i] > valor) {
            elementos[i + 1] = elementos[i];
            i--;
        }
        elementos[i + 1] = valor;
        tamanho++;
        return true;
    }

    public boolean remover(int valor) {
        int posicao = buscar(valor);
        if (posicao == -1) {
            return false;
        }

        //preenche o espaço removido
        for (int i = posicao; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        tamanho--;
        return true;
    }

    public int buscar(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == valor) {
                return i;
            }
        }

        return -1;
    }
    public void imprimir() {
        System.out.print("[ ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println("]");
    }
    // Liberação do vetor
    public void liberar() {
        elementos = null;
        tamanho = 0;
    }
}