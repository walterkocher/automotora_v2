package ventana;

import model.Color;
import model.Fabricante;
import controller.AutomotoraController;
import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.event.ActionEvent;

public class VentanaRegistroVehiculo extends Ventana {
    private JLabel textoEncabezado, textoMarcaVehiculo, textoNombre, textoColorVehiculo,
            textoAñoVehiculo, textoPrecioVehiculo, textoKmRecorridos, textoMotor;
    private JTextField campoModelo;
    private JButton botonRegistrar, botonCancelar;
    private JFormattedTextField campoAñoVehiculo, campoPrecioVehiculo, campoKmRecorridos, campoMotor;
    private JComboBox listaMarcaVehiculo, listacolorVehiculo;
    private AutomotoraController automotoraController;
    private void generarEncabezado() {
        String textoCabecera = "Registro de Vehículo";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

    }
    public VentanaRegistroVehiculo(AutomotoraController automotoraController){
        super("Registro de Vehículo", 500, 520);
        this.automotoraController= automotoraController;
        generarElementosVentana();

    }
    private void generarElementosVentana() {
        generarEncabezado();
        generarListaMarcaVehiculo();
        generarListaColorVehiculo();
        generarCampoModelo();
        generarCampoPrecioVehiculo();
        generarCampoAñoVehiculo();
        generarCampoKmRecorridos();
        generarCampoMotor();
        generarBotonRegistrar();
        generarBotonCancelar();
    }

    private void generarListaMarcaVehiculo(){
        super.generarJLabel(this.textoMarcaVehiculo,"Marca vehículo:",20,100,100,20);
        this.listaMarcaVehiculo=super.generarListaDesplegable(Fabricante.values(),120,100, 100, 20);
        this.add(this.listaMarcaVehiculo);
    }
    private void generarListaColorVehiculo(){
        super.generarJLabel(this.textoColorVehiculo,"Color vehículo:",250,100,100,20);
        this.listacolorVehiculo=super.generarListaDesplegable(Color.values(),350,100, 100, 20);
        this.add(this.listacolorVehiculo);
    }

    private void generarBotonRegistrar() {
        String textoBoton= "Registrar Vehículo";
        this.botonRegistrar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonRegistrar);
        this.botonRegistrar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        this.botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 150, 20);
        this.add(this.botonCancelar);
        this.botonCancelar.addActionListener(this);
    }
    private void generarCampoModelo(){
        String textoNombre= "Modelo Vehículo:";
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
        this.campoModelo= super.generarJTextField(200,50,250,20);
        this.add(this.campoModelo);
    }
    private void generarCampoAñoVehiculo() {
        super.generarJLabel(this.textoAñoVehiculo, "Año:", 20, 150, 200, 20);
        InternationalFormatter formato = super.generarFormato(1950);
        this.campoAñoVehiculo = super.generarJFormattedTextField(formato, 200, 150, 250, 20);
        this.add(this.campoAñoVehiculo);
    }
    private void generarCampoPrecioVehiculo(){
        super.generarJLabel(this.textoPrecioVehiculo, "Precio:", 20, 200, 200, 20);
        InternationalFormatter formato = super.generarFormato(0);
        this.campoPrecioVehiculo = super.generarJFormattedTextField(formato, 200, 200, 250, 20);
        this.add(this.campoPrecioVehiculo);
    }
    private void generarCampoKmRecorridos(){
        super.generarJLabel(this.textoKmRecorridos, "Kilómetros recorridos:", 20, 250, 200, 20);
        InternationalFormatter formato = super.generarFormatoDouble(0);
        this.campoKmRecorridos = super.generarJFormattedTextField(formato, 200, 250, 250, 20);
        this.add(this.campoKmRecorridos);
    }
    private void generarCampoMotor(){
        super.generarJLabel(this.textoMotor, "Tamaño del motor:", 20, 300, 200, 20);
        InternationalFormatter formato = super.generarFormatoDouble(0);
        this.campoMotor= super.generarJFormattedTextField(formato, 200, 300, 250, 20);
        this.add(this.campoMotor);
    }
    private boolean registrarVehiculo(){
        if(this.campoModelo.getText().length()==0 || this.campoKmRecorridos.getText().length()==0 ||
                this.campoPrecioVehiculo.getText().length()==0 || this.campoAñoVehiculo.getText().length()==0 ||
                this.listacolorVehiculo.getSelectedItem()==null || this.campoMotor.getText().length() == 0 || this.listaMarcaVehiculo.getSelectedItem()==null){
            return false;
        }
        else{

            return true;
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonRegistrar){
            if(registrarVehiculo()){
                        automotoraController.agregarVehiculo(this.campoModelo.getText(),(Fabricante) this.listaMarcaVehiculo.getSelectedItem(),
                                (Color) this.listacolorVehiculo.getSelectedItem(), Double.parseDouble(this.campoKmRecorridos.getText()),
                                Integer.parseInt(this.campoAñoVehiculo.getText()),Integer.parseInt(this.campoPrecioVehiculo.getText()), Double.parseDouble(this.campoMotor.getText()));
                JOptionPane.showMessageDialog(this,"Vehículo registrado correctamente","Mensaje de confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                VentanaMenu ventanaMenu = new VentanaMenu(automotoraController);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this,"Complete todos los datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == this.botonCancelar){
            VentanaMenu ventanaMenu = new VentanaMenu(automotoraController);
            this.dispose();
        }

    }
}