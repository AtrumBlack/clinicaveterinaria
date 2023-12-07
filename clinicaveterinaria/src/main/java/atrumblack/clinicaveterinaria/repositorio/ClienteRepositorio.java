package atrumblack.clinicaveterinaria.repositorio;

import atrumblack.clinicaveterinaria.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByDni(Integer dni);

    List<Cliente> findByEstado(Boolean estado);

    Optional<Cliente> findByDniAndEstado(Integer dni, Boolean estado);

    Optional<Cliente> findByDniAndEstadoIsTrue(Integer dni);

    List<Cliente> findByEstadoIsTrue();

    @Query("SELECT DISTINCT c FROM Cliente c WHERE c.estado = true AND EXISTS (SELECT 1 FROM Mascota m WHERE m.idCliente = c)")
    List<Cliente> obtenerClientesConMascota();

//    @Query("SELECT DISTINCT c FROM Cliente c WHERE c.estado = true AND NOT EXISTS (SELECT m.cliente FROM Mascota m WHERE m.cliente IS c)")
//    List<Cliente> obtenerClientesSinMascota();
}
