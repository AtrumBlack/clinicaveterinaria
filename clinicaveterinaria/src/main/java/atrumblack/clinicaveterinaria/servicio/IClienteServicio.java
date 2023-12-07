package atrumblack.clinicaveterinaria.servicio;

import atrumblack.clinicaveterinaria.modelo.Cliente;

import java.util.List;

public interface IClienteServicio {

    public void guardarCliente(Cliente cliente);

    public void bajaLogica(Integer dni);

    public void altaLogica(Integer dni);

//    public Cliente buscarListaClientexDni(Integer dni);
//    public Cliente obtenerClientexId(Integer idCliente);
//
//    public List<Cliente> listarClientes();
//    public List<Cliente> obtenerClientesConMascota();
//    public List<Cliente> obtenerClientesSinMascota();
//    public List<Cliente> listarClientePorEstado(Boolean estado);



}
