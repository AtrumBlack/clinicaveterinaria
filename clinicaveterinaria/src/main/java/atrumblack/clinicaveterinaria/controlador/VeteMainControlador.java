package atrumblack.clinicaveterinaria.controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

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
    private AnchorPane tratamiento_form;
    @FXML
    private AnchorPane turnos_form;
    @FXML
    private AnchorPane visitas_form;

//Formulario Cliente
//@FXML
//private TableView<?> cliente_tabla;
//
//    @FXML
//    private TableView<?> cliente_tabla_Mascota;
//
//    @FXML
//    private TextField cliente_text_alias_mascota;
//
//    @FXML
//    private TextField cliente_text_apellido;
//
//    @FXML
//    private TextField cliente_text_buscar_alias;
//
//    @FXML
//    private TextField cliente_text_contacto;
//
//    @FXML
//    private TextField cliente_text_direccion;
//
//    @FXML
//    private TextField cliente_text_documento;
//
//    @FXML
//    private TextField cliente_text_email;
//
//    @FXML
//    private TextField cliente_text_especie_mascota;
//
//    @FXML
//    private TextField cliente_text_nombre;
//
//    @FXML
//    private TextField cliente_text_telefono;
//
//    @FXML
//    private JFXButton cliente_btn_agregar;
//
//    @FXML
//    private JFXButton cliente_btn_agregar_mascota;
//
//    @FXML
//    private JFXButton cliente_btn_eliminar;
//
//    @FXML
//    private JFXButton cliente_btn_limpiar;
//
//    @FXML
//    private JFXButton cliente_btn_modificar;
//
//    @FXML
//    private TableColumn<?, ?> cliente_col_alias_mascota;
//
//    @FXML
//    private TableColumn<?, ?> cliente_col_apellido;
//
//    @FXML
//    private TableColumn<?, ?> cliente_col_contacto;
//
//    @FXML
//    private TableColumn<?, ?> cliente_col_direccion;
//
//    @FXML
//    private TableColumn<?, ?> cliente_col_documento;
//
//    @FXML
//    private TableColumn<?, ?> cliente_col_email;
//
//    @FXML
//    private TableColumn<?, ?> cliente_col_especie_mascota;
//
//    @FXML
//    private TableColumn<?, ?> cliente_col_id;
//
//    @FXML
//    private TableColumn<?, ?> cliente_col_id_mascota;
//
//    @FXML
//    private TableColumn<?, ?> cliente_col_nombre;
//
//    @FXML
//    private TableColumn<?, ?> cliente_col_telefono;

    //-----------------------------------------------------------------------------

    //Formulario Mascota
//
//    @FXML
//    private TableView<?> mascota_tabla;
//
//    @FXML
//    private TextField mascota_text_alias;
//
//    @FXML
//    private TextField mascota_text_buscar_alias;
//
//    @FXML
//    private TextField mascota_text_color_de_pelo;
//
//    @FXML
//    private TextField mascota_text_especie;
//
//    @FXML
//    private DatePicker mascota_text_fecha_nacimiento;
//
//    @FXML
//    private TextField mascota_text_peso_actual;
//
//    @FXML
//    private TextField mascota_text_peso_promedio;
//
//    @FXML
//    private TextField mascota_text_sexo;
//
//    @FXML
//    private JFXButton mascota_btn_eliminar;
//
//    @FXML
//    private JFXButton mascota_btn_limpiar;
//
//    @FXML
//    private JFXButton mascota_btn_modificar;
//
//    @FXML
//    private TableColumn<?, ?> mascota_col_alias;
//
//    @FXML
//    private TableColumn<?, ?> mascota_col_cliente;
//
//    @FXML
//    private TableColumn<?, ?> mascota_col_color_de_pelo;
//
//    @FXML
//    private TableColumn<?, ?> mascota_col_especie;
//
//    @FXML
//    private TableColumn<?, ?> mascota_col_fecha_nacimiento;
//
//    @FXML
//    private TableColumn<?, ?> mascota_col_id;
//
//    @FXML
//    private TableColumn<?, ?> mascota_col_peso_actual;
//
//    @FXML
//    private TableColumn<?, ?> mascota_col_peso_promedio;
//
//    @FXML
//    private TableColumn<?, ?> mascota_col_sexo;

    //-------------------------------------------------------------------------------------

    //Formulario Factura
//    @FXML
//    private JFXButton factura_btn_agregar;
//
//    @FXML
//    private JFXButton factura_btn_efectivo;
//
//    @FXML
//    private JFXButton factura_btn_limpiar;
//
//    @FXML
//    private JFXButton factura_btn_tarjeta;
//
//    @FXML
//    private TableColumn<?, ?> factura_col_alias;
//
//    @FXML
//    private TableColumn<?, ?> factura_col_cantidad;
//
//    @FXML
//    private TableColumn<?, ?> factura_col_cliente;
//
//    @FXML
//    private TableColumn<?, ?> factura_col_concepto;
//
//    @FXML
//    private TableColumn<?, ?> factura_col_especie;
//
//    @FXML
//    private TableColumn<?, ?> factura_col_fecha_visita;
//
//    @FXML
//    private TableColumn<?, ?> factura_col_id;
//
//    @FXML
//    private TableColumn<?, ?> factura_col_id_mascota;
//
//    @FXML
//    private TableColumn<?, ?> factura_col_importe;
//
//    @FXML
//    private TableColumn<?, ?> factura_col_precio_unitario;
//
//    @FXML
//    private TableView<?> factura_tabla;
//
//    @FXML
//    private TableView<?> factura_tabla_mascota;
//
//    @FXML
//    private TextField factura_text_buscar_alias;
//
//    @FXML
//    private TextField factura_text_cliente;
//
//    @FXML
//    private TextField factura_text_direccion;
//
//    @FXML
//    private TextField factura_text_email;
//
//    @FXML
//    private TextField factura_text_importe_total;
//
//    @FXML
//    private TextField factura_text_telefono;

    //-------------------------------------------------------------------------------------
    //Formulario Historia Clinica

//    @FXML
//    private TableColumn<?, ?> historia_clinica_col_alias;
//
//    @FXML
//    private TableColumn<?, ?> historia_clinica_col_alias_mascota;
//
//    @FXML
//    private TableColumn<?, ?> historia_clinica_col_cliente;
//
//    @FXML
//    private TableColumn<?, ?> historia_clinica_col_cliente_mascota;
//
//    @FXML
//    private TableColumn<?, ?> historia_clinica_col_id;
//
//    @FXML
//    private TableColumn<?, ?> historia_clinica_col_id_mascota;
//
//    @FXML
//    private JFXComboBox<?> historia_clinica_combo_informacion_general;
//
//    @FXML
//    private JFXComboBox<?> historia_clinica_combo_tratamiento;
//
//    @FXML
//    private JFXComboBox<?> historia_clinica_combo_vacuna;
//
//    @FXML
//    private JFXComboBox<?> historia_clinica_combo_vistas;
//
//    @FXML
//    private TableView<?> historia_clinica_tabla;
//
//    @FXML
//    private TableView<?> historia_clinica_tabla_mascota;
//
//    @FXML
//    private TextField historia_clinica_text_buscar_alias;

    //-----------------------------------------------------------------------------
    //Formulario Principal - Main
    @FXML
    private JFXButton main_btn_cliente;

    @FXML
    private JFXButton main_btn_facturacion;

    @FXML
    private JFXButton main_btn_historia_clinica;

    @FXML
    private JFXButton main_btn_inicio;

    @FXML
    private JFXButton main_btn_mascota;

    @FXML
    private JFXButton main_btn_reserva_turno;

    @FXML
    private JFXButton main_btn_salir;

    @FXML
    private JFXButton main_btn_tratamiento;

    @FXML
    private JFXButton main_btn_visita;

    //-----------------------------------------------------------------------------

    //Formulario Tratamiento

//    @FXML
//    private JFXButton tratamiento_btn_agregar;
//
//    @FXML
//    private JFXButton tratamiento_btn_eliminar;
//
//    @FXML
//    private JFXButton tratamiento_btn_limpiar;
//
//    @FXML
//    private JFXButton tratamiento_btn_modificar;
//
//    @FXML
//    private TableColumn<?, ?> tratamiento_col_descripcion;
//
//    @FXML
//    private TableColumn<?, ?> tratamiento_col_id;
//
//    @FXML
//    private TableColumn<?, ?> tratamiento_col_importe;
//
//    @FXML
//    private TableColumn<?, ?> tratamiento_col_tipo;
//
//    @FXML
//    private TextField tratamiento_tex_descripcion;
//
//    @FXML
//    private TextField tratamiento_tex_importe;
//
//    @FXML
//    private TextField tratamiento_text_tipo;
//
//    @FXML
//    private TextField tratamiento_txt_buscar;

    //--------------------------------------------------------------

    //Formulario Turnos

//    @FXML
//    private JFXButton turnos_btn_10;
//
//    @FXML
//    private JFXButton turnos_btn_1030;
//
//    @FXML
//    private JFXButton turnos_btn_11;
//
//    @FXML
//    private JFXButton turnos_btn_1130;
//
//    @FXML
//    private JFXButton turnos_btn_12;
//
//    @FXML
//    private JFXButton turnos_btn_1230;
//
//    @FXML
//    private JFXButton turnos_btn_13;
//
//    @FXML
//    private JFXButton turnos_btn_1330;
//
//    @FXML
//    private JFXButton turnos_btn_14;
//
//    @FXML
//    private JFXButton turnos_btn_1430;
//
//    @FXML
//    private JFXButton turnos_btn_15;
//
//    @FXML
//    private JFXButton turnos_btn_1530;
//
//    @FXML
//    private JFXButton turnos_btn_16;
//
//    @FXML
//    private JFXButton turnos_btn_8;
//
//    @FXML
//    private JFXButton turnos_btn_830;
//
//    @FXML
//    private JFXButton turnos_btn_9;
//
//    @FXML
//    private JFXButton turnos_btn_930;
//
//    @FXML
//    private JFXButton turnos_btn_agregar;
//
//    @FXML
//    private JFXButton turnos_btn_eliminar;
//
//    @FXML
//    private JFXButton turnos_btn_limpiar;
//
//    @FXML
//    private JFXButton turnos_btn_modificar;
//
//    @FXML
//    private TableColumn<?, ?> turnos_col_alias;
//
//    @FXML
//    private TableColumn<?, ?> turnos_col_cliente;
//
//    @FXML
//    private TableColumn<?, ?> turnos_col_id;
//
//    @FXML
//    private DatePicker turnos_date_fecha_reserva;
//
//
//
//    @FXML
//    private TableView<?> turnos_tabla_mascota;
//
//    @FXML
//    private TextField turnos_text_buscar_alias;
//
//    @FXML
//    private TextField turnos_text_cliente;

    //---------------------------------------------------------
    //Formulario Visita

//    @FXML
//    private JFXButton visitas_btn_agregar;
//
//    @FXML
//    private JFXButton visitas_btn_agregar_tratamiento;
//
//    @FXML
//    private JFXButton visitas_btn_eliminar;
//
//    @FXML
//    private JFXButton visitas_btn_eliminar_tratamiento;
//
//    @FXML
//    private JFXButton visitas_btn_limpiar;
//
//    @FXML
//    private JFXButton visitas_btn_modificar;
//
//    @FXML
//    private TableColumn<?, ?> visitas_col_alias;
//
//    @FXML
//    private TableColumn<?, ?> visitas_col_cliente;
//
//    @FXML
//    private TableColumn<?, ?> visitas_col_descripcion;
//
//    @FXML
//    private TableColumn<?, ?> visitas_col_especie;
//
//    @FXML
//    private TableColumn<?, ?> visitas_col_id_mascota;
//
//    @FXML
//    private TableColumn<?, ?> visitas_col_id_tratamiento;
//
//    @FXML
//    private TableColumn<?, ?> visitas_col_tipo;
//
//
//
//    @FXML
//    private TableView<?> visitas_tabla_mascota;
//
//    @FXML
//    private TableView<?> visitas_tabla_tratamiento;
//
//    @FXML
//    private TextField visitas_text_alias;
//
//    @FXML
//    private TextField visitas_text_buscar_alias;
//
//    @FXML
//    private TextField visitas_text_cliente;
//
//    @FXML
//    private TextField visitas_text_destalles_sintomas;
//
//    @FXML
//    private TextField visitas_text_importe;
//
//    @FXML
//    private TextField visitas_text_peso_actual;

    //------------------------------------------------------------------------------------------------
    private Button selectedButton; // Variable para almacenar el botón seleccionado actualmente
    public void switchForm(ActionEvent event) {
        // Restaurar el estilo del botón previamente seleccionado, si hay alguno
        if (selectedButton != null) {
            selectedButton.setStyle("-fx-background-color: transparent;");
        }

        // Obtener el botón que disparó el evento
        Button clickedButton = (Button) event.getSource();

        // Aplicar el estilo al botón seleccionado
        clickedButton.setStyle("-fx-background-color: #272b3f;");

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

                main_btn_salir.getScene().getWindow().hide();
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
        clienteFormControlador.mostrarFormulario(cliente_form);

        // Inicializar el mapa de botones y formularios
        buttonToFormMap.put(main_btn_cliente, cliente_form);
        buttonToFormMap.put(main_btn_mascota, mascota_form);
        buttonToFormMap.put(main_btn_tratamiento, tratamiento_form);
        buttonToFormMap.put(main_btn_visita, visitas_form);
        buttonToFormMap.put(main_btn_historia_clinica, historia_clinica_form);
        buttonToFormMap.put(main_btn_reserva_turno, turnos_form);
        buttonToFormMap.put(main_btn_facturacion, factura_form);
    }

//    @FXML
//    private void switchToClienteForm() {
//        clienteControlador.mostrarFormulario();
//        mascotaControlador.ocultarFormulario();
//        // Ocultar otros formularios...
//    }
//
//    @FXML
//    private void switchToMascotaForm() {
//        clienteControlador.ocultarFormulario();
//        mascotaControlador.mostrarFormulario();
//        // Ocultar otros formularios...
//    }
}
