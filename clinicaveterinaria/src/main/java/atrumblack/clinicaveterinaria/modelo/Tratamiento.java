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
@Table(name="tratamientos")
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Atributos privados que representan las propiedades de un tratamiento
    private Integer idTratamiento; // Identificador único del tratamiento
    private String tipo; // Tipo de tratamiento (por ejemplo, cirugía, vacunación, etc.)
    private String descripcion; // Descripción detallada del tratamiento
    private Double importe; // Costo del tratamiento
    private Boolean estado; // Estado del tratamiento (activo o inactivo)
}
