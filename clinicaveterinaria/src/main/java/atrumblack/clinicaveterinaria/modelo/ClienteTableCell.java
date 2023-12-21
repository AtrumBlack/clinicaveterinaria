package atrumblack.clinicaveterinaria.modelo;

import javafx.scene.control.TableCell;

public class ClienteTableCell extends TableCell<Mascota, Cliente> {

    @Override
    protected void updateItem(Cliente cliente, boolean empty) {
        super.updateItem(cliente, empty);
        if (empty || cliente == null) {
            setText(null);
        } else {
            // Aquí puedes usar el formato que prefieras, por ejemplo:
            setText(cliente.getApellido() + ", " + cliente.getNombre());
        }
    }
}
