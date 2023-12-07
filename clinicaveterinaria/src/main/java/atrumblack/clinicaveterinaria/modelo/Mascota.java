package atrumblack.clinicaveterinaria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "mascotas")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Atributos privados que representan las propiedades de una mascota
    private Integer idMascota; // Identificador único de la mascota

    private String alias; // Alias o nombre de la mascota
    private String sexo; // Género de la mascota (por ejemplo, macho o hembra)
    private String especie; // Especie de la mascota (por ejemplo, perro, gato, etc.)
    private String raza; // Raza de la mascota
    private String colorDePelo; // Color del pelaje de la mascota

    private LocalDate fechaNacimiento; // Fecha de nacimiento de la mascota
    private Double pesoMedia; // Peso medio esperado de la mascota
    private Double pesoActual; // Peso actual de la mascota

    @ManyToOne
    @JoinColumn(name = "idCliente") // Nombre de la columna de clave foránea en la tabla "mascotas"
    private Cliente idCliente; // Cliente al que pertenece la mascota

    private Boolean estado; // Estado de la mascota (activo o inactivo)
}
