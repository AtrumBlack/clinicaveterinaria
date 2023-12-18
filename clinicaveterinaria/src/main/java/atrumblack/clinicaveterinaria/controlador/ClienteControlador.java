package atrumblack.clinicaveterinaria.controlador;

import atrumblack.clinicaveterinaria.modelo.Cliente;
import atrumblack.clinicaveterinaria.servicio.ClienteServicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;
@Component
public class ClienteControlador implements Initializable {
    private static final Logger logger= LoggerFactory.getLogger(ClienteControlador.class);
    @Autowired
    private ClienteServicio clienteServicio;
    @FXML
    private TableView<Cliente> clienteTabla;
    @FXML
    private TableColumn<Cliente,Integer> idClienteColumna;
    @FXML
    private TableColumn<Cliente,String> apellidoColumna;
    @FXML
    private TableColumn<Cliente,String> nombreColumna;
    @FXML
    private TableColumn<Cliente,String> documentoColumna;
    @FXML
    private final ObservableList<Cliente> clienteList= FXCollections.observableArrayList();

    @FXML
    private TextField documentoTexto;
    @FXML
    private TextField apellidoTexto;
    @FXML
    private TextField nombreTexto;
    @FXML
    private TextField direccionTexto;
    @FXML
    private TextField telefonoTexto;
    @FXML
    private TextField emailTexto;
    @FXML
    private TextField contactoTexto;

    private Integer idTareaInterno;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void cargarClienteFormulario(MouseEvent mouseEvent) {
    }

    public void agregarCliente(ActionEvent actionEvent) {
    }
    public void modificarCliente(ActionEvent actionEvent) {
    }

    public void limpiarFormulario(ActionEvent actionEvent) {
    }


    public void eliminarCliente(ActionEvent actionEvent) {
    }

    public void agregarMascota(ActionEvent actionEvent) {
    }
}
