//Classe LinkedList<T>: encarregada de manipular a estrutura de dados
//lista ligada genérica.
//
//Autor1: Ivan Carlos Alcântara de Oliveira.
//Data da Criação: 10/10/2024. 15h.
public class LinkedList<T> {
    private NodeLL<T> head; // Ponteiro cabeça de lista
    private int size; // Quantidade de elementos da lista ligada

    // LinkedList(): construtor da Lista encadeada
    public LinkedList() {
        head = null;
        size = 0;
    }

    // isEmpty(): verifica se a lista está vazia, retornando "true" se vazia
    // "false" se não vazia.
    public boolean isEmpty() {
        return getHead() == null;
    }

    // isFull(): verifica se a lista está cheia, retornando "true" se cheia
    // "false" se não cheia.    
    public boolean isFull() {
        // Em Java, a verificação de memória cheia é conceitual em instanciacão
        return false; 
    }

    // getSize(): retorna o tamanho da lista (total de elementos armazenados).
    public int getSize() {
        return size;
    }

    // getHead(): retorna o "NodeLL" cabeça de lista    
    public NodeLL<T> getHead() {
        return head;
    }

    // get(int pos): retorna o "NodeLL" que se encontra na posição "pos" da lista.  
    //   O head está na posição 1. Lista vazia retorna null. Se pos > size retorna null.
    public NodeLL<T> get(int pos) {
        if (isEmpty()) return null;
        if (pos <= 0 || pos > size) return null;
        int cont = 1;
        NodeLL<T> pAnda = head;
        while (cont != pos){
            pAnda = pAnda.getProx();
            cont++;
        }
        return pAnda;
    }

    // insert(T id, int pos): insere o elemento "id" na posição "pos" passada como parâmetro
    // caso seja uma posição maior que o tamanho da lista, insere no final
    // se posição de inserção for inválida  (<= 0) retorna false
    public boolean insert(T id, int pos) {
        NodeLL<T> aux; // Ponteiro auxiliar para o novo nó a ser inserido
        NodeLL<T> pAnda; // Ponteiro que anda na lista ligada   
        NodeLL<T> pAnt = null;  // Ponteiro anterior ao que anda
        if (pos <= 0) return false; // Se posição inválida, não insere e retorna
        
        aux = new NodeLL<T>(id, null);
        if (isEmpty()){ // Insere no começo da lista
            head = aux;
        } else if (pos >= size+1) {
             insertTail(id);
             return true; // insertTail já incrementa o size
        } else {// a posição a inserir é no meio da lista
            int cont = 1;
            pAnda = head;  
            while (pAnda.getProx() != null && cont != pos){
               pAnt = pAnda;
               pAnda = pAnda.getProx();
               cont++;
            }
            aux.setProx(pAnda);
            if (cont == 1) { // insere no cabeça de lista
                head = aux;
            } else { // insere no meio
                pAnt.setProx(aux);
            }
        }
        size++;
        return true; 
    };

    // addFirst(T id): insere o "id" passado como parâmetro no começo da 
    // lista (funcionalidade idêntica ao insertHead).   
    public boolean addFirst(T id){
        NodeLL<T> aux = new NodeLL<T>(id, null);
        if (isEmpty()){ 
            head = aux;
        } else { 
            aux.setProx(head);
            head = aux;
        }
        size++;
        return true;
    };

    // insertHead(T id): insere o "id" passado como parâmetro no começo da 
    // lista (funcionalidade idêntica ao addFirst). 
    public boolean insertHead(T id){
        return addFirst(id);
    };

    // insertTail(T id): insere o "id" passado como parâmetro no final da 
    // lista (funcionalidade idêntica ao addLast).      
    public boolean insertTail(T id){
        NodeLL<T> aux = new NodeLL<T>(id, null);
        if (isEmpty()){ 
            head = aux;
        } else { 
            NodeLL<T> pAnda = head;
            while (pAnda.getProx() != null)
               pAnda = pAnda.getProx();
            pAnda.setProx(aux);
        }
        size++;
        return true;
    };

    // addLast(T id): adiciona o "id" passado como parâmetro no final da 
    // lista (funcionalidade idêntica ao insertTail)
    public boolean addLast(T id){
        return insertTail(id);
    };

    // search(T id): procura o elemento "id" dentro da lista
    // se "id" não existir ou lista vazia retorna null
    // caso contrário, retorna o "NodeLL"
    public NodeLL<T> search(T id){
        if (isEmpty()) return null;
        NodeLL<T> pAnda = head;
        while ((pAnda != null) && (!pAnda.getDado().equals(id)))
            pAnda = pAnda.getProx();
        return pAnda;
    }

    // remove(T id): remove a primeira ocorrência do "id" na lista
    // retorna "true" se remoção com sucesso
    // ou "false" se não foi possível remover
    public boolean remove(T id){
        NodeLL<T> pAnda; 
        NodeLL<T> pAnt = null; 
        if (isEmpty()) return false;
        
        pAnda = head;
        while ((pAnda != null) && (!pAnda.getDado().equals(id))){
            pAnt = pAnda;
            pAnda = pAnda.getProx();
        }
        if (pAnda == null) return false; 
        
        if (head == pAnda) {
            head = pAnda.getProx();
        } else {
            pAnt.setProx(pAnda.getProx());
        }
        size--;
        return true;
    }

    // pollFirst(): remove e retorna o primeiro elemento da lista
    public T pollFirst(){
        if (isEmpty()) return null;
        T dado = head.getDado();
        head = head.getProx();
        size--;
        return dado;
    }   

    // pollLast(): remove e retorna o último elemento da lista
    public T pollLast(){
        if (isEmpty()) return null;
        if (size == 1) return pollFirst();

        NodeLL<T> pAnda = head, pAnt = null;
        while (pAnda.getProx() != null){
            pAnt = pAnda;
            pAnda = pAnda.getProx();
        }
        T dado = pAnda.getDado();
        pAnt.setProx(null);
        size--;
        return dado;
    }   

    // print(): percorre a lista e imprime todo o seu conteúdo
    public void print(){
        NodeLL<T> pAnda = head;
        while (pAnda != null) {
            System.out.println(pAnda.getDado());
            pAnda = pAnda.getProx();
        }
    }

    // inverte(): Inverte o conteúdo da lista
    public void inverte() {
        LinkedList<T> lAux = new LinkedList<T>();
        NodeLL<T> pAnda = getHead();
        while (pAnda != null) { 
            lAux.insertHead(pAnda.getDado());
            pAnda = pAnda.getProx();
        }
        clear();
        head = lAux.getHead();
        size = lAux.getSize();
    }

    // concatena(LinkedList<T> lista): concatena a lista 
    // passada como parâmetro ao final da lista original
    public void concatena(LinkedList<T> lista) {
        NodeLL<T> pAnda = lista.getHead();
        while (pAnda != null) {
            insertTail(pAnda.getDado());
            pAnda = pAnda.getProx();
        }
    }

    // clear(): limpa a lista ligada original, deixando-a vazia
    public void clear(){
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n[Lista]\nL: [ ");
        NodeLL<T> pAnda = head;
        while (pAnda != null) {
          sb.append(pAnda.getDado() + " ");
          pAnda = pAnda.getProx();
        }
        sb.append("]\nQtde.: " + size + "\n");
        return sb.toString();
    }
}