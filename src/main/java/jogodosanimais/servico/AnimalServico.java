package jogodosanimais.servico;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import jogodosanimais.enums.TipoAnimalEnum;
import jogodosanimais.fabrica.FabricaAnimalAquatico;
import jogodosanimais.fabrica.FabricaAnimalTerrestre;
import jogodosanimais.modelo.Animal;

public class AnimalServico {
	public List<Animal> criarListaInicial() {
		List<Animal> listaAnimais = new LinkedList<>();
		listaAnimais.add(FabricaAnimalAquatico.criarAnimalAquaticoInicial());
		listaAnimais.add(FabricaAnimalTerrestre.criarAnimalTerrestreInicial());
		return listaAnimais;
	}

	public Animal tentarAdivinharAnimal(List<Animal> listaAnimais, TipoAnimalEnum tipoAnimalEnum, String acao) {
		List<Animal> listaAnimaisParaTentarAcertar = listaAnimais.stream().filter(x -> x.getTipoAnimalEnum().equals(tipoAnimalEnum))
				.sorted((f1, f2) -> Integer.compare(f2.getOrdem(), f1.getOrdem()))
				.collect(Collectors.toList());
		return consultarAnimalPelaAcao(acao, listaAnimaisParaTentarAcertar);
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

	public List<String> listarAcoesAnimais(List<Animal> listaAnimais, TipoAnimalEnum tipoAnimalEnum) {
		return listaAnimais.stream().filter(x -> x.getTipoAnimalEnum().equals(tipoAnimalEnum) && !x.possuiAcao(""))
				.sorted((f1, f2) -> Integer.compare(f1.getOrdem(), f2.getOrdem()))
				.map(Animal::getAcao).collect(Collectors.toList());
	}

	public void adicionarAnimal(String nome, String acao, TipoAnimalEnum tipoAnimalEnum, List<Animal> listaAnimais) {
		if (tipoAnimalEnum.tipoAnimalAquatico()) {
			listaAnimais.add(FabricaAnimalAquatico.criar(nome, acao, listaAnimais.size() + 1));
		} else {
			listaAnimais.add(FabricaAnimalTerrestre.criar(nome, acao, listaAnimais.size() + 1));
		}
	}
}
