package atrumblack.clinicaveterinaria.servicio;

import atrumblack.clinicaveterinaria.modelo.Visita;
import atrumblack.clinicaveterinaria.repositorio.VisitaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VisitaServicio implements IVisitaServicio {
//    @Autowired
//    private VisitaRepositorio visitaRepositorio;
//
//    @Override
//    public void guardarVisita(Visita visita) {
//        visitaRepositorio.save(visita);
//    }
//
////    @Override
////    public Double avgPesoM(Integer idMascota) {
////        return visitaRepositorio.mediaAvgPesoM(idMascota);
////    }
//
////    @Override
////    public List<Visita> listarMascotasPorVisitas(Integer idMascotas) {
////        return visitaRepositorio.findByIdMascota_IdMascota(idMascotas);
////    }
//
////    @Override
////    public List<Visita> listarVisitasPorCliente(Integer idCliente) {
////        return visitaRepositorio.findByIdMascota_IdCliente_IdCliente(idCliente);
////    }
//
////    @Override
////    public Map<Visita, String> obtenerVisitasDeCliente(Integer idCliente) {
////        Map<Visita, String> visitasConAlias = new LinkedHashMap<>();
////
////        // Utilizando Spring Data JPA para realizar la consulta
////        List<Object[]> resultados = visitaRepositorio.obtenerVisitasConAlias(idCliente);
////
////        for (Object[] resultado : resultados) {
////            Visita visita = obtenerVisitaDesdeResultado(resultado);
////            String nombreMascota = (String) resultado[5]; // Suponiendo que el alias está en la posición 5
////            visitasConAlias.put(visita, nombreMascota);
////        }
////
////        return visitasConAlias;
////    }
//    public Visita obtenerVisitaDesdeResultado(Object[] resultado) {
//        Visita visita = new Visita();
//
//        // Asignar valores desde el array de resultados a los atributos de la visita
//        visita.setIdVisita((Integer) resultado[0]);
//        visita.setFechaVisita((LocalDate) resultado[1]);
//        visita.setDetallesSintoma((String) resultado[2]);
//        visita.setPesoActual((BigDecimal) resultado[3]);
//       // visita.setImporteVisita((Double) resultado[4]);
//
//        // Puedes necesitar asignar valores de otras columnas dependiendo de tu modelo de datos
//
//        return visita;
//    }
//    @Override
//    public Visita obtenerVisitaPorId(Integer idVisita) {
//        return visitaRepositorio.findById(idVisita).orElse(null);
//    }
//
////    // Método para obtener el importe total de una visita
////    public BigDecimal obtenerImporteTotalDeVisita(Integer idVisita) {
////        Visita visita = visitaRepositorio.findById(idVisita).orElse(null);
////
////        if (visita != null) {
////            return visita.getImporteTotal();
////        } else {
////            return BigDecimal.ZERO;
////        }
////    }
}
