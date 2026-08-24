public class FilaEstatica {
    private int[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;

    public FilaEstatica(int capacidade) {
        elementos = new int[capacidade];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public boolean vazia() {
        return tamanho == 0;
    }

    public boolean cheia() {
        return tamanho == elementos.length;
    }

    public boolean inserir(int valor) {
        if (cheia()) {
            return false;
        }
        elementos[fim] = valor;
        fim = (fim + 1) % elementos.length;
        tamanho++;
        return true;
    }

    public int remover() {
        if (vazia()) {
            return -1;
        }
        int valor = elementos[inicio];
        inicio = (inicio + 1) % elementos.length;
        tamanho--;
        return valor;
    }

    public int buscar(int valor) {
        for (int i = 0; i < tamanho; i++) {
            int posicao =
                    (inicio + i) % elementos.length;
            if (elementos[posicao] == valor) {
                return posicao;
            }
        }
        return -1;
    }

    public void imprimir() {
        System.out.print("Inicio -> ");
        for (int i = 0; i < tamanho; i++) {
            int posicao =
                    (inicio + i) % elementos.length;
            System.out.print(
                    elementos[posicao] + " "
            );
        }
        System.out.println("<- Fim");
    }
    public void liberar() {
        elementos = null;
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }
}