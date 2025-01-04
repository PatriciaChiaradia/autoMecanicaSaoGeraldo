package com.senac.autoMecanicaSaoGeraldo.controller;

import org.springframework.ui.Model;
import com.senac.autoMecanicaSaoGeraldo.model.Cliente;
import com.senac.autoMecanicaSaoGeraldo.service.ClienteService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/inicio")
    public String inicio2() {
        return "index";
    }

    @GetMapping("/cadastro")
    public String exibirFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cadastro";
    }

    @PostMapping("/cadastro") public String processarFormulario(@Valid @ModelAttribute Cliente cliente,
            BindingResult result) { 
        if (result.hasErrors()) { 
            return "cadastro"; 
        } 
        clienteService.adicionarCliente(cliente); 
        return "redirect:/exibir"; 
    }

    @GetMapping("/exibir")
    public String listaForm(Model model) {
        List<Cliente> listaClientes = clienteService.listarClientes();
        model.addAttribute("lista", listaClientes);
        return "exibir";
    }

    @GetMapping("/atualizar")
    public String exibirFormularioAtualizar(@RequestParam("id") int id, Model model) {
        Cliente cliente = clienteService.buscarClientePorId(id); // Busca cliente pelo ID
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "atualizar";
        }
        return "redirect:/exibir";
    }

    @PostMapping("/atualizar")
    public String processarAtualizacao(@ModelAttribute Cliente clienteAtualizado) {
        clienteService.atualizarCliente(clienteAtualizado);
        return "redirect:/exibir";
    }

    @GetMapping("/excluir-cliente")
    public String excluirCliente(@RequestParam("id") int id) {
        clienteService.excluirCliente(id); 
        return "redirect:/exibir";
    }
}
