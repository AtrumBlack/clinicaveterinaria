package atrumblack.clinicaveterinaria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "responsable_permiso")
public class ResponsablePermiso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_responsable_permiso")
    private Long idResponsablePermiso;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo; // Puedes usar esta propiedad para distinguir entre personas físicas o jurídicas

    // Puedes agregar más atributos según sea necesario, como dirección, contacto, etc.

    // Relación uno a muchos con Permiso
    @OneToMany(mappedBy = "responsable", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Permiso> permisos = new ArrayList<>();
}
