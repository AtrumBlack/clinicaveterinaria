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
@Table(name = "factura")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Integer idFactura;

    @ManyToOne
    @JoinColumn(name = "id_visita")
    private Visita visita;

    @Column(name = "importe_tratamiento", nullable = false, precision = 8, scale = 2)
    private BigDecimal importeTratamiento;

    @Column(name = "importe_total", nullable = false, precision = 8, scale = 2)
    private BigDecimal importeTotal;

    @Column(name = "detalle_servicio", nullable = false, length = 200)
    private String detalleServicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    @Column(name = "facturado_visita", nullable = false)
    private Boolean facturadoVisita;

    @Column(name = "facturado_tratamiento", nullable = false)
    private Boolean facturadoTratamiento;
}
