package atrumblack.clinicaveterinaria.servicio;

import atrumblack.clinicaveterinaria.modelo.Cliente;

import java.util.List;

public interface IClienteServicio {

    public void guardarCliente(Cliente cliente);
    public List<Cliente> listarClientes();
    public List<Cliente> buscarClientesPorApellido(String apellido);
    public Cliente buscarClientePorDocumento(String documento);
    public void eliminarCliente(Cliente cliente);


    Cliente obtenerClientePorId(Integer idClienteInterno);
}
