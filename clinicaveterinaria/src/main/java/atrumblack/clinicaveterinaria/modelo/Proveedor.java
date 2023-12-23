package atrumblack.clinicaveterinaria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "proveedor")
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor; // Identificador único del c
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "tipo", nullable = true, length = 50)
    private String tipo; // Puedes usar esta propiedad para distinguir entre laboratorios, distribuidores, fabricantes, veterinarios externos, etc.
    @Column(name = "direccion", nullable = true, length = 50)
    private String direccion;
    @Column(name = "telefono", nullable = true, length = 50)
    private String telefono;
    @Column(name = "email", nullable = true, length = 50)
    private String email;
}
