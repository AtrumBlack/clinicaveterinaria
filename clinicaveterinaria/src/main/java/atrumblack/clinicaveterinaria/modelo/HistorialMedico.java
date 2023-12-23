package atrumblack.clinicaveterinaria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "historial_medico")
public class HistorialMedico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Integer idHistorial;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;

    @OneToMany(mappedBy = "historialMedico", cascade = CascadeType.ALL)
    private List<VisitasTratamiento> visitasTratamientos;

    // Otros campos relevantes para el historial médico

    // Método para agregar una visita con tratamiento al historial médico
    public void agregarVisitasTratamiento(VisitasTratamiento visitasTratamiento) {
        this.visitasTratamientos.add(visitasTratamiento);
        visitasTratamiento.setHistorialMedico(this);

    }
}
