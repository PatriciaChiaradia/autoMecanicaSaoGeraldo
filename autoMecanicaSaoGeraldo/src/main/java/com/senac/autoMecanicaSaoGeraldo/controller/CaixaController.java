package com.senac.autoMecanicaSaoGeraldo.controller;

import com.senac.autoMecanicaSaoGeraldo.model.Caixa;
import com.senac.autoMecanicaSaoGeraldo.service.CaixaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

@Controller
public class CaixaController {

    @Autowired
    private CaixaService caixaService;

    @GetMapping("/livro-caixa")
    public String listar(Model model) {
        model.addAttribute("caixa", new Caixa());
        model.addAttribute("listaRegistro", caixaService.listarRegistro());
        model.addAttribute("saldoTotal", caixaService.calcularSaldoTotal());
        return "livro-caixa";
    }

    @PostMapping("/registrar")
    public String addRegistro(@ModelAttribute @Valid Caixa caixa, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listaRegistro", caixaService.listarRegistro());
            model.addAttribute("saldoTotal", caixaService.calcularSaldoTotal());
            return "livro-caixa";
        }
        if (caixa.getValor() <= 0) {
            result.rejectValue("valor", "error.valor", "O valor deve ser maior que zero.");
            model.addAttribute("listaRegistro", caixaService.listarRegistro());
            model.addAttribute("saldoTotal", caixaService.calcularSaldoTotal());
            return "livro-caixa";
        }
        if ("saida".equalsIgnoreCase(caixa.getTipoLancamento())) {
            caixa.setValor(-Math.abs(caixa.getValor()));
        }
        caixaService.adicionarRegistro(caixa);
        return "redirect:/livro-caixa";
    }
}
