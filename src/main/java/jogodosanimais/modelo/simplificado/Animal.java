package jogodosanimais.modelo.simplificado;

import jogodosanimais.enums.TipoAnimalEnum;

public class Animal {
	private String nome;
	private String acao;
	private Integer ordem;
	private TipoAnimalEnum tipoAnimalEnum;

	public Animal(String nome, String acao, Integer ordem, TipoAnimalEnum tipoAnimalEnum) {
		super();
		this.nome = nome;
		this.acao = acao;
		this.ordem = ordem;
		this.tipoAnimalEnum = tipoAnimalEnum;
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

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
}
