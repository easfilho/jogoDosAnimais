package jogodosanimais.servico;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import jogodosanimais.enums.TipoAnimalEnum;
import jogodosanimais.fabrica.FabricaAnimalAquatico;
import jogodosanimais.fabrica.FabricaAnimalTerrestre;
import jogodosanimais.modelo.Animal;

public class AnimalServico {
	public Stack<Animal> criarPilhaInicial() {
		Stack<Animal> pilhaAnimais = new Stack<>();
		pilhaAnimais.push(FabricaAnimalAquatico.criarAnimalAquaticoInicial());
		pilhaAnimais.push(FabricaAnimalTerrestre.criarAnimalTerrestreInicial());
		return pilhaAnimais;
	}

	public Animal tentarAdivinharAnimal(Stack<Animal> pilhaAnimais, TipoAnimalEnum tipoAnimalEnum, String acao) {
		List<Animal> listaAnimais = pilhaAnimais.stream().filter(x -> x.getTipoAnimalEnum().equals(tipoAnimalEnum))
				.collect(Collectors.toList());
		return consultarAnimalPelaAcao(acao, listaAnimais);
	}

	private Animal consultarAnimalPelaAcao(String acao, List<Animal> listaAnimais) {
		int i;
		for (i = 0; i < listaAnimais.size() - 1; i++) {
			if (listaAnimais.get(i).possuiAcao(acao)) {
				return listaAnimais.get(i);
			}
		}
		return listaAnimais.get(i);
	}

	public List<String> listarAcoesAnimais(Stack<Animal> pilhaAnimais, TipoAnimalEnum tipoAnimalEnum) {
		return pilhaAnimais.stream().filter(x -> x.getTipoAnimalEnum().equals(tipoAnimalEnum) && !x.possuiAcao(""))
				.map(Animal::getAcao).collect(Collectors.toList());
	}

	public void adicionarAnimal(String nome, String acao, TipoAnimalEnum tipoAnimalEnum, Stack<Animal> pilhaAnimais) {
		if (tipoAnimalEnum.tipoAnimalAquatico()) {
			pilhaAnimais.push(FabricaAnimalAquatico.criar(nome, acao));
		} else {
			pilhaAnimais.push(FabricaAnimalTerrestre.criar(nome, acao));
		}
	}
}
