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
@Table(name = "factura_item")
public class FacturaItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura_item")
    private Integer idFacturaItem;
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precioUnitario", nullable = false, precision = 8, scale = 2)
    private BigDecimal precioUnitario;
    @Column(name = "subtotal", nullable = false, precision = 8, scale = 2)
    private BigDecimal subtotal;
}
