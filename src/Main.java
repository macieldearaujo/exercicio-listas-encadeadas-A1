// Classe do elemento do nó
class ElementoDoNó {
    int elemento;
    ElementoDoNó proximo;
    ElementoDoNó anterior;

    ElementoDoNó(int elemento) {
        this.elemento = elemento;
    }
}

// Classe da lista
class Lista {
    ElementoDoNó inicio;
    ElementoDoNó fim;

    // Insere no final
    void inserir(int valor) {
        ElementoDoNó novo = new ElementoDoNó(valor);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    // Imprime a lista
    void imprimir() {
        ElementoDoNó atual = inicio;
        while (atual != null) {
            System.out.print(atual.elemento + ", ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    // Concatena o reverso da lista B depois do valor Z
    void concatenarReversoDepoisDe(int z, Lista b) {
        ElementoDoNó atual = inicio;
        while (atual != null && atual.elemento != z) {
            atual = atual.proximo;
        }
        if (atual == null) return; // Z não encontrado

        ElementoDoNó bAtual = b.fim;
        while (bAtual != null) {
            ElementoDoNó novo = new ElementoDoNó(bAtual.elemento);
            novo.proximo = atual.proximo;
            if (atual.proximo != null) atual.proximo.anterior = novo;
            atual.proximo = novo;
            novo.anterior = atual;
            atual = novo;
            bAtual = bAtual.anterior;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Lista a = new Lista();
        a.inserir(7);
        a.inserir(6);
        a.inserir(4);
        a.inserir(3);

        Lista b = new Lista();
        b.inserir(132);
        b.inserir(53);
        b.inserir(21);

        System.out.print("A antes: ");
        a.imprimir();

        System.out.print("B: ");
        b.imprimir();

        //Nesse caso, a lista final será o elemento Z será 4,
        //logo, vamos concatenar a lista A até o elemento Z com a lista B ao contrário
        a.concatenarReversoDepoisDe(4, b);

        System.out.print("A depois: ");
        a.imprimir();
    }
}