package com.senac.autoMecanicaSaoGeraldo.controller;

import com.senac.autoMecanicaSaoGeraldo.model.Servico;
import com.senac.autoMecanicaSaoGeraldo.service.ServicoService;
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
@RequestMapping("/servico")
public class ServicoAPIController {
    
    @Autowired
    private ServicoService servicoService;
    
    //método para cadastrar serviço
    @PostMapping("/cadastrar")
    public ResponseEntity<Servico> addServico(@RequestBody Servico servico){
        Servico novoServico = servicoService.adicionarServico(servico);
        return new ResponseEntity<>(novoServico, HttpStatus.CREATED);
    }
    
    //método para listar serviço
    @GetMapping("/exibir")
    public ResponseEntity<List<Servico>> listar(){
        List<Servico> listaServicos = servicoService.listarServicos();
        return new ResponseEntity<>(listaServicos, HttpStatus.OK);
    }
    
    //método para buscar serviço por id:
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Servico> buscar(@PathVariable Integer id){
        Servico servicoEncontrado = servicoService.buscarServicoPorId(id);
        return new ResponseEntity<>(servicoEncontrado, HttpStatus.OK);
    }
    
    //método para deletar serviço por id:
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletar(@PathVariable Integer id){
        servicoService.excluirServico(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    //método para atualizar serviço por id:
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Servico> atualizar(@PathVariable Integer id, @RequestBody Servico servico){
        Servico servicoAtualizado = servicoService.atualizarServico(id, servico);
        return new ResponseEntity<>(servicoAtualizado, HttpStatus.OK);
    }
}

