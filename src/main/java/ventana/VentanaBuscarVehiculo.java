package ventana;

import model.Fabricante;
import model.Vehiculo;
import controller.AutomotoraController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;
public class VentanaBuscarVehiculo extends Ventana {
    private JButton botonBuscar, botonRegresar;
    private JLabel textoEncabezado, textoNombre, textoMarca;
    private JComboBox listaMarca;
    private JTextField campoModelo;
    private AutomotoraController automotoraController;

    public VentanaBuscarVehiculo(AutomotoraController automotoraController) {
        super("Búsqueda de Vehículo", 500, 520);
        this.automotoraController = automotoraController;
        generarElementosVentana();
    }
    private void generarElementosVentana() {
        generarCampoNombre();
        generarBotonBuscarVehiculo();
        generarBotonCancelar();
        generarListaMarcaVehiculo();
    }
    private void generarCampoNombre(){
        String textoNombre= "Modelo Vehículo:";
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,40);
        this.campoModelo = super.generarJTextField(150,50,250,40);
        this.add(this.campoModelo);
    }
    private void generarListaMarcaVehiculo(){
        super.generarJLabel(this.textoMarca,"Marca vehículo:",20,100,100,40);
        this.listaMarca=super.generarListaDesplegable(Fabricante.values(),150,100, 150, 40);
        this.add(this.listaMarca);
    }
    private void generarBotonBuscarVehiculo() {
        String textoBoton= "Buscar Vehículo";
        this.botonBuscar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonBuscar);
        this.botonBuscar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonRegresar = "Regresar";
        this.botonRegresar = super.generarBoton(textoBotonRegresar, 275, 400, 150, 20);
        this.add(this.botonRegresar);
        this.botonRegresar.addActionListener(this);
    }
    private String[][] registrarVehiculo(){
        List<Vehiculo> vehiculos;
        String[][] datosVehiculos;
        if(this.campoModelo.getText().length()==0){
            vehiculos =  automotoraController.buscarVehiculoFabricante((Fabricante) this.listaMarca.getSelectedItem());
        }
        else{
            vehiculos = automotoraController.buscarVehiculoModelo(this.campoModelo.getText());
        }
        datosVehiculos= new String[vehiculos.size()][7];
        for(int i=0; i<vehiculos.size(); i++){
            datosVehiculos[i][0] = vehiculos.get(i).getModelo();
            datosVehiculos[i][1] = vehiculos.get(i).getMarca().getMarca();
            datosVehiculos[i][2] = vehiculos.get(i).getColor().getColor();
            datosVehiculos[i][3] = Double.toString(vehiculos.get(i).getKilometraje());
            datosVehiculos[i][4] = Integer.toString(vehiculos.get(i).getAño());
            datosVehiculos[i][5] = Integer.toString(vehiculos.get(i).getPrecio());
            datosVehiculos[i][6] = Double.toString(vehiculos.get(i).getMotor());
        }
        return datosVehiculos;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonBuscar){
            String[] nombreColumnas={"Modelo","Marca","Color","Kilómetraje","Año","Precio","Motor"};
            VentanaTabla ventanaTabla= new VentanaTabla(registrarVehiculo(),nombreColumnas);
        }
        if (e.getSource() == this.botonRegresar){
            VentanaMenu ventanaMenu = new VentanaMenu(automotoraController);
            this.dispose();
        }

    }
}