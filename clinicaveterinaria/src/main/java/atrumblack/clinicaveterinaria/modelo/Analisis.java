package atrumblack.clinicaveterinaria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "analisis")
public class Analisis implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_analisis")
    private Integer idAnalisis;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha", nullable = true)
    private LocalDate fecha; // Fecha de la desaparasitacion

    @Column(name = "resultado", nullable = true, length = 50)
    private String resultado;

    // Relación muchos a uno con HistorialClinico
    @ManyToOne
    @JoinColumn(name = "historial_clinico_id")
    private HistoriaClinica historiaClinica;
}
