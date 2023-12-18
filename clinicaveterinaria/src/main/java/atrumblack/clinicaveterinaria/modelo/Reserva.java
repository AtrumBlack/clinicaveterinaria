package atrumblack.clinicaveterinaria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="reserva")
public class Reserva implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;

    @Temporal(TemporalType.TIME)
    @Column(name = "hora_reserva", nullable = false)
    private LocalTime horarioReserva;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_reserva", nullable = false)
    private LocalDate fechaReserva;

    @Column(name = "activo", nullable = false)
    private Boolean activo; // Estado de la mascota (activo o inactivo)
}
