package atrumblack.clinicaveterinaria.servicio;

import atrumblack.clinicaveterinaria.modelo.TipoMascota;

import java.util.List;

public interface ITipoMascotaServicio {
    public List<TipoMascota> listarTiposMascota();
    public TipoMascota obtenerTipoMascotaPorNombre(String nombreTipo);
}
