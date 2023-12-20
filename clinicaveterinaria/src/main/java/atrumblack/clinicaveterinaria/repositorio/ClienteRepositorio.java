package atrumblack.clinicaveterinaria.repositorio;

import atrumblack.clinicaveterinaria.modelo.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByApellido(String apellido);

    Cliente findByDocumento(String documento);

    List<Cliente> findByActivoTrueAndApellido(String apellido);

    Cliente findByActivoTrueAndDocumento(String documento);

    List<Cliente> findByActivoTrue();

    @Transactional
    default void eliminarCliente(Integer clienteId) {
        findById(clienteId).ifPresent(cliente -> {
            cliente.setActivo(false);
            save(cliente);
        });
    }

}
