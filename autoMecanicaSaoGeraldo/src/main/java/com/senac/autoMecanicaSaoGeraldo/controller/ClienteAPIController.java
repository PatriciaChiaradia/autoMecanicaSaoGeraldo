package com.senac.autoMecanicaSaoGeraldo.controller;

import com.senac.autoMecanicaSaoGeraldo.model.Cliente;
import com.senac.autoMecanicaSaoGeraldo.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteAPIController {
    
    @Autowired
    private ClienteService clienteService;
    
    //método para cadastrar cliente
    @PostMapping("/cadastrar")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente){
        Cliente novoCliente = clienteService.adicionarCliente(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }
    
    //método para listar cliente
    @GetMapping("/exibir")
    public ResponseEntity<List<Cliente>> listar(){
        List<Cliente> listaClientes = clienteService.listarClientes();
        return new ResponseEntity<>(listaClientes, HttpStatus.OK);
    }
    
    //método para buscar cliente por id:
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Integer id){
        Cliente clienteEncontrado = clienteService.buscarClientePorId(id);
        return new ResponseEntity<>(clienteEncontrado, HttpStatus.OK);
    }
    
    //método para deletar cliente por id:
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletar(@PathVariable Integer id){
        clienteService.excluirCliente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    //método para atualizar cliente por id:
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Integer id, @RequestBody Cliente cliente){
        Cliente clienteAtualizado = clienteService.atualizarCliente(id, cliente);
        return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
    }

}
