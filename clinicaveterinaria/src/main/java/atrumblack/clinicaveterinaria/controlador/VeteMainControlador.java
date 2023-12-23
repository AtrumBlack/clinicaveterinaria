package atrumblack.clinicaveterinaria.controlador;


import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.stereotype.Component;

@Component
public class VeteMainControlador implements Initializable {

    private Map<Button, AnchorPane> buttonToFormMap = new HashMap<>();

    private ClienteFormControlador clienteControlador;
    private MascotaFormControlador mascotaControlador;

    @FXML
    private AnchorPane cliente_form;
    @FXML
    private AnchorPane mascota_form;
    @FXML
    private AnchorPane factura_form;
    @FXML
    private AnchorPane historia_clinica_form;
    @FXML
    private AnchorPane main_form;
    @FXML
    private AnchorPane turnos_form;
    @FXML
    private AnchorPane visitas_form;

    //Formulario Principal - Main
    @FXML
    private Button main_btn_cliente;

    @FXML
    private Button main_btn_facturacion;

    @FXML
    private Button main_btn_historia_clinica;

    @FXML
    private Button main_btn_mascota;

    @FXML
    private Button main_btn_reserva_turno;

    @FXML
    private Button main_btn_visita;

    @FXML
    private Button main_btn_servicio;

    @FXML
    private Button main_btn_producto;

    @FXML
    private Button main_btn_reserva_proveedor;

    @FXML
    private Button main_btn_impuesto;

    @FXML
    private Button main_btn_cerrar;

    @FXML
    private Button main_btn_permiso;


    //-----------------------------------------------------------------------------

    private Button selectedButton; // Variable para almacenar el botón seleccionado actualmente
    public void switchForm(ActionEvent event) {
//        // Restaurar el estilo del botón previamente seleccionado, si hay alguno
//        if (selectedButton != null) {
//            selectedButton.setStyle("-fx-background-color: transparent;");
//        }

        // Obtener el botón que disparó el evento
        Button clickedButton = (Button) event.getSource();

//        // Aplicar el estilo al botón seleccionado
//        clickedButton.setStyle("-fx-background-color: rgba(39, 43, 63, 0.7);");

        // Actualizar la variable selectedButton
        selectedButton = clickedButton;


        // Ocultar todos los formularios
        buttonToFormMap.values().forEach(form -> form.setVisible(false));

        // Mostrar el formulario asociado al botón clickeado
        AnchorPane selectedForm = buttonToFormMap.get(clickedButton);
        if (selectedForm != null) {
            selectedForm.setVisible(true);
        }
    }

    private double x = 0;
    private double y = 0;
    public void logout(){

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {

                main_btn_cerrar.getScene().getWindow().hide();
                //clinicaveterinaria/src/main/resources/templates
                Parent root = FXMLLoader.load(getClass().getResource("/templates/logIn.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private ClienteFormControlador clienteFormControlador;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Inicializar los controladores específicos
//        clienteControlador = new ClienteFormControlador(cliente_form);
//        mascotaControlador = new MascotaFormControlador(mascota_Form);
        clienteFormControlador = new ClienteFormControlador();
        // Otros inicializaciones...

        // Por ejemplo, mostrar el formulario de cliente al inicio
        clienteFormControlador.mostrarFormulario(main_form);

        // Inicializar el mapa de botones y formularios
        buttonToFormMap.put(main_btn_cliente, cliente_form);
        buttonToFormMap.put(main_btn_mascota, mascota_form);
       // buttonToFormMap.put(main_btn_tratamiento, tratamiento_form);
        buttonToFormMap.put(main_btn_visita, visitas_form);
        buttonToFormMap.put(main_btn_historia_clinica, historia_clinica_form);
        buttonToFormMap.put(main_btn_reserva_turno, turnos_form);
        buttonToFormMap.put(main_btn_facturacion, factura_form);

//        // Seleccionar "Inicio" y aplicar el estilo
//        selectedButton = main_btn_inicio;
//        selectedButton.setStyle("-fx-background-color: rgba(39, 43, 63, 0.7);");

        // Mostrar el formulario asociado al botón "Inicio"
        AnchorPane selectedForm = buttonToFormMap.get(selectedButton);
        if (selectedForm != null) {
            selectedForm.setVisible(true);
        }
    }

}
