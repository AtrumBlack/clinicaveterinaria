package atrumblack.clinicaveterinaria.servicio;

import atrumblack.clinicaveterinaria.modelo.Mascota;
import atrumblack.clinicaveterinaria.modelo.Tratamiento;
import atrumblack.clinicaveterinaria.repositorio.MascotaRepositorio;
import atrumblack.clinicaveterinaria.repositorio.TratamientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TratamientoServicio implements ITratamientoServicio{

    @Autowired
    private TratamientoRepositorio tratamientoRepositorio;

    @Override
    public void guardarTratamiento(Tratamiento tratamiento) {
        tratamientoRepositorio.save(tratamiento);
    }

    @Override
    public List<Tratamiento> listarTratamientos() {
        return tratamientoRepositorio.findByActivoTrue();
    }

//    @Override
//    public void bajaLogica(Integer idTratamiento) {
//        Optional<Tratamiento> tratamientoOptional = tratamientoRepositorio.findById(idTratamiento);
//        tratamientoOptional.ifPresent(tratamiento -> {
//            tratamiento.setEstado(false);
//            tratamientoRepositorio.save(tratamiento);
//        });
//    }

//    @Override
//    public void altaLogica(Integer idTratamiento) {
//        Optional<Tratamiento> tratamientoOptional = tratamientoRepositorio.findById(idTratamiento);
//        tratamientoOptional.ifPresent(tratamiento -> {
//            tratamiento.setEstado(true);
//            tratamientoRepositorio.save(tratamiento);
//        });
//    }
//
//    @Override
//    public Tratamiento buscarListaTratamientoxId(Integer idTratamiento) {
//        return tratamientoRepositorio.findById(idTratamiento).orElse(null);
//    }
//
//    @Override
//    public List<Tratamiento> listarTratamientoPorEstado(Boolean estado) {
//        return tratamientoRepositorio.findByEstado(estado);
//    }
//
//    @Override
//    public long contarTotalRegistros() {
//        return tratamientoRepositorio.count();
//    }


}
