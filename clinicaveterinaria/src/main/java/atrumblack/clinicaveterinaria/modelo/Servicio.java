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
@Table(name="servicio")
public class Servicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Integer idServicio;

    @Column(name = "nombre_servicio", nullable = false, length = 50)
    private String nombreServicio;

    @Column(name = "descripcion", nullable = true, length = 200)
    private String descripcion;

    @Column(name = "importe_servicio", nullable = true, precision = 5, scale = 2)
    private BigDecimal importeServicio;

    @Column(name = "duracion", nullable = true)
    private Integer duracion;

    @Column(name = "categoria", nullable = true, length = 50)
    private String categoria;

    @Column(name = "descuento", nullable = true, precision = 5, scale = 2)
    private BigDecimal descuento;

    @Column(name = "tipo", nullable = true, length = 50)
    private String tipo;

    @Column(name = "activo", nullable = false)
    private Boolean activo; // Estado del Servicio (activo o inactivo)
}
