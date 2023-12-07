package atrumblack.clinicaveterinaria.repositorio;

import atrumblack.clinicaveterinaria.modelo.Tratamiento;
import atrumblack.clinicaveterinaria.modelo.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VisitaRepositorio extends JpaRepository<Visita,Integer> {
   // Double mediaAvgPesoM(Integer idMascota);

    // Este método te permitirá buscar todas las visitas por el ID de una mascota
    List<Visita> findByIdMascota_IdMascota(Integer idMascota);

    List<Visita> findByIdMascota_IdCliente_IdCliente(Integer idCliente);
//    @Query("SELECT v.idVisita, v.fechaV, v.detallesSintomas, v.pesoActual, v.importe, "
//            + "m.alias AS nombreMascota, m.sexo, m.especie, m.raza, m.colorDePelo, m.fechaNac "
//            + "FROM Visita v "
//            + "JOIN VistasTratamiento tr ON v.idVisita = tr.idVisita "
//            + "JOIN Mascota m ON tr.idMascota = m.idMascota "
//            + "JOIN Cliente c ON m.idCliente = c.idCliente "
//            + "WHERE c.idCliente = ?1 "
//            + "GROUP BY v.idVisita "
//            + "ORDER BY v.fechaV ASC")
//    List<Object[]> obtenerVisitasConAlias(Integer idCliente);
    //List<Visita> findByCliente_IdCliente(Integer idCliente);
}
