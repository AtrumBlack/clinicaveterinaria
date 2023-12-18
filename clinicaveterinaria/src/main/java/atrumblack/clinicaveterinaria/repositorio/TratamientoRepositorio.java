package atrumblack.clinicaveterinaria.repositorio;

import atrumblack.clinicaveterinaria.modelo.Cliente;
import atrumblack.clinicaveterinaria.modelo.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TratamientoRepositorio extends JpaRepository<Tratamiento,Integer> {
}
