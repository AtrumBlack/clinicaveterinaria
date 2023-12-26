package atrumblack.clinicaveterinaria.repositorio;

import atrumblack.clinicaveterinaria.modelo.Cliente;
import atrumblack.clinicaveterinaria.modelo.TipoMascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TipoMascotaRepositorio extends JpaRepository<TipoMascota, Integer> {
    List<TipoMascota> findAll();

    Optional<TipoMascota> findByNombreTipo(String nombreTipo);
}
