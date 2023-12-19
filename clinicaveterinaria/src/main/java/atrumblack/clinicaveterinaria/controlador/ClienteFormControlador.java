package atrumblack.clinicaveterinaria.controlador;

import atrumblack.clinicaveterinaria.modelo.Cliente;
import atrumblack.clinicaveterinaria.modelo.Mascota;
import atrumblack.clinicaveterinaria.servicio.ClienteServicio;
import atrumblack.clinicaveterinaria.servicio.MascotaServicio;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ClienteFormControlador extends FormularioControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(ClienteFormControlador.class);
    private Integer idClienteInterno;
    @Autowired
    private ClienteServicio clienteServicio;
    @Autowired
    private MascotaServicio mascotaServicio;

    @FXML
    private AnchorPane cliente_form;

    @FXML
    private TextField cliente_text_buscar_alias;

    //Tabla Cliente
    @FXML
    private TableView<Cliente> cliente_tabla;
    @FXML
    private TableColumn<Cliente, Integer> cliente_col_id;
    @FXML
    private TableColumn<Cliente, String> cliente_col_apellido;
    @FXML
    private TableColumn<Cliente, String> cliente_col_nombre;
    @FXML
    private TableColumn<Cliente, String> cliente_col_telefono;
    @FXML
    private TableColumn<Cliente, String> cliente_col_contacto;
    @FXML
    private TableColumn<Cliente, String> cliente_col_direccion;
    @FXML
    private TableColumn<Cliente, String> cliente_col_documento;
    @FXML
    private TableColumn<Cliente, String> cliente_col_email;


    //Tabla Mascota
    @FXML
    private TableView<Mascota> cliente_tabla_Mascota;
    @FXML
    private TableColumn<Mascota, String> cliente_col_alias_mascota;
    @FXML
    private TableColumn<Mascota, String> cliente_col_especie_mascota;
    @FXML
    private TableColumn<Mascota, Integer> cliente_col_id_mascota;

    //TextFiel Cliente

    @FXML
    private TextField cliente_text_apellido;
    @FXML
    private TextField cliente_text_contacto;
    @FXML
    private TextField cliente_text_direccion;
    @FXML
    private TextField cliente_text_documento;
    @FXML
    private TextField cliente_text_email;
    @FXML
    private TextField cliente_text_nombre;
    @FXML
    private TextField cliente_text_telefono;

    //TextFieldMascota
    @FXML
    private TextField cliente_text_especie_mascota;
    @FXML
    private TextField cliente_text_alias_mascota;

    //Botones
    @FXML
    private JFXButton cliente_btn_agregar;
    @FXML
    private JFXButton cliente_btn_eliminar;
    @FXML
    private JFXButton cliente_btn_limpiar;
    @FXML
    private JFXButton cliente_btn_modificar;

    //Boton Agregar Mascota
    @FXML
    private JFXButton cliente_btn_agregar_mascota;

    private final ObservableList<Cliente> clienteList =
            FXCollections.observableArrayList();
    private final ObservableList<Mascota> mascotaList =
            FXCollections.observableArrayList();

    private void configurarColumnasCliente() {
        cliente_col_id.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        cliente_col_documento.setCellValueFactory(new PropertyValueFactory<>("documento"));
        cliente_col_apellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        cliente_col_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cliente_col_direccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        cliente_col_telefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        cliente_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        cliente_col_contacto.setCellValueFactory(new PropertyValueFactory<>("alternativa"));

    }

    private void configurarColumnasMascota() {
        cliente_col_id_mascota.setCellValueFactory(new PropertyValueFactory<>("idMascota"));
        cliente_col_alias_mascota.setCellValueFactory(new PropertyValueFactory<>("alias"));
        cliente_col_especie_mascota.setCellValueFactory(new PropertyValueFactory<>("especie"));

        // Establecer la tabla de Mascota como no editable
        cliente_tabla_Mascota.setEditable(false);

        // Establecer el modelo de selección como nulo para hacer que la tabla no sea seleccionable
        cliente_tabla_Mascota.setSelectionModel(null);
    }

    //Listar Cliente
    private void listarCliente() {
        logger.info("Ejecutando listado de clientes");
        clienteList.clear();
        clienteList.addAll(clienteServicio.listarClientes());
        cliente_tabla.setItems(clienteList);
    }

    //Listar Mascota
    private void listarMoscota(Integer id) {
        logger.info("Ejecutando listado de mascota por cliente");
        mascotaList.clear();
        mascotaList.addAll(mascotaServicio.listarMascotaPorCliente(id));
        cliente_tabla_Mascota.setItems(mascotaList);
    }

    @FXML
    public void initialize() {
        cliente_tabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        configurarColumnasCliente();
        configurarColumnasMascota();
        configurarListeners();
        listarCliente();

        // Configurar el Listener para la búsqueda en tiempo real
//        cliente_text_buscar_alias.textProperty().addListener((observable, oldValue, newValue) -> buscarClientePorApellido(newValue));

    }

    private void configurarListeners() {
        // Configurar el Listener para la búsqueda en tiempo real mientras se escribe
//        cliente_text_buscar_alias.textProperty().addListener((observable, oldValue, newValue) -> buscarClientePorApellido(newValue));

        // Configurar el Listener para la búsqueda en tiempo real mientras se escribe
        cliente_text_buscar_alias.textProperty().addListener((observable, oldValue, newValue) -> filtrarClientesPorApellido(newValue));
    }

    private void filtrarClientesPorApellido(String apellido) {
        List<Cliente> clientesFiltrados = clienteList.stream()
                .filter(cliente -> cliente.getApellido().toLowerCase().startsWith(apellido.toLowerCase()))
                .collect(Collectors.toList());

        cliente_tabla.setItems(FXCollections.observableArrayList(clientesFiltrados));
    }

    // Método para buscar clientes por apellido
    private void buscarClientePorApellido(String apellido) {
        clienteList.clear();
        clienteList.addAll(clienteServicio.buscarClientesPorApellido(apellido));
        cliente_tabla.setItems(clienteList);
    }

    public void cargarClienteFormulario() {
        var cliente = cliente_tabla.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            idClienteInterno = cliente.getIdCliente();
            cliente_text_apellido.setText(cliente.getApellido());
            cliente_text_nombre.setText(cliente.getNombre());
            cliente_text_documento.setText(cliente.getDocumento());
            cliente_text_direccion.setText(cliente.getDireccion());
            cliente_text_email.setText(cliente.getEmail());
            cliente_text_telefono.setText(cliente.getTelefono());
            cliente_text_contacto.setText(cliente.getAlternativa());
            listarMoscota(idClienteInterno);
        }
    }

    public void agregarTarea() {
        if (cliente_text_apellido.getText().isEmpty()) {
            mostrarMensaje("Error Validacion", "Debe proporcionar una Apellido");
            cliente_text_apellido.requestFocus();
            return;
        } else {
            var cliente = new Cliente();
            recolectarDatosFormulario(cliente);
            cliente.setIdCliente(null);
            clienteServicio.guardarCliente(cliente);
            mostrarMensaje("Informacion", "Cliente agregado");
            limpiarFormulario();
            listarCliente();
        }
    }

    private void recolectarDatosFormulario(Cliente cliente) {
        if (idClienteInterno != null) {
            cliente.setIdCliente(idClienteInterno);
            cliente.setApellido(cliente_text_apellido.getText());
            cliente.setNombre(cliente_text_nombre.getText());
            cliente.setDocumento(cliente_text_documento.getText());
            cliente.setDireccion(cliente_text_direccion.getText());
            cliente.setEmail(cliente_text_email.getText());
            cliente.setTelefono(cliente_text_telefono.getText());
            cliente.setAlternativa(cliente_text_contacto.getText());
            cliente.setActivo(true);
        }

    }

    private void mostrarMensaje(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public void limpiarFormulario() {
        idClienteInterno = null;
        cliente_text_apellido.clear();
        cliente_text_nombre.clear();
        cliente_text_documento.clear();
        cliente_text_direccion.clear();
        cliente_text_email.clear();
        cliente_text_telefono.clear();
        cliente_text_contacto.clear();
    }

    public void modificarTarea(){
        if(idClienteInterno == null){
            mostrarMensaje("Informacion", "Debe seleccionar una tarea");
            return;
        }
        if(cliente_text_apellido.getText().isEmpty()){
            mostrarMensaje("Error Validacion", "Debe proporcionar un Apellido");
            cliente_text_apellido.requestFocus();
            return;
        }
        var cliente = new Cliente();
        recolectarDatosFormulario(cliente);
        clienteServicio.guardarCliente(cliente);
        mostrarMensaje("Informacion", "Tarea modificada");
        limpiarFormulario();
        listarCliente();
    }

    public void eliminarCliente(){
        var cliente = cliente_tabla.getSelectionModel().getSelectedItem();
        if(cliente != null){
            logger.info("Registro a eliminar: " + cliente.toString());
            clienteServicio.eliminarCliente(cliente);
            mostrarMensaje("Informacion", "Tarea eliminada:" + cliente.getIdCliente());
            limpiarFormulario();
            listarCliente();
        }
        else{
            mostrarMensaje("Error", "No se ha seleccionado ningun Cliente");
        }
    }
}
