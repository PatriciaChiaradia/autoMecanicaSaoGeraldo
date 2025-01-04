
package com.senac.autoMecanicaSaoGeraldo.service;

import com.senac.autoMecanicaSaoGeraldo.data.CaixaRepository;
import com.senac.autoMecanicaSaoGeraldo.model.Caixa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaixaService {
    
    @Autowired
    CaixaRepository caixaRepository;
   
      
    public Caixa adicionarRegistro(Caixa caixa) {
        caixa.setIdCaixa(null);
        caixaRepository.save(caixa);
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
}
