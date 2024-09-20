import java.util.ArrayList;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
        Pair newPair = new Pair(elemento, prioridade);
        this.fila.add(newPair);
    }

	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
		
        int indexMaior = 0;

        for(int i = 1; i < this.fila.size(); i++) {     
            if(fila.get(i).getPrioridade() > fila.get(indexMaior).getPrioridade())  {
                indexMaior = i;
            }
        }

        Pair removido = fila.get(indexMaior);
        this.fila.remove(indexMaior);

        return removido.getElemento();
    }

}
