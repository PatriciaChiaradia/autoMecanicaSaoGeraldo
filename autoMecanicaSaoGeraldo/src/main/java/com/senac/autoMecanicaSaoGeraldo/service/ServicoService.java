package com.senac.autoMecanicaSaoGeraldo.service;

import com.senac.autoMecanicaSaoGeraldo.data.ServicoRepository;
import com.senac.autoMecanicaSaoGeraldo.model.Servico;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ServicoService {

    @Autowired
    ServicoRepository servicoRepository;
   

    public Servico adicionarServico(Servico servico) {
        servico.setId(null);
        servicoRepository.save(servico);
        return servico;
}

    public List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }

    public Servico buscarServicoPorId(Integer id) {
       return servicoRepository.findById(id).orElseThrow();
    }

    public Servico atualizarServico(Integer id,Servico servico) { 
      Servico servicoEncontrado = buscarServicoPorId(id);
        servicoEncontrado.setData(servico.getData());
        servicoEncontrado.setDescricao(servico.getDescricao()); 
        servicoEncontrado.setValor(servico.getValor());
        servicoEncontrado.setCliente(servico.getCliente());
        servicoEncontrado.setRealizada(servico.getRealizada()); 
        servicoRepository.save(servicoEncontrado);
        return servicoEncontrado;
    }
    
    public void excluirServico(Integer id) {
    Servico servicoEncontrado = buscarServicoPorId(id);
        servicoRepository.deleteById(servicoEncontrado.getId());
    }
}

