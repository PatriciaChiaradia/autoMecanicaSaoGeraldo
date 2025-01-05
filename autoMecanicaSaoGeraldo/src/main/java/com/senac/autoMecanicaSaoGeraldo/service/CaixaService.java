
package com.senac.autoMecanicaSaoGeraldo.service;

import com.senac.autoMecanicaSaoGeraldo.data.CaixaRepository;
import com.senac.autoMecanicaSaoGeraldo.model.Caixa;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaixaService {
    
    @Autowired
    CaixaRepository caixaRepository;

    @Transactional
    public Caixa adicionarRegistro(Caixa caixa) {
        caixa.setIdCaixa(null);
        Double ultimoSaldoTotal = caixaRepository.findUltimoSaldoTotal();
        if (ultimoSaldoTotal == null) {
            ultimoSaldoTotal = 0.0;
        }
        System.out.println("Último Saldo Total: " + ultimoSaldoTotal);
        if ("saida".equalsIgnoreCase(caixa.getTipoLancamento())) {
            caixa.setValor(-Math.abs(caixa.getValor()));
            System.out.println("Valor de Saída (negativo): " + caixa.getValor());
        } else {
            System.out.println("Valor de Entrada: " + caixa.getValor());
        }
        caixa.setSaldoTotal(ultimoSaldoTotal + caixa.getValor());
        System.out.println("Saldo Total após registro: " + caixa.getSaldoTotal());
        caixaRepository.save(caixa);
        System.out.println("Registro salvo com sucesso.");
        return caixa;
    }

    public List<Caixa> listarRegistro() {
        return caixaRepository.findAll();
    }

    public Caixa buscarRegistroPorId(Integer idCaixa) {
        return caixaRepository.findById(idCaixa).orElseThrow();
    }

    public Caixa atualizarRegistro(Integer idCaixa, Caixa caixa) {
        Caixa registroEncontrado = buscarRegistroPorId(idCaixa);
        registroEncontrado.setDescricao(caixa.getDescricao());
        registroEncontrado.setValor(caixa.getValor());
        registroEncontrado.setData(caixa.getData());
        registroEncontrado.setTipoLancamento(caixa.getTipoLancamento());
        caixaRepository.save(registroEncontrado);
        return registroEncontrado;
    }

    public void excluirRegistro(Integer idCaixa) {
        Caixa registroEncontrado = buscarRegistroPorId(idCaixa);
        caixaRepository.deleteById(registroEncontrado.getIdCaixa());
    }

    public Double calcularSaldoTotal() {
        Double saldoTotal = caixaRepository.findSaldoTotal();
        return saldoTotal != null ? saldoTotal : 0.0;
    }
}
