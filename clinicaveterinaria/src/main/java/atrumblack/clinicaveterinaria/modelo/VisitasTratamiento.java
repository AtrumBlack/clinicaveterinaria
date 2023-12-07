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
@Table(name = "visitastratamientos")
public class VisitasTratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Atributos privados que representan las propiedades de un tratamiento realizado
    private Integer idVisitasTratamiento; // Identificador único del tratamiento realizado
    @ManyToOne
    @JoinColumn(name = "idVisita")
    private Visita idVisita; // Visita asociada al tratamiento realizado
    @ManyToOne
    @JoinColumn(name = "idMascota")
    private Mascota idMascota; // Mascota asociada al tratamiento realizado
    @ManyToOne
    @JoinColumn(name = "idTratamiento")
    private Tratamiento idTratamiento; // Tratamiento asociado al tratamiento realizado
    private Double importe; // Importe del tratamiento realizado


}
