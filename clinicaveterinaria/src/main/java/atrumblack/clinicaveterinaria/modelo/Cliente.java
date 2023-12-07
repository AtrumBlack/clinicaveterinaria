package atrumblack.clinicaveterinaria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Atributos privados que representan las propiedades de un cliente
    private Integer idCliente; // Identificador único del cliente
    private Integer dni; // Número de documento de identidad del cliente
    private String apellido; // Apellido del cliente
    private String nombre; // Nombre del cliente
    private String direccion; // Dirección del cliente
    private String telefono; // Número de teléfono del cliente
    private String contactoNombre; // Nombre del contacto de emergencia del cliente
    private String contactoTelefono; // Número de teléfono del contacto de emergencia del cliente
    private Boolean estado; // Estado del cliente (activo o inactivo)
    private String email; // Dirección de correo electrónico del cliente
}
