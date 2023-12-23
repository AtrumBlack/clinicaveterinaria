package atrumblack.clinicaveterinaria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "visita")
public class Visita implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_visita")
    private Integer idVisita;

    @ManyToOne
    @JoinColumn(name = "id_mascota") // Nombre de la columna de clave foránea en la tabla "visitas"
    //@Column(name = "id_mascota") // Nombre de la columna de clave foránea en la tabla "visitas"
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "id_historial_medico")
    private HistoriaClinica historialMedico;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_visita", nullable = false)
    private LocalDate fechaVisita;

    @Column(name = "detalles_sintoma", nullable = false, length = 100)
    private String detallesSintoma;

    @Column(name = "peso_actual", nullable = true, precision = 5, scale = 2)
    private BigDecimal pesoActual;

    @Column(name = "importe", nullable = true, precision = 5, scale = 2)
    private BigDecimal importe;// es el importe de la vissita, no puedo hacer de otra forma porque si hago el calculo con el importe del tratamiento
    //seguramente me encuengtro que el valor cambio

    // /////////////////////////////////////////////////////////////////////////////////
    //Ajusta la Clase Visita:
    @OneToMany(mappedBy = "visita", cascade = CascadeType.ALL)
    private List<VisitasTratamiento> visitasTratamientos;
    //
//    // Método para calcular el importe total
//    public BigDecimal getImporteTotal() {
//        return visitasTratamientos.stream()
//                .map(VisitasTratamiento::getImporte)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//    }
// /////////////////////////////////////////////////////////////////////////////////////
    @Column(name = "activo", nullable = false)
    private Boolean activo;

    // Método para agregar un tratamiento a la lista bidireccional
    public void agregarVisitasTratamiento(VisitasTratamiento visitasTratamiento) {
        this.visitasTratamientos.add(visitasTratamiento);
        visitasTratamiento.setVisita(this);
    }
}
