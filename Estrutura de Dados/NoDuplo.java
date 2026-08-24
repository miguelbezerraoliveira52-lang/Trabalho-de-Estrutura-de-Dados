public class NoDuplo {
    int valor;
    NoDuplo anterior;
    NoDuplo proximo;

    public NoDuplo(int valor) {
        this.valor = valor;
        anterior = null;
        proximo = null;
    }
}