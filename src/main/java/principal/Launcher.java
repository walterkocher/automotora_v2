package principal;
import controller.AutomotoraController;
import ventana.VentanaMenu;

public class Launcher {
	public static void main(String[] args) {
		AutomotoraController automotoraController = new AutomotoraController();
		automotoraController.cargarVehiculos();
		automotoraController.cargarClientes();
		VentanaMenu ventanaMenu = new VentanaMenu(automotoraController);

	}
}
