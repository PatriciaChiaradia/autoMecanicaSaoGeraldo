package com.senac.autoMecanicaSaoGeraldo.controller;

import com.senac.autoMecanicaSaoGeraldo.model.Caixa;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.BindingResult;

@Controller
public class CaixaController {
    private final List<Caixa> listaRegistro = new ArrayList<>();
    private double saldoTotal = 0.0;

    @GetMapping("/livro-caixa")
    public String livroCaixa(Model model) {
        model.addAttribute("caixa", new Caixa());
        model.addAttribute("listaRegistro", listaRegistro);
        model.addAttribute("saldoTotal", saldoTotal);
        return "livro-caixa";
    }

   @PostMapping("/registrar")
    public String registrar(@ModelAttribute @Valid Caixa caixa, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Se houver erros de validação, retorna para o formulário com os erros
            model.addAttribute("listaRegistro", listaRegistro);
            model.addAttribute("saldoTotal", saldoTotal);
            return "livro-caixa";
        }
        // Verifica se o valor é menor ou igual a zero (validação adicional no backend)
        if (caixa.getValor() <= 0) {
            result.rejectValue("valor", "error.valor", "O valor deve ser maior que zero.");
            model.addAttribute("listaRegistro", listaRegistro);
            model.addAttribute("saldoTotal", saldoTotal);
            return "livro-caixa";
        }
        // Atualiza o saldo total com base no tipo de lançamento
        if ("saida".equalsIgnoreCase(caixa.getTipoLancamento())) {
            caixa.setValor(-caixa.getValor());
        }
        saldoTotal += caixa.getValor();
        caixa.setSaldoTotal(saldoTotal);

        // Adiciona o registro à lista
        listaRegistro.add(caixa);

        // Atualiza os dados do modelo
        model.addAttribute("listaRegistro", listaRegistro);
        model.addAttribute("saldoTotal", saldoTotal);

        return "redirect:/livro-caixa"; 
    }
}
