package atrumblack.clinicaveterinaria.servicio;

import atrumblack.clinicaveterinaria.modelo.Cliente;
import atrumblack.clinicaveterinaria.repositorio.ClienteRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio implements IClienteServicio{
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);

    }
    @Override
    public List<Cliente> listarClientes() {

        return clienteRepositorio.findByActivoTrue();
    }
    @Override
    public List<Cliente> buscarClientesPorApellido(String apellido) {
        return clienteRepositorio.findByActivoTrueAndApellido(apellido);
    }

    @Override
    public Cliente buscarClientePorDocumento(String documento) {
        return clienteRepositorio.findByDocumento(documento);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {

        clienteRepositorio.eliminarCliente(cliente.getIdCliente());
    }

    @Override
    public Cliente obtenerClientePorId(Integer idClienteInterno) {
        return null;
    }

}
