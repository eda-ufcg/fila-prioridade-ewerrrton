public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

        private Pair[] fila;
        private int head;
        private int tail;

        public InsereOrdenadoFilaPrioridade(int capacidade) {
                this.fila = new Pair[capacidade];
                this.tail = -1;
                this.head = -1;
        }

        // criar um Pair e inserir de forma ordenada decrescente no array.
        public void add(String elemento, int prioridade) {
        Pair par = new Pair(elemento, prioridade);

        if((this.tail+1) % fila.length == this.head) {
            removeNext();
        }

        if(this.head == -1) {
            this.head = 0;
            this.tail = 0;

            this.fila[head] = par;
            return;
        }

        int i = this.tail;
        while(i >= this.head && par.getPrioridade() > this.fila[i].getPrioridade()) {
            shiftEsquerda(i);
            i--;

        }

        this.fila[i+1] = par;
        this.tail = (this.tail+1) % fila.length;
    }

        // remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
        // para ser uma fila circular. assim a remoção fica O(1)
        public String removeNext() {

        Pair removido = this.fila[this.head];
        if(this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
            return removido.getElemento();
        }

        this.head = (this.head+1) % this.fila.length;
        return removido.getElemento();
        }

    private void shiftEsquerda(int i) {
        this.fila[(i+1)%fila.length] = this.fila[i];
    }

}
