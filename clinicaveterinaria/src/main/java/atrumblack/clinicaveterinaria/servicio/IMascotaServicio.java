package atrumblack.clinicaveterinaria.servicio;

import atrumblack.clinicaveterinaria.modelo.Mascota;

import java.util.List;

public interface IMascotaServicio {
    public void guardarMascota(Mascota mascota);

    public void bajaLogica(Integer dni);

    public void altaLogica(Integer dni);

    public long contarTotalRegistros();

    public Mascota obtenerMascotaPorId(Integer idMascota);

    public Mascota buscarListaMascotaxAliasIdCliente(String alias, Integer idCliente);

    public List<Mascota> buscarListaMascotaxAlias(String alias);

    public List<Mascota> listarMascotas();

    public List<Mascota> listarMascotasPorEstado(Boolean activo);

    public List<Mascota> listarMascotasXTipoTratamiento(Integer idTratamiento);

    public List<Mascota> listarMascotasxIdCliente(Integer idCliente);

    public Integer obtenerIdMascotaPorAlia(String aliaMascota, Integer idCliente);
}
