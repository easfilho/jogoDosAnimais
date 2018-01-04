package jogodosanimais.modelo;

import jogodosanimais.enums.TipoAnimalEnum;

public class AnimalTerrestre extends Animal {

	@Override
	protected void inicializarTipoAnimal() {
		super.tipoAnimalEnum = TipoAnimalEnum.TERRESTRE;
	}
}
