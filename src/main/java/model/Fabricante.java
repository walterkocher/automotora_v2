package model;

public enum Fabricante {
	TOYOTA ("TOYOTA"),
	CHEVROLET ("CHEVROLET"),
	SUBARU("SUBARU"),
	MAZDA ("MAZDA"),
	HYUNDAI ("HYUNDAI"),
	KIA ("KIA"),
	MERCEDEZ ("MERCEDEZ"),
	AUDI ("AUDI"),
	BMW ("BMW"),
	NISSAN ("NISSAN"),
	MITSUBISHI ("MITSUBISHI");
	private String marca;

	private Fabricante(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return this.marca;
	}
}