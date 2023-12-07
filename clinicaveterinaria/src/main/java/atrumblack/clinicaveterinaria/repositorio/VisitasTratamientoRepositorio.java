package atrumblack.clinicaveterinaria.repositorio;

import atrumblack.clinicaveterinaria.modelo.Tratamiento;
import atrumblack.clinicaveterinaria.modelo.VisitasTratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VisitasTratamientoRepositorio extends JpaRepository<VisitasTratamiento, Integer> {
    //    List<Integer> findMascotasIdsConTratamiento(Integer idTratamiento);
    @Query("SELECT vt.idMascota FROM VisitasTratamiento vt WHERE vt.idTratamiento IS NOT NULL")
    List<Integer> findMascotasIdsConTratamiento(Integer idTratamiento);
}
