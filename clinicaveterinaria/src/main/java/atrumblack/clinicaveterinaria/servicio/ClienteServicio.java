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
    public void borrarCliente(Integer dni) {

    }

    @Override
    public void restablecerCliente(Integer dni) {

    }


//    @Override
//    public void bajaLogica(Integer dni) {
//        Optional<Cliente> clienteOptional = clienteRepositorio.findByDni(dni);
//        clienteOptional.ifPresent(cliente -> {
//            if (cliente.getEstado()) { // Si el cliente está activo
//                cliente.setEstado(false);
//                clienteRepositorio.save(cliente);
//            }
//        });
//    }

//    @Override
//    public void altaLogica(Integer dni) {
//        Optional<Cliente> clienteOptional = clienteRepositorio.findByDni(dni);
//        clienteOptional.ifPresent(cliente -> {
//            if (!cliente.getEstado()) { // Si el cliente está inactivo
//                cliente.setEstado(true);
//                clienteRepositorio.save(cliente);
//            }
//        });
//    }
//
//    @Override
//    public Cliente buscarListaClientexDni(Integer dni) {
//
//
//        Optional<Cliente> clienteOptional = clienteRepositorio.findByDniAndEstadoIsTrue(dni);
//        return clienteOptional.orElse(null);
//    }
//
//    @Override
//    public Cliente obtenerClientexId(Integer idCliente) {
//        return clienteRepositorio.findById(idCliente).orElse(null);
//    }
//
    @Override
    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
        //return clienteRepositorio.findAll();
    }
    @Override
    public List<Cliente> buscarClientesPorApellido(String apellido) {
        return clienteRepositorio.findByApellido(apellido);
    }

    @Override
    public Cliente buscarClientePorDocumento(String documento) {
        return clienteRepositorio.findByDocumento(documento);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteRepositorio.delete(cliente);
    }
//
//    @Override
//    public List<Cliente> obtenerClientesConMascota() {
//        return clienteRepositorio.obtenerClientesConMascota();
//    }
//
//    @Override
//    public List<Cliente> obtenerClientesSinMascota() {
//        return clienteRepositorio.obtenerClientesSinMascota();
//    }
//
//    @Override
//    public List<Cliente> listarClientePorEstado(Boolean estado) {
//        return clienteRepositorio.findByEstado(estado);
//    }
}
