package atrumblack.clinicaveterinaria.controlador;

import atrumblack.clinicaveterinaria.modelo.Cliente;
import atrumblack.clinicaveterinaria.modelo.Mascota;
import atrumblack.clinicaveterinaria.modelo.TipoMascota;
import atrumblack.clinicaveterinaria.repositorio.ClienteRepositorio;
import atrumblack.clinicaveterinaria.servicio.ClienteServicio;
import atrumblack.clinicaveterinaria.servicio.MascotaServicio;
//import com.jfoenix.controls.JFXButton;
import atrumblack.clinicaveterinaria.servicio.TipoMascotaServicio;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
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
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
import java.util.Optional;
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
    @Autowired
    private TipoMascotaServicio tipoMascotaServicio;
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
    private ComboBox<String> cliente_combo_especie_mascota;
    @FXML
    private TextField cliente_text_alias_mascota;

    //Botones
    @FXML
    private Button cliente_btn_agregar;
    @FXML
    private Button cliente_btn_eliminar;
    @FXML
    private Button cliente_btn_limpiar;
    @FXML
    private Button cliente_btn_modificar;

    //Boton Agregar Mascota
    @FXML
    private Button cliente_btn_agregar_mascota;
    @Autowired
    private ClienteRepositorio clienteRepositorio;
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
        // Ajustar la columna para obtener el nombre del tipo de la entidad TipoMascota
        cliente_col_especie_mascota.setCellValueFactory(cellData -> {
            ObjectProperty<String> especieProperty = new SimpleObjectProperty<>();
            TipoMascota tipoMascota = cellData.getValue().getTipoMascota();
            if (tipoMascota != null) {
                especieProperty.setValue(tipoMascota.getNombreTipo());
            }
            return especieProperty;
        });

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
//        // Configurar el ComboBox para el campo de Sexo
//        cliente_combo_especie_mascota.getItems().setAll(TipoMascota);
        // Configurar el ComboBox para el campo de TipoMascota
        cargarTiposMascotaEnComboBox();
        // Agregar un ChangeListener para manejar la selección de la tabla en tiempo real
        cliente_tabla.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                idClienteInterno = newValue.getIdCliente();

                cargarClienteFormulario();
            }
        });
    }
    private void cargarTiposMascotaEnComboBox() {
        // Obtener la lista de tipos de mascota desde tu servicio o repositorio
        List<TipoMascota> tiposMascota = tipoMascotaServicio.listarTiposMascota(); // Ajusta esto según tu lógica de negocio

//        // Configurar el ComboBox con la lista de tipos de mascota
//        cliente_combo_especie_mascota.getItems().setAll(tiposMascota);
        // Obtener solo los nombres de los tipos de mascota
        List<String> nombresTiposMascota = tiposMascota.stream()
                .map(TipoMascota::getNombreTipo)
                .collect(Collectors.toList());

        // Configurar el ComboBox con la lista de nombres de tipos de mascota
        cliente_combo_especie_mascota.getItems().setAll(nombresTiposMascota);

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

    public void agregarCliente() {
        String apellido = cliente_text_apellido.getText();
        String documento = cliente_text_documento.getText();

        if (apellido.isEmpty() || documento.isEmpty()) {
            String mensaje = apellido.isEmpty() ? "Debe proporcionar un Apellido" : "Debe proporcionar un Documento";
            mostrarMensaje("Error Validación", mensaje);
            cliente_text_apellido.requestFocus();
            return;
        }

        Cliente cliente = new Cliente();
        recolectarDatosFormulario(cliente);

        Cliente clienteExistente = vereficarDocumento(cliente);
        if (clienteExistente != null && clienteExistente.getActivo()) {
            mostrarMensaje("Información", "El número de Documento ya se encuentra registrado");
            limpiarFormulario();
            listarCliente();
        } else if (clienteExistente != null && !clienteExistente.getActivo()) {
            // Preguntar al usuario si desea activar el cliente existente
            if (confirmarActivacionCliente()) {
                // Activar el cliente existente y guardar cambios
                clienteExistente.setActivo(true);
                clienteServicio.guardarCliente(clienteExistente);
                mostrarMensaje("Información", "Cliente activado");
                limpiarFormulario();
                listarCliente();
            }
        } else {
            cliente.setIdCliente(null);
            clienteServicio.guardarCliente(cliente);
            mostrarMensaje("Información", "Cliente agregado");
            limpiarFormulario();
            listarCliente();
        }
    }

    private boolean confirmarActivacionCliente() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar Activación");
        alert.setHeaderText("El cliente ya existe pero está inactivo. ¿Desea activarlo?");
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

    public void agregarMascota() {
        if (idClienteInterno == null) {
            mostrarMensaje("Informacion", "Debe seleccionar un Cliente");
            return;
        }
        //Cliente cliente = cliente_tabla.getSelectionModel().getSelectedItem();
        if (cliente_text_alias_mascota.getText().isEmpty()) {
            mostrarMensaje("Error Validacion", "Debes de proporcionar un Alias");
            cliente_text_alias_mascota.requestFocus();
            return;
        } else {
            var mascota = new Mascota();
            recolectarDatosFormularioMascota(mascota);
            mascota.setIdMascota(null);
            mascotaServicio.guardarMascota(mascota);
            mostrarMensaje("Informacion", "Mascota agregada");
            limpiarFormulario();
            limpiarFormularioMascota();
            listarMoscota(idClienteInterno);

//            // Utiliza el método agregarMascota de la entidad Cliente
//
//            var mascota = new Mascota();
//            recolectarDatosFormularioMascota(mascota);
//            mascota.setIdMascota(null);
//            cliente.agregarMascota(mascota);
//            clienteServicio.guardarCliente(cliente);
//            mostrarMensaje("Informacion", "Mascota agregada");
//            limpiarFormularioMascota();
//            listarMoscota(idClienteInterno);
        }
    }

    private void recolectarDatosFormulario(Cliente cliente) {
        // if (idClienteInterno != null) {
        cliente.setIdCliente(idClienteInterno);
        cliente.setApellido(cliente_text_apellido.getText());
        cliente.setNombre(cliente_text_nombre.getText());
        cliente.setDocumento(cliente_text_documento.getText());
        cliente.setDireccion(cliente_text_direccion.getText());
        cliente.setEmail(cliente_text_email.getText());
        cliente.setTelefono(cliente_text_telefono.getText());
        cliente.setAlternativa(cliente_text_contacto.getText());
        cliente.setActivo(true);
        //  }

    }

    private void recolectarDatosFormularioMascota(Mascota mascota) {
        var cliente = new Cliente();
        recolectarDatosFormulario(cliente);
        if (idClienteInterno != null) {
            mascota.setCliente(cliente);
            mascota.setAlias(cliente_text_alias_mascota.getText());
            // Obtener el nombre del tipo de mascota desde el ComboBox
            String nombreTipoMascota = cliente_combo_especie_mascota.getValue();

            // Obtener la instancia de TipoMascota correspondiente al nombre
            TipoMascota tipoMascota = tipoMascotaServicio.obtenerTipoMascotaPorNombre(nombreTipoMascota);

            // Configurar el TipoMascota en la mascota
            mascota.setTipoMascota(tipoMascota);
            mascota.setActivo(true);
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
        // Limpiar la tabla cliente_tabla
        cliente_tabla.getItems().clear();
        cliente_text_alias_mascota.clear();
        cliente_combo_especie_mascota.getSelectionModel().clearSelection();
        // Limpiar la tabla cliente_tabla_Mascota
        cliente_tabla_Mascota.getItems().clear();
        initialize();
    }

    public void limpiarFormularioMascota() {
        //idClienteInterno = null;
        cliente_text_alias_mascota.clear();
        cliente_combo_especie_mascota.getSelectionModel().clearSelection();
        // Limpiar la tabla cliente_tabla_Mascota
        //cliente_tabla_Mascota.getItems().clear();
    }

    public void modificarCliente() {
        if (idClienteInterno == null) {
            mostrarMensaje("Informacion", "Debe seleccionar un Cliente");
            return;
        }
        if (cliente_text_apellido.getText().isEmpty()) {
            mostrarMensaje("Error Validacion", "Debe proporcionar un Apellido");
            cliente_text_apellido.requestFocus();
            return;
        }
        var cliente = new Cliente();
        recolectarDatosFormulario(cliente);
        clienteServicio.guardarCliente(cliente);
        mostrarMensaje("Informacion", "Cliente modificado");
        limpiarFormulario();
        listarCliente();
    }

    private Cliente vereficarDocumento(Cliente cliente) {

        return clienteServicio.buscarClientePorDocumento(cliente.getDocumento());

    }

    public void eliminarCliente() {
        var cliente = cliente_tabla.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            //logger.info("Registro a eliminar: " + cliente.toString());
            clienteServicio.eliminarCliente(cliente);
            mostrarMensaje("Informacion", "Cliente eliminado:" + cliente.getIdCliente());
            limpiarFormulario();
            listarCliente();
        } else {
            mostrarMensaje("Error", "No se ha seleccionado ningun Cliente");
        }
    }
}
