package ventana;

import controller.AutomotoraController;
import javax.swing.*;
import java.awt.event.*;

public class VentanaMenu extends Ventana {

    private JLabel textoMenu;
    private JButton botonRegistrarCliente;
    private JButton botonSalida;
    private JButton botonRegistrarVehiculo;
    private JButton botonBuscarVehiculo;
    private JButton botonVenderVehiculo;
    private AutomotoraController automotoraController;

    public VentanaMenu(AutomotoraController automotoraController) {
        super("Menu ventas", 500, 520);
        this.automotoraController = automotoraController;
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarMensajeMenu();
        generarBotonRegistrarCliente();
        generarBotonRegistrarVehiculo();
        generarBotonBuscarVehiculo();
        generarBotonSalir();
    }

    private void generarMensajeMenu() {
        String textoBienvenida = "Sistema de Venta de Vehiculos";
        super.generarJLabelEncabezado(this.textoMenu, textoBienvenida, 20, 10, 500, 30);
    }

    private void generarBotonRegistrarCliente() {
        String textoBoton = "Registrar Cliente";
        this.botonRegistrarCliente = super.generarBoton(textoBoton, 150, 100, 200, 50);
        this.add(this.botonRegistrarCliente);
        this.botonRegistrarCliente.addActionListener(this);
    }

    private void generarBotonRegistrarVehiculo() {
        String textoBoton = "Registrar vehiculo";
        this.botonRegistrarVehiculo = super.generarBoton(textoBoton, 150, 180, 200, 50);
        this.add(this.botonRegistrarVehiculo);
        this.botonRegistrarVehiculo.addActionListener(this);
    }
    private void generarBotonBuscarVehiculo(){
        String textoBoton = "Buscar Vehiculo";
        this.botonBuscarVehiculo=super.generarBoton(textoBoton, 150, 260, 200, 50);
        this.add(this.botonBuscarVehiculo);
        this.botonBuscarVehiculo.addActionListener(this);
    }
    private void generarBotonSalir() {
        String textoBoton = "Salir";
        this.botonSalida = super.generarBoton(textoBoton, 175, 420, 150, 40);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrarCliente) {
            VentanaRegistroCliente ventanaRegistrarCliente= new VentanaRegistroCliente(automotoraController);
            //Cierra la ventana actual
            this.dispose();
        }
        if(e.getSource() == this.botonRegistrarVehiculo){
            VentanaRegistroVehiculo ventanaRegistroVehiculo= new VentanaRegistroVehiculo(automotoraController);
            this.dispose();
        }
        if(e.getSource() == this.botonBuscarVehiculo){
            VentanaBuscarVehiculo ventanaBusquedaVehiculo= new VentanaBuscarVehiculo(automotoraController);
            this.dispose();
        }
        if (e.getSource() == this.botonSalida){
            this.dispose();
            System.exit(0);
        }
    }
}