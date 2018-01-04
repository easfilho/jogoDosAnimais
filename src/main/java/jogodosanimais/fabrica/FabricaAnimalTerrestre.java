package jogodosanimais.fabrica;

import jogodosanimais.construtor.ConstrutorAnimalTerrestre;
import jogodosanimais.modelo.AnimalTerrestre;

public class FabricaAnimalTerrestre {
	private FabricaAnimalTerrestre() {
		
	}
	
	public static AnimalTerrestre criarAnimalTerrestreInicial() {
		return (AnimalTerrestre) new ConstrutorAnimalTerrestre()
				.comNome("Macaco")
				.queFazAcao("")
				.comOrdem(2)
				.criar();
	}
	
	public static AnimalTerrestre criar(String nome, String acao, Integer ordem) {
		return (AnimalTerrestre) new ConstrutorAnimalTerrestre()
				.comNome(nome)
				.queFazAcao(acao)
				.comOrdem(ordem)
				.criar();
	}
}
