public class ListaDupla {
    private NoDuplo inicio;
    private NoDuplo fim;
    private int tamanho;

    public ListaDupla() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public boolean vazia() {
        return inicio == null;
    }

    public boolean cheia() {
        return false;
    }

    // Inserção no final
    public void inserir(int valor) {
        NoDuplo novo = new NoDuplo(valor);
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
        tamanho++;
    }

    // Inserção ordenada
    public void inserirOrdenado(int valor) {
        NoDuplo novo = new NoDuplo(valor);
        if (inicio == null) {
            inicio = novo;
            fim = novo;
            tamanho++;
            return;
        }
        if (valor <= inicio.valor) {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
            tamanho++;
            return;
        }
        if (valor >= fim.valor) {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
            tamanho++;
            return;
        }
        NoDuplo atual = inicio;
        while (atual.valor < valor) {
            atual = atual.proximo;
        }
        novo.anterior = atual.anterior;
        novo.proximo = atual;
        atual.anterior.proximo = novo;
        atual.anterior = novo;
        tamanho++;
    }

    public boolean remover(int valor) {
        NoDuplo atual = buscar(valor);
        if (atual == null) {
            return false;
        }
        if (atual.anterior != null) {
            atual.anterior.proximo = atual.proximo;
        } else {
            inicio = atual.proximo;
        }
        if (atual.proximo != null) {
            atual.proximo.anterior = atual.anterior;
        } else {
            fim = atual.anterior;
        }
        tamanho--;
        return true;
    }

    public NoDuplo buscar(int valor) {
        NoDuplo atual = inicio;
        while (atual != null) {
            if (atual.valor == valor) {
                return atual;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public void imprimir() {
        NoDuplo atual = inicio;
        System.out.print("[ ");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println("]");
    }
    // Percorre a lista do fim para o início
    public void imprimirReverso() {
        NoDuplo atual = fim;
        System.out.print("[ ");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.anterior;
        }

        System.out.println("]");
    }
    public void liberar() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }
}