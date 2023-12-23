package atrumblack.clinicaveterinaria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "vacuna")
public class Vacuna implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacuna")
    private Integer idVacuna;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre; // Nombre de la vacuna

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_aplicacion", nullable = true)
    private LocalDate fechaAplicacion; // Fecha en que se aplicó la vacuna

    @Column(name = "observaciones", nullable = true, length = 50)
    private String observaciones;

    // Relación muchos a uno con HistorialClinico
    @ManyToOne
    @JoinColumn(name = "id_historia_clinica")
    private HistoriaClinica historiaClinica;
}
