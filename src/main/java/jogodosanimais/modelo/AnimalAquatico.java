package jogodosanimais.modelo;

import jogodosanimais.enums.TipoAnimalEnum;

public class AnimalAquatico extends Animal {

	@Override
	protected void inicializarTipoAnimal() {
		super.tipoAnimalEnum = TipoAnimalEnum.AQUATICO;
	}
}
