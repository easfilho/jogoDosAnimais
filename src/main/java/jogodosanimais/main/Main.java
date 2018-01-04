package jogodosanimais.main;

import java.util.List;

import javax.swing.JOptionPane;

import jogodosanimais.enums.TipoAnimalEnum;
import jogodosanimais.modelo.Animal;
import jogodosanimais.servico.AnimalServico;

public class Main {

	public static void main(String[] args) {
		boolean acertou = false;
		AnimalServico animalServico = new AnimalServico();
		List<Animal> pilhaAnimais = animalServico.criarListaInicial();
		TipoAnimalEnum tipoAnimalSelecionado;
		String acao = null;
		Animal animalTentouAdivinhar;

		while (!acertou) {
			mostrarDialogoInicial();
			tipoAnimalSelecionado = obterTipoAnimal();
			acao = tentarDescobrirAcaoAnimal(animalServico, pilhaAnimais, tipoAnimalSelecionado, acao);
			animalTentouAdivinhar = animalServico.tentarAdivinharAnimal(pilhaAnimais, tipoAnimalSelecionado, acao);
			acertou = tentarAdivinharAnimal(animalTentouAdivinhar);
			if (!acertou) {
				perguntarQualAnimalPensouESalvar(animalServico, pilhaAnimais, tipoAnimalSelecionado,
						animalTentouAdivinhar);
			}
			acao = null;
		}
	}

	private static void perguntarQualAnimalPensouESalvar(AnimalServico animalServico, List<Animal> pilhaAnimais,
			TipoAnimalEnum tipoAnimalSelecionado, Animal animalTentouAdivinhar) {
		String nomeAnimal = JOptionPane.showInputDialog("Qual animal você pensou?");
		String acaoAnimal = JOptionPane.showInputDialog(
				"Um(a) " + nomeAnimal + "_______ mas um (a)" + animalTentouAdivinhar.getNome() + " não.");
		animalServico.adicionarAnimal(nomeAnimal, acaoAnimal, tipoAnimalSelecionado, pilhaAnimais);
	}

	private static String tentarDescobrirAcaoAnimal(AnimalServico animalServico, List<Animal> pilhaAnimais,
			TipoAnimalEnum tipoAnimalSelecionado, String acao) {
		List<String> listaAnimaisDoTipo = animalServico.listarAcoesAnimais(pilhaAnimais, tipoAnimalSelecionado);
		for (String possivelAcao : listaAnimaisDoTipo) {
			int resultadoDialogo = JOptionPane.showConfirmDialog(null, "O animal que você pensou " + possivelAcao + "?",
					"Confirm", JOptionPane.YES_NO_OPTION);
			if (resultadoDialogo == JOptionPane.YES_OPTION) {
				acao = possivelAcao;
				break;
			} else {
				acao = null;
			}
		}
		return acao;
	}

	private static boolean tentarAdivinharAnimal(Animal animalTentouAdivinhar) {
		int resultadoDialogo = JOptionPane.showConfirmDialog(null,
				"O animal que você pensou é um(a) " + animalTentouAdivinhar.getNome() + "?", "Confirm",
				JOptionPane.YES_NO_OPTION);
		if (resultadoDialogo == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Acertei de novo");
			return true;
		}
		return false;
	}

	private static TipoAnimalEnum obterTipoAnimal() {
		TipoAnimalEnum tipoAnimalSelecionado;
		int resultadoDialogo = JOptionPane.showConfirmDialog(null, "O animal que você pensou vive na água? ", "Confirm",
				JOptionPane.YES_NO_OPTION);
		if (resultadoDialogo == JOptionPane.YES_OPTION) {
			tipoAnimalSelecionado = TipoAnimalEnum.AQUATICO;
		} else {
			tipoAnimalSelecionado = TipoAnimalEnum.TERRESTRE;
		}
		return tipoAnimalSelecionado;
	}

	private static void mostrarDialogoInicial() {
		int resultado = JOptionPane.showConfirmDialog(null, "Pense em um animal", "Pense em um animal",
				JOptionPane.OK_CANCEL_OPTION);
		if (resultado == JOptionPane.CANCEL_OPTION) {
			System.exit(0);
		}
	}

}
