
package com.senac.autoMecanicaSaoGeraldo.controller;

import com.senac.autoMecanicaSaoGeraldo.model.Servico;
import com.senac.autoMecanicaSaoGeraldo.service.ServicoService;
import com.senac.autoMecanicaSaoGeraldo.service.ClienteService;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private ClienteService clienteService;
    
    @InitBinder public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    
    @GetMapping("/ordem-servico")
    public String ordemServico(Model model) {
        model.addAttribute("listaServico", servicoService.listarServicos());
        model.addAttribute("servico", new Servico());
        model.addAttribute("clientes", clienteService.listarClientes());
        return "ordem-servico";
    }

    @PostMapping("/registrar-servico")
    public String registrar(@ModelAttribute  Servico servico, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listaServico", servicoService.listarServicos());
            return "ordem-servico";
        }
        
        if (servico.getClienteId() == null) {
            result.rejectValue("clienteId", "field.required", "O cliente é obrigatório");
            model.addAttribute("listaServico", servicoService.listarServicos());
            return "ordem-servico";
        }
        servicoService.adicionarServico(servico);
        model.addAttribute("mensagemSucesso", "Ordem de serviço salva com sucesso!"); 
        return "redirect:/ordem-servico";
    }

    @GetMapping("/atualizar-servico")
    public String exibirFormularioAtualizar(@RequestParam("id") int id, Model model) {
        Servico servico = servicoService.buscarServicoPorId(id);
        if (servico != null) {
            model.addAttribute("servico", servico);
            model.addAttribute("clientes",clienteService.listarClientes());
            return "atualizar-servico";
        }
        return "redirect:/ordem-servico";
    }

    @PostMapping("/atualizar-servico")
    public String processarAtualizacaoServico(@ModelAttribute Servico servicoAtualizado, Model model) {
        servicoService.atualizarServico(servicoAtualizado);
        return "redirect:/ordem-servico";
    }

    @GetMapping("/excluir-servico")
    public String excluirServico(@RequestParam("id") int id) {
        servicoService.excluirServico(id);
        return "redirect:/ordem-servico";
    }
}
