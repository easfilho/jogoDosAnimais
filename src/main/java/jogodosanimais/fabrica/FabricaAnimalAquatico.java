package jogodosanimais.fabrica;

import jogodosanimais.construtor.ConstrutorAnimalAquatico;
import jogodosanimais.model.AnimalAquatico;

public class FabricaAnimalAquatico {
	private FabricaAnimalAquatico() {

	}

	public static AnimalAquatico criarAnimalAquaticoInicial() {
		return (AnimalAquatico) new ConstrutorAnimalAquatico()
				.comNome("Tubarão")
				.queFazAcao("")
				.criar();
	}

	public static AnimalAquatico criar(String nome, String acao) {
		return (AnimalAquatico) new ConstrutorAnimalAquatico()
				.comNome(nome)
				.queFazAcao(acao)
				.criar();
	}
}
