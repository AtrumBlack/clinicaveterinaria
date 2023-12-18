package atrumblack.clinicaveterinaria.controlador;

import javafx.scene.layout.AnchorPane;

public abstract class FormularioControlador {

    // Puedes agregar métodos comunes aquí si es necesario

    // Por ejemplo, un método para cambiar la visibilidad del formulario
    public void mostrarFormulario(AnchorPane formulario) {
        formulario.setVisible(true);
    }

    public void ocultarFormulario(AnchorPane formulario) {
        formulario.setVisible(false);
    }
}
