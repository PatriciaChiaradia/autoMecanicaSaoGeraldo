
package com.senac.autoMecanicaSaoGeraldo.service;

import com.senac.autoMecanicaSaoGeraldo.model.Cliente;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private final List<Cliente> listaClientes = new ArrayList<>();
    
     
    public void adicionarCliente(Cliente cliente) {
        cliente.setId(listaClientes.size() + 1);
        listaClientes.add(cliente);
    }

    public List<Cliente> listarClientes() {
        return listaClientes;
    }

    public Cliente buscarClientePorId(int id) {
        return listaClientes.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void atualizarCliente(Cliente clienteAtualizado) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == clienteAtualizado.getId()) {
                cliente.setNome(clienteAtualizado.getNome());
                cliente.setCpf(clienteAtualizado.getCpf());
                cliente.setTelefone(clienteAtualizado.getTelefone());
                cliente.setModelo(clienteAtualizado.getModelo());
                cliente.setPlaca(clienteAtualizado.getPlaca());
                break;
            }
        }
    }

    public void excluirCliente(int id) {
        listaClientes.removeIf(cliente -> cliente.getId() == id);
    }
}
