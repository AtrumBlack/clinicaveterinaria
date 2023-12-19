package atrumblack.clinicaveterinaria.servicio;

import atrumblack.clinicaveterinaria.modelo.Cliente;
import atrumblack.clinicaveterinaria.modelo.Mascota;
import atrumblack.clinicaveterinaria.modelo.Tratamiento;
import atrumblack.clinicaveterinaria.repositorio.ClienteRepositorio;
import atrumblack.clinicaveterinaria.repositorio.MascotaRepositorio;
import atrumblack.clinicaveterinaria.repositorio.TratamientoRepositorio;
import atrumblack.clinicaveterinaria.repositorio.VisitasTratamientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MascotaServicio implements IMascotaServicio{
    @Autowired
    private MascotaRepositorio mascotaRepositorio;
    @Autowired
    private VisitasTratamientoRepositorio visitasTratamientosRepositorio;

    @Override
    public void guardarMascota(Mascota mascota) {
        mascotaRepositorio.save(mascota);
    }

    @Override
    public List<Mascota> listarMascotaPorCliente(Integer idCliente) {
        return mascotaRepositorio.findByCliente_IdClienteAndActivoIsTrue(idCliente);
    }


//    @Override
//    public void bajaLogica(Integer id) {
//        Optional<Mascota> mascotaOptional = mascotaRepositorio.findById(id);
//        mascotaOptional.ifPresent(mascota -> {
//            if (mascota.getEstado()) { // Si la mascota está activa
//                mascota.setEstado(false);
//                mascotaRepositorio.save(mascota);
//            }
//        });
//    }

//    @Override
//    public void altaLogica(Integer id) {
//        Optional<Mascota> mascotaOptional = mascotaRepositorio.findById(id);
//        mascotaOptional.ifPresent(mascota -> {
//            if (!mascota.getEstado()) { // Si la mascota está inactiva
//                mascota.setEstado(true);
//                mascotaRepositorio.save(mascota);
//            }
//        });
//    }
//
//    @Override
//    public long  contarTotalRegistros() {
//        return mascotaRepositorio.count();
//    }
//
//    @Override
//    public Mascota obtenerMascotaPorId(Integer idMascota) {
//        return mascotaRepositorio.findById(idMascota).orElse(null);
//    }
//
//    @Override
//    public Mascota buscarListaMascotaxAliasIdCliente(String alias, Integer idCliente) {
//        Optional<Mascota> mascotaOptional = mascotaRepositorio.findByAliasAndIdCliente_IdClienteAndEstadoIsTrue(alias, idCliente);
//
//        // Puedes devolver la mascota si está presente, o lanzar una excepción o manejar el caso de otra manera si no está presente.
//        return mascotaOptional.orElse(null); // O podrías lanzar una excepción específica si lo prefieres
//    }
//
//    @Override
//    public List<Mascota> buscarListaMascotaxAlias(String alias) {
//        return mascotaRepositorio.findByAliasAndEstadoIsTrue(alias);
//    }
//
//    @Override
//    public List<Mascota> listarMascotas() {
//        return mascotaRepositorio.findByEstadoIsTrue();
//    }
//    @Override
//    public List<Mascota> listarMascotasPorEstado(Boolean activo) {
//        return mascotaRepositorio.findByEstado(activo);
//    }
//
//    @Override
//    public List<Mascota> listarMascotasXTipoTratamiento(Integer idTratamiento) {
//        List<Integer> idsMascotasConTratamiento = visitasTratamientosRepositorio.findMascotasIdsConTratamiento(idTratamiento);
//
//        // Ahora puedes buscar las mascotas por sus IDs
//        return mascotaRepositorio.findByIdMascotaInAndEstadoIsTrue(idsMascotasConTratamiento);
//
//    }
//
//    @Override
//    public List<Mascota> listarMascotasxIdCliente(Integer idCliente) {
//        return mascotaRepositorio.findByIdCliente_IdClienteAndEstadoIsTrue(idCliente);
//    }

//    @Override
//    public Integer obtenerIdMascotaPorAlia(String aliasMascota, Integer idCliente) {
//        Optional<Mascota> mascotaOptional = mascotaRepositorio.findByAliasAndIdCliente_IdClienteAndEstadoIsTrue(aliasMascota, idCliente);
//
//        return mascotaOptional.map(Mascota::getIdMascota).orElse(null);
//    }
}
