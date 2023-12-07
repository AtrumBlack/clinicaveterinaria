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
@Table(name="visitas")
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVisita;

    @ManyToOne
    @JoinColumn(name = "idMascota") // Nombre de la columna de clave foránea en la tabla "visitas"
    private Mascota idMascota;
    private LocalDate fechaVisita;
    private String detallesSintoma;
    private Double pesoActual;
    private Double importeVisita;
}
