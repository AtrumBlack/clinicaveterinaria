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
@Table(name = "visitastratamiento")
public class VisitasTratamiento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_visitas_tratamiento")
    // Atributos privados que representan las propiedades de un tratamiento realizado
    private Integer idVisitasTratamiento; // Identificador único del tratamiento realizado

    @ManyToOne
    @JoinColumn(name = "id_visita")
    private Visita visita; // Visita asociada al tratamiento realizado

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota; // Mascota asociada al tratamiento realizado

    @Column(name = "activo", nullable = false)
    private Boolean activo;
    @ManyToOne
    @JoinColumn(name = "id_tratamiento")
    private Tratamiento tratamiento; // Tratamiento asociado al tratamiento realizado

    @Column(name = "importe", nullable = true, precision = 5, scale = 2)
    private BigDecimal importe;// es el importe del tratamiento que se le hizo  a la mascota en la visita

    @ManyToOne
    @JoinColumn(name = "id_historial_medico")
    private HistoriaClinica historialMedico;

}
