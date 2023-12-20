package atrumblack.clinicaveterinaria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "cliente")
//@SQLDelete(sql = "UPDATE cliente SET activo = false WHERE id_cliente = ?")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente; // Identificador único del cliente

    @Column(name = "documento", nullable = false, length = 20)
    private String documento;

    @Column(name = "apellido", nullable = false, length = 75)
    private String apellido;

    @Column(name = "nombre", nullable = true, length = 75)
    private String nombre;

    @Column(name = "direccion", nullable = true, length = 100)
    private String direccion;

    @Column(name = "telefono", nullable = true, length = 20)
    private String telefono;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @Column(name = "email", nullable = true, length = 50)
    private String email; // Dirección de correo electrónico del cliente

    @Column(name = "alternativa", nullable = true, length = 100)
    private String alternativa; // Nombre del contacto de emergencia del cliente

//    @OneToMany(mappedBy = "visita", cascade = CascadeType.ALL)
//    private List<Vacuna> vacunas = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Mascota> mascotas;

    // Método para agregar una mascota a la lista bidireccional
    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
        mascota.setCliente(this);
    }
}
