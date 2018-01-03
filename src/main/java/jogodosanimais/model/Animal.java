package jogodosanimais.model;

public abstract class Animal {
	private String nome;
	private String acao;

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

	public boolean animalAquatico() {
		return this.getClass().equals(AnimalAquatico.class);
	}

	public boolean possuiAcao(String acao) {
		return this.acao.equals(acao);
	}

	public boolean possuiNome(String nome) {
		return this.nome.equals(nome);
	}
}
