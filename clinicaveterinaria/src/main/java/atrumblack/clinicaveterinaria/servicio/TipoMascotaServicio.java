package atrumblack.clinicaveterinaria.servicio;

import atrumblack.clinicaveterinaria.modelo.TipoMascota;
import atrumblack.clinicaveterinaria.repositorio.TipoMascotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoMascotaServicio implements ITipoMascotaServicio{
    @Autowired
    private TipoMascotaRepositorio tipoMascotaRepositorio;
    @Override
    public List<TipoMascota> listarTiposMascota() {
        return tipoMascotaRepositorio.findAll();
    }

    @Override
    public TipoMascota obtenerTipoMascotaPorNombre(String nombreTipo) {
        // Aquí deberías implementar la lógica para buscar el TipoMascota por su nombre en tu repositorio o base de datos
        Optional<TipoMascota> tipoMascotaOptional = tipoMascotaRepositorio.findByNombreTipo(nombreTipo);

        // Si se encuentra, devuelve la instancia de TipoMascota
        return tipoMascotaOptional.orElse(null);
    }


}
