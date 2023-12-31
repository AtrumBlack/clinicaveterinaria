package atrumblack.clinicaveterinaria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "mascota")
public class Mascota implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Integer idMascota; // Identificador único de la mascota

    @ManyToOne
    @JoinColumn(name = "id_cliente") // Nombre de la columna de clave foránea en la tabla "mascotas"
    private Cliente cliente; // Cliente al que pertenece la mascota

    @Column(name = "alias", nullable = false, length = 40)
    private String alias; // Alias o nombre de la mascota

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", nullable = false, length = 1)
    private Sexo sexo;

    @Column(name = "especie", nullable = false, length = 75)
    private String especie; // Especie de la mascota (por ejemplo, perro, gato, etc.)
    @Column(name = "raza", nullable = false, length = 75)
    private String raza; // Raza de la mascota

    @Column(name = "color_de_pelo", nullable = false, length = 50)
    private String colorDePelo; // Color del pelaje de la mascota

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento; // Fecha de nacimiento de la mascota

    @Column(name = "peso_promedio", nullable = false, precision = 5, scale = 2)
    private BigDecimal pesoPromedio;

    @Column(name = "peso_actual", nullable = false, precision = 5, scale = 2)
    private BigDecimal pesoActual;


    @Column(name = "activo", nullable = false)
    private Boolean activo; // Estado de la mascota (activo o inactivo)

    public enum Sexo {
        MACHO,
        HEMBRA,
        OTRO;
    }
}
