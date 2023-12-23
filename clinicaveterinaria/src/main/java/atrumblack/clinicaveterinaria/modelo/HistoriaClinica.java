package atrumblack.clinicaveterinaria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "historia_clinica")
public class HistoriaClinica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Integer idHistorial;

    // Relación uno a uno con Mascota
    @OneToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_registro", nullable = true)
   private LocalDate fechaRegistro;

    @Column(name = "enfermedades", nullable = true, length = 50)
    private String enfermedades;

    @Column(name = "alergias", nullable = true, length = 50)
    private String alergias;

    @Column(name = "tratamientos", nullable = true, length = 50)
    private String tratamientos;

    @Column(name = "cirugias", nullable = true, length = 50)
    private String cirugias;

//    @OneToMany(mappedBy = "historialMedico", cascade = CascadeType.ALL)
//    private List<VisitasTratamiento> visitasTratamientos;

    // Otros campos relevantes para el historial médico

//    // Método para agregar una visita con tratamiento al historial médico
//    public void agregarVisitasTratamiento(VisitasTratamiento visitasTratamiento) {
//        this.visitasTratamientos.add(visitasTratamiento);
//        visitasTratamiento.setHistorialMedico(this);
//
//    }
}
