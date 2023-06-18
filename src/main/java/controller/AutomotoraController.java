package controller;

import data.GestorDatos;
import model.*;
import utils.ValidarRut;
import java.util.ArrayList;
import java.util.List;

public class AutomotoraController {
	private List<Cliente> clientes;
	private List<Vehiculo> vehiculos;

	public AutomotoraController() {
		this.clientes = new ArrayList<>();
		this.vehiculos = new ArrayList<>();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public  void cargarVehiculos(){
		vehiculos = GestorDatos.leerArchivoVehiculos("vehiculo.txt");
	}
	public void cargarClientes(){
		clientes = GestorDatos.leerArchivoClientes("cliente.txt");
	}

	public void agregarVehiculo(String modelo, Fabricante fabricante, Color color, double kilometraje, int año, int precio, double motor) {
		Vehiculo vehiculo = new Vehiculo(modelo,fabricante,color,kilometraje,año,precio,motor);
		if (buscarVehiculo(vehiculo) == null){
			GestorDatos.registrarDato(vehiculo, "vehiculo.txt");
			vehiculos.add(vehiculo);
		}
	}

	public void agregarCliente(String nombre, String rut, String direccion, int contacto, String correo) {
		if (ValidarRut.validarRut(rut) && buscarCliente(rut)==null){
			Cliente cliente = new Cliente(nombre, rut, direccion, contacto, correo);
			GestorDatos.registrarDato(cliente,"cliente.txt");
			clientes.add(cliente);
		}
	}

	public Vehiculo buscarVehiculo(Vehiculo vehiculo) {
		for (Vehiculo vehiculo1: this.vehiculos){
			if (vehiculo1.equals(vehiculo)){
				return vehiculo;
			}
		}
		return null;
	}

	public List<Vehiculo> buscarVehiculoFabricante(Fabricante fabricante){
		List<Vehiculo> vehiculos = new ArrayList<>();
		for (Vehiculo vehiculo : this.vehiculos){
			if(vehiculo.getMarca().equals(fabricante)){
				vehiculos.add(vehiculo);
			}
		}
		return vehiculos;
	}
	public List<Vehiculo> buscarVehiculoModelo(String modelo){
		List<Vehiculo> vehiculos = new ArrayList<>();
		for (Vehiculo vehiculo : this.vehiculos){
			if(vehiculo.getModelo().equals(modelo)){
				vehiculos.add(vehiculo);
			}
		}
		return vehiculos;
	}

	public Cliente buscarCliente(String rut) {
		for(Cliente cliente : this.clientes){
			if(cliente.getRut().equals(rut)){
				return cliente;
			}
		}
		return null;
	}
}