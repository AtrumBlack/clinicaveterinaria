package atrumblack.clinicaveterinaria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="tratamiento")
public class Tratamiento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tratamiento")
    private Integer idTratamiento; // Identificador único del tratamiento

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo; // Tipo de tratamiento (por ejemplo, cirugía, vacunación, etc.)

    @ManyToOne
    @JoinColumn(name = "id_historial_medico")
    private HistorialMedico historialMedico;

    @Column(name = "descripcion", nullable = true, length = 200)
    private String descripcion; // Descripción detallada del tratamiento

    @Column(name = "importe_tratamiento", nullable = true, precision = 5, scale = 2)
    private BigDecimal importeTratamiento; // Costo del tratamiento

    @Column(name = "activo", nullable = false)
    private Boolean activo; // Estado de la mascota (activo o inactivo)
}
