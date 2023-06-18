package data;


import model.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {

	public static List<Cliente> leerArchivoClientes(String direccion) {
		List<Cliente> clientes = new ArrayList<>();
		String textoArchivo = "";
		try {
			File archivo = new File(direccion);
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			//Lee cada linea del archivo hasta que la linea sea nula
			while ((textoArchivo = br.readLine()) != null) {
				String[] data = textoArchivo.split(",");
				clientes.add(new Cliente(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4]));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("Documento no disponible, favor contactar con administrador");
		}
		return clientes;
	}

	public static List<Vehiculo> leerArchivoVehiculos(String direccion) {
		List<Vehiculo> vehiculos = new ArrayList<>();
		String textoArchivo = "";
		try {
			File archivo = new File(direccion);
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			//Lee cada linea del archivo hasta que la linea sea nula
			while ((textoArchivo = br.readLine()) != null) {
				String[] data = textoArchivo.split(",");
				vehiculos.add(new Vehiculo(data[0], Fabricante.valueOf(data[1].toUpperCase()), Color.valueOf(data[2].toUpperCase()),
						Double.parseDouble(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Double.parseDouble(data[6])));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Documento no disponible, favor contactar con administrador");
		}
		return vehiculos;
	}

	public static void registrarDato(Object objeto, String direccion) {
		boolean lineaVacia = false;
		try {
			File file = new File(direccion);
			if (!file.exists()) {
				file.createNewFile();
				lineaVacia = true;
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (lineaVacia == false) {
				bw.newLine();
			}
			bw.write(objeto.toString());
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("Error al ingresar hora de llegada, favor contactar con administrador");
		}
	}

	public static boolean registrarDatos(List<Object> objetos, String direccion) {
		try {
			File file = new File(direccion);
			if (Files.deleteIfExists(Paths.get("C:\\Users\\jluen\\IdeaProjects\\AutomotoraV2\\" + direccion))) {
				System.out.println("El fichero ha sido borrado satisfactoriamente");
			} else {
				System.out.println("El fichero no puede ser borrado");
			}
			File fichero = new File(direccion);
			fichero.createNewFile();
			FileWriter fw = new FileWriter(fichero, true);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Object objeto : objetos) {
				bw.write(objeto.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}