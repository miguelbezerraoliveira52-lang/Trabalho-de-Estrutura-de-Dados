public class ListaSimples {
    private NoSimples inicio;
    private int tamanho;

    public ListaSimples() {
        inicio = null;
        tamanho = 0;
    }

    public boolean vazia() {
        return inicio == null;
    }

    // Lista dinâmica não possui tamanho máximo fixo
    public boolean cheia() {
        return false;
    }

    // Inserção no final
    public void inserir(int valor) {
        NoSimples novo = new NoSimples(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            NoSimples atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
        tamanho++;
    }

    // Inserção mantendo ordem crescente
    public void inserirOrdenado(int valor) {
        NoSimples novo = new NoSimples(valor);
        if (inicio == null || valor < inicio.valor) {
            novo.proximo = inicio;
            inicio = novo;
            tamanho++;
            return;
        }
        NoSimples atual = inicio;
        while (atual.proximo != null &&
                atual.proximo.valor < valor) {
            atual = atual.proximo;
        }
        novo.proximo = atual.proximo;
        atual.proximo = novo;
        tamanho++;
    }

    public boolean remover(int valor) {
        if (inicio == null) {
            return false;
        }
        if (inicio.valor == valor) {
            inicio = inicio.proximo;
            tamanho--;
            return true;
        }
        NoSimples atual = inicio;
        while (atual.proximo != null &&
                atual.proximo.valor != valor) {

            atual = atual.proximo;
        }
        if (atual.proximo == null) {
            return false;
        }
        atual.proximo = atual.proximo.proximo;
        tamanho--;
        return true;
    }

    public NoSimples buscar(int valor) {
        NoSimples atual = inicio;
        while (atual != null) {
            if (atual.valor == valor) {
                return atual;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public void imprimir() {
        NoSimples atual = inicio;
        System.out.print("[ ");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println("]");
    }

    public void liberar() {
        inicio = null;
        tamanho = 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public NoSimples getInicio() {
        return inicio;
    }
}