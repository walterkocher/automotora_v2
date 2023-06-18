package model;

public class Cliente {
	private String nombre;
	private String rut;
	private String direccion;
	private int contacto;
	private String correo;

	public Cliente(String nombre, String rut, String direccion, int contacto, String correo) {
		this.nombre = nombre;
		this.rut = rut;
		this.direccion = direccion;
		this.contacto = contacto;
		this.correo = correo;

	}

	public String getNombre() {
		return this.nombre;
	}

	public String getRut() {
		return this.rut;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getContacto() {
		return this.contacto;
	}

	public void setContacto(int contacto) {
		this.contacto = contacto;
	}

	public String getCorreo() {
		return this.correo;
	}

	@Override
	public String toString() {
		return getNombre()+","+getRut()+","+getDireccion()+","+getContacto()+","+getCorreo();
	}
}
