
package com.senac.autoMecanicaSaoGeraldo.service;

import com.senac.autoMecanicaSaoGeraldo.data.ClienteRepository;
import com.senac.autoMecanicaSaoGeraldo.model.Cliente;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;
     
    public Cliente adicionarCliente(Cliente cliente) {
        cliente.setId(null);
        clienteRepository.save(cliente);
        return cliente;
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Integer id) {
        return clienteRepository.findById(id).orElseThrow();
    }

    public Cliente atualizarCliente(Integer id, Cliente cliente) {
        Cliente clienteEncontrado = buscarClientePorId(id);
        clienteEncontrado.setNome(cliente.getNome());
        clienteEncontrado.setCpf(cliente.getCpf());
        clienteEncontrado.setTelefone(cliente.getTelefone());
        clienteEncontrado.setModelo(cliente.getModelo());
        clienteEncontrado.setPlaca(cliente.getPlaca());
        clienteRepository.save(clienteEncontrado);
        return clienteEncontrado;
    }

    public void excluirCliente(Integer id) {
        Cliente clienteEncontrado = buscarClientePorId(id);
        clienteRepository.deleteById(clienteEncontrado.getId());
    }
}
