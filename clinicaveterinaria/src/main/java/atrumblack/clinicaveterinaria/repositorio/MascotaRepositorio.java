package atrumblack.clinicaveterinaria.repositorio;

import atrumblack.clinicaveterinaria.modelo.Cliente;
import atrumblack.clinicaveterinaria.modelo.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MascotaRepositorio extends JpaRepository<Mascota,Integer> {

    List<Mascota> findByCliente_IdClienteAndActivoIsTrue(Integer idCliente);


//    Optional<Mascota> findByAliasAndIdCliente_IdClienteAndEstadoIsTrue(String alias, Integer idCliente);
//
//    List<Mascota> findByAliasAndEstadoIsTrue(String alias);
//
//    List<Mascota> findByEstadoIsTrue();
//
//    List<Mascota> findByEstado(Boolean activo);
//
//    List<Mascota> findByIdCliente_IdClienteAndEstadoIsTrue(Integer idCliente);
//
//    List<Mascota> findByIdMascotaInAndEstadoIsTrue(List<Integer> idsMascotasConTratamiento);
}
