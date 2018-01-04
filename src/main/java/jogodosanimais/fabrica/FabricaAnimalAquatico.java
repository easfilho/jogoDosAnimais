package jogodosanimais.fabrica;

import jogodosanimais.construtor.ConstrutorAnimalAquatico;
import jogodosanimais.modelo.AnimalAquatico;

public class FabricaAnimalAquatico {
	private FabricaAnimalAquatico() {

	}

	public static AnimalAquatico criarAnimalAquaticoInicial() {
		return (AnimalAquatico) new ConstrutorAnimalAquatico()
				.comNome("Tubarão")
				.queFazAcao("")
				.comOrdem(1)
				.criar();
	}

	public static AnimalAquatico criar(String nome, String acao, Integer ordem) {
		return (AnimalAquatico) new ConstrutorAnimalAquatico()
				.comNome(nome)
				.queFazAcao(acao)
				.comOrdem(ordem)
				.criar();
	}
}
