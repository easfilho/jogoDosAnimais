package jogodosanimais.construtor;

import jogodosanimais.modelo.Animal;

public abstract class ConstrutorAnimal {
	protected Animal animal;
	
	public ConstrutorAnimal comNome(String nome) {
		animal.setNome(nome);
		return this;
	}
	
	public ConstrutorAnimal queFazAcao(String acao) {
		animal.setAcao(acao);
		return this;
	}
	
	public ConstrutorAnimal comOrdem(Integer ordem) {
		animal.setOrdem(ordem);
		return this;
	}
	
	public Animal criar() {
		return this.animal;
	}
}
