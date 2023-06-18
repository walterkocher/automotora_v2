package ventana;
import controller.AutomotoraController;

import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.event.ActionEvent;

public class VentanaRegistroCliente extends Ventana {
    private JLabel textoEncabezado, textoRut, textoNombre, textoDireccion, textoNumeroTelefonico, textoCorreo;
    private JTextField campoRut, campoNombre, campoDireccion, campoNumeroTelefonico, campoCorreo;
    private JButton botonRegistrar, botonCancelar;
    private AutomotoraController automotoraController;


    public VentanaRegistroCliente(AutomotoraController automotoraController){
        super("Registro de cliente", 500, 520);
        this.automotoraController = automotoraController;
        generarElementosVentana();
    }
    private void generarElementosVentana() {
        generarEncabezado();
        generarBotonCancelar();
        generarBotonRegistrar();
        generarCampoDireccion();
        generarCampoNombre();
        generarCampoNumeroTelefonico();
        generarCampoRut();
        generarCampoCorreo();
    }
    private void generarEncabezado() {
        String textoCabecera = "Registro de cliente";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

    }
    private void generarBotonRegistrar() {
        String textoBoton= "Registrar Cliente";
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
    private void generarCampoNombre(){
        String textoNombre= "Nombre:";
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
        this.campoNombre= super.generarJTextField(200,50,250,20);
        this.add(this.campoNombre);
    }
    private void generarCampoRut(){
        String textoRut= "Rut:";
        super.generarJLabel(this.textoRut,textoRut,20,100,150,20);
        this.campoRut= super.generarJTextField(200,100,250,20);
        this.add(this.campoRut);
    }
    private void generarCampoDireccion(){
        String textoDireccion= "Dirección:";
        super.generarJLabel(this.textoDireccion,textoDireccion,20,150,150,20);
        this.campoDireccion= super.generarJTextField(200,150,250,20);
        this.add(this.campoDireccion);
    }
    private void generarCampoCorreo(){
        String textoCorreo= "Correo electrónico:";
        super.generarJLabel(this.textoCorreo,textoCorreo,20,200,150,20);
        this.campoCorreo= super.generarJTextField(200,200,250,20);
        this.add(this.campoCorreo);
    }
    private void generarCampoNumeroTelefonico(){
        String textoNumero= "Número telefónico:";
        super.generarJLabel(this.textoNumeroTelefonico,textoNumero,20,250,150,20);
        this.campoNumeroTelefonico= super.generarJTextField(200,250,250,20);
        this.add(this.campoNumeroTelefonico);
    }
    private boolean registrarCliente(){
        if(this.campoNombre.getText().length()== 0|| this.campoRut.getText().length()==0 ||
                this.campoDireccion.getText().length()==0 || this.campoNumeroTelefonico.getText().length()==0 ||
                this.campoCorreo.getText().length()==0){
            return false;
        }
        else{

            return true;
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrar) {
            if(registrarCliente()) {
                if(automotoraController.buscarCliente(this.campoRut.getText())==null){
                    automotoraController.agregarCliente(this.campoNombre.getText(),this.campoRut.getText(),this.campoDireccion.getText(),
                        Integer.parseInt(this.campoNumeroTelefonico.getText()), this.campoCorreo.getText());
                    JOptionPane.showMessageDialog(this,"Cliente registrado correctamente");
                    VentanaMenu ventanaMenu = new VentanaMenu(automotoraController);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this,"El cliente ya existe");
                    VentanaRegistroCliente ventanaRegistroCliente = new VentanaRegistroCliente(automotoraController);
                    this.dispose();
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Ingrese un rut válido");
            }

        }
        if (e.getSource() == this.botonCancelar){
            VentanaMenu ventanaMenu = new VentanaMenu(automotoraController);
            this.dispose();
        }

    }
}