package model;

public class Vehiculo {
	private String modelo;
	private Fabricante marca;
	private Color color;
	private double kilometraje;
	private int año;
	private int precio;
	private double motor;

	public Vehiculo(String modelo, Fabricante marca, Color color, double kilometraje, int año, int precio, double motor) {
		this.modelo = modelo;
		this.marca = marca;
		this.color = color;
		this.kilometraje = kilometraje;
		this.año = año;
		this.precio = precio;
		this.motor = motor;
	}
	public Vehiculo(){
		this.modelo = "Sin datos";
		this.marca = null;
		this.color = null;
		this.kilometraje = 0;
		this.año = 0;
		this.precio = 0;
		this.motor = 0;
	}

	public String getModelo() {
		return this.modelo;
	}

	public Fabricante getMarca() {
		return this.marca;
	}

	public Color getColor() {
		return this.color;
	}

	public double getKilometraje() {
		return this.kilometraje;
	}

	public int getAño() {
		return this.año;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public double getMotor() {
		return this.motor;
	}

	@Override
	public String toString() {
		return this.modelo+","+this.marca+","+this.color+
				","+this.kilometraje+","+this.año+","+this.precio+","+this.motor;
	}
}