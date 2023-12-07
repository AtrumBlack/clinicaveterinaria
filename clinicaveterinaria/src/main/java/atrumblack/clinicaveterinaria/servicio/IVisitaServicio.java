package atrumblack.clinicaveterinaria.servicio;

import atrumblack.clinicaveterinaria.modelo.Visita;

import java.util.List;
import java.util.Map;

public interface IVisitaServicio {
    public void guardarVisita(Visita visita);
    //public Double avgPesoM(Integer idMascota);
    public List<Visita> listarMascotasPorVisitas(Integer idMascotas);
    //public List<Visita> listarVisitasPorCliente(Integer idCliente);
    //public Map<Visita, String> obtenerVisitasDeCliente(Integer idCliente);
    public Visita obtenerVisitaPorId(Integer idVisita);

}
