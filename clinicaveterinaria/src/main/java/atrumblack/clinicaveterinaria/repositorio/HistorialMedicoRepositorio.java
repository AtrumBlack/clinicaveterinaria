package atrumblack.clinicaveterinaria.repositorio;

import atrumblack.clinicaveterinaria.modelo.HistorialMedico;
import atrumblack.clinicaveterinaria.modelo.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistorialMedicoRepositorio extends JpaRepository<HistorialMedico,Integer> {
}
