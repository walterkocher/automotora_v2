package model;

public enum Color {
	BLANCO("BLANCO"),
	AZUL("AZUL"),
	NEGRO("NEGRO"),
	GRIS("GRIS"),
	ROJO("ROJO"),
	AMARILLO("AMARILLO"),
	VERDE("VERDE"),
	BURDEO("BURDEO"),
	NARANJO("NARANJO");
	private String color;
	private Color(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}
}