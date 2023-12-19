package atrumblack.clinicaveterinaria.servicio;

import atrumblack.clinicaveterinaria.modelo.Cliente;

import java.util.List;

public interface IClienteServicio {

    public void guardarCliente(Cliente cliente);

    public void borrarCliente(Integer dni);//el metodo de borrado lo hace logico -- uso el sistema trigger

    public void restablecerCliente(Integer dni);

//    public Cliente buscarListaClientexDni(Integer dni);
//    public Cliente obtenerClientexId(Integer idCliente);
//
    public List<Cliente> listarClientes();
    public List<Cliente> buscarClientesPorApellido(String apellido);

    void eliminarCliente(Cliente cliente);

//    public List<Cliente> obtenerClientesConMascota();
//    public List<Cliente> obtenerClientesSinMascota();
//    public List<Cliente> listarClientePorEstado(Boolean estado);



}
