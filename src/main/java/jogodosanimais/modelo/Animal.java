package jogodosanimais.modelo;

import jogodosanimais.enums.TipoAnimalEnum;

public abstract class Animal {
	private String nome;
	private String acao;
	protected TipoAnimalEnum tipoAnimalEnum;

	public Animal() {
		inicializarTipoAnimal();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public boolean possuiAcao(String acao) {
		return this.acao.equals(acao);
	}

	public boolean possuiNome(String nome) {
		return this.nome.equals(nome);
	}

	public TipoAnimalEnum getTipoAnimalEnum() {
		return tipoAnimalEnum;
	}
	
	protected abstract void inicializarTipoAnimal();
}
