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
		if (tipoAnimalEnum.tipoAnimalAquatico()) {
			return tentarAdivinharAnimalAquatico(pilhaAnimais, acao);
		}
		return tentarAdivinharAnimalTerrestre(pilhaAnimais, acao);
	}

	private Animal tentarAdivinharAnimalAquatico(Stack<Animal> pilhaAnimais, String acao) {
		List<Animal> listaAnimaisAquaticos = pilhaAnimais.stream().filter(x -> x.animalAquatico())
				.collect(Collectors.toList());
		return consultarAnimalPelaAcao(acao, listaAnimaisAquaticos);
	}
	
	private Animal tentarAdivinharAnimalTerrestre(Stack<Animal> pilhaAnimais, String acao) {
		List<Animal> listaAnimaisTerrestres = pilhaAnimais.stream().filter(x -> !x.animalAquatico())
				.collect(Collectors.toList());
		
		return consultarAnimalPelaAcao(acao, listaAnimaisTerrestres);
	}

	private Animal consultarAnimalPelaAcao(String acao, List<Animal> listaAnimaisTerrestres) {
		int i;
		for (i = 0; i < listaAnimaisTerrestres.size() - 1; i++) {
			if (listaAnimaisTerrestres.get(i).possuiAcao(acao)) {
				return listaAnimaisTerrestres.get(i);
			}
		}
		return listaAnimaisTerrestres.get(i);
	}

	public List<String> listarAcoesAnimais(Stack<Animal> pilhaAnimais, TipoAnimalEnum tipoAnimalEnum) {
		if (tipoAnimalEnum.tipoAnimalAquatico()) {
			return pilhaAnimais.stream().filter(x -> x.animalAquatico() && !x.possuiAcao("")).map(Animal::getAcao)
					.collect(Collectors.toList());
		}
		return pilhaAnimais.stream().filter(x -> !x.animalAquatico() && !x.possuiAcao("")).map(Animal::getAcao)
				.collect(Collectors.toList());
	}

	public void adicionarAnimal(String nome, String acao, TipoAnimalEnum tipoAnimalEnum, Stack<Animal> pilhaAnimais) {
		if (tipoAnimalEnum.tipoAnimalAquatico()) {
			pilhaAnimais.push(FabricaAnimalAquatico.criar(nome, acao));
		} else {
			pilhaAnimais.push(FabricaAnimalTerrestre.criar(nome, acao));
		}
	}
}
