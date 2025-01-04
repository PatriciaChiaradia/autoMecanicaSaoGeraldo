package com.senac.autoMecanicaSaoGeraldo.controller;

import com.senac.autoMecanicaSaoGeraldo.model.Caixa;
import com.senac.autoMecanicaSaoGeraldo.service.CaixaService;
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
@RequestMapping("/caixa")
public class CaixaAPIController {
    @Autowired
    private CaixaService caixaService;
    
    //método para cadastrar registro
    @PostMapping("/cadastrar")
    public ResponseEntity<Caixa> addRegistro(@RequestBody Caixa caixa){
        Caixa novoRegistro = caixaService.adicionarRegistro(caixa);
        return new ResponseEntity<>(novoRegistro, HttpStatus.CREATED);
    }
    
    //método para listar registro
    @GetMapping("/exibir")
    public ResponseEntity<List<Caixa>> listar(){
        List<Caixa> listaRegistros = caixaService.listarRegistro();
        return new ResponseEntity<>(listaRegistros, HttpStatus.OK);
    }
    
    //método para buscar registro por id:
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Caixa> buscar(@PathVariable Integer id){
        Caixa RegistroEncontrado = caixaService.buscarRegistroPorId(id);
        return new ResponseEntity<>(RegistroEncontrado, HttpStatus.OK);
    }
    
    //método para deletar registro por id:
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletar(@PathVariable Integer id){
        caixaService.excluirRegistro(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    //método para atualizar registro por id:
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Caixa> atualizar(@PathVariable Integer id, @RequestBody Caixa caixa){
        Caixa registroAtualizado = caixaService.atualizarRegistro(id, caixa);
        return new ResponseEntity<>(registroAtualizado, HttpStatus.OK);
    }
}
