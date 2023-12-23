package atrumblack.clinicaveterinaria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "permiso")
public class Permiso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permiso")
    private Long idPermiso;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "descripcion", nullable = true, length = 50)
    private String descripcion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_expiracion", nullable = false)
    private LocalDate fechaExpiracion;

    // Puedes agregar más atributos según sea necesario, como estado (activo, expirado), detalles, etc.

    // Relación muchos a uno con ResponsablePermiso
    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private ResponsablePermiso responsable;
}
