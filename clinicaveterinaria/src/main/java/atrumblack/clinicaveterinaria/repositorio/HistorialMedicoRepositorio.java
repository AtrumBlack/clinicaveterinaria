package atrumblack.clinicaveterinaria.repositorio;

import atrumblack.clinicaveterinaria.modelo.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistorialMedicoRepositorio extends JpaRepository<HistoriaClinica,Integer> {
}
