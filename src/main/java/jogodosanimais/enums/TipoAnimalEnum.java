package jogodosanimais.enums;

public enum TipoAnimalEnum {
	AQUATICO, TERRESTRE;
	
	public boolean tipoAnimalAquatico() {
		return this.equals(AQUATICO);
	}
}
