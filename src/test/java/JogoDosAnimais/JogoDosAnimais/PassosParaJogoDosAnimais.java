package JogoDosAnimais.JogoDosAnimais;

import java.util.List;
import java.util.Stack;

import org.junit.Assert;

import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import jogodosanimais.enums.TipoAnimalEnum;
import jogodosanimais.model.Animal;
import jogodosanimais.service.AnimalService;

public class PassosParaJogoDosAnimais {

	private TipoAnimalEnum tipoAnimalSelecionado;
	private AnimalService animalService;
	private Animal animalTentouAdivinhar;
	private String acaoSelecionda;
	private Stack<Animal> pilhaAnimais;
	private List<String> listaAcoesAdicionadas;

	@Before
	public void prepararCenarios() {
		animalService = new AnimalService();
	}

	@Dado("^que a lista de opções tem somente os valores iniciais$")
	public void que_a_lista_de_opções_tem_somente_os_valores_iniciais() throws Throwable {
		pilhaAnimais = animalService.criarPilhaInicial();
	}

	@Dado("^que seleciono que animal vive água$")
	public void que_seleciono_que_animal_vive_água() throws Throwable {
		tipoAnimalSelecionado = TipoAnimalEnum.AQUATICO;
	}

	@Dado("^que informo que o animal que estava pensando tem nome \"([^\"]*)\" que faz \"([^\"]*)\" do tipo \"([^\"]*)\"$")
	public void que_informo_que_o_animal_que_estava_pensando_tem_nome_que_faz_do_tipo(String nome, String acao,
			TipoAnimalEnum tipoAnimalEnum) throws Throwable {
		animalService.adicionarAnimal(nome, acao, tipoAnimalEnum, pilhaAnimais);
	}
	
	@Dado("^que informo a ação \"([^\"]*)\"$")
	public void que_informo_a_ação(String acao) throws Throwable {
	    acaoSelecionda = acao;
	}
	
	@Dado("^que seleciono que animal não vive água$")
	public void que_seleciono_que_animal_não_vive_água() throws Throwable {
	    tipoAnimalSelecionado = TipoAnimalEnum.TERRESTRE;
	}

	@Quando("^verificar qual animal estou pensando$")
	public void verificar_qual_animal_estou_pensando() throws Throwable {
		animalTentouAdivinhar = animalService.tentarAdivinharAnimal(pilhaAnimais, tipoAnimalSelecionado, acaoSelecionda);
	}

	@Quando("^mostrar as opções de ações$")
	public void mostrar_as_opções_de_ações() throws Throwable {
		listaAcoesAdicionadas = animalService.listarAcoesAnimais(pilhaAnimais, tipoAnimalSelecionado);
	}

	@Então("^deve mostra a opção \"([^\"]*)\"$")
	public void deve_mostra_a_opção(String nomeAnimal) throws Throwable {
		Assert.assertTrue(animalTentouAdivinhar.possuiNome(nomeAnimal));
	}

	@Então("^deve mostra a lista de ações$")
	public void deve_mostra_a_lista_de_ações(List<String> listaAcoes) throws Throwable {
		for (int i = 0; i < listaAcoes.size(); i++) {
			Assert.assertEquals(listaAcoes.get(i), listaAcoesAdicionadas.get(i));
		}
	}

}
