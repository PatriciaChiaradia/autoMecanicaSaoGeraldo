package com.senac.autoMecanicaSaoGeraldo.service;

import com.senac.autoMecanicaSaoGeraldo.model.Servico;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoService {

    private final List<Servico> listaServico = new ArrayList<>();

    public void adicionarServico(Servico servico) {
    servico.setId(listaServico.size() + 1);
    listaServico.add(servico);
}

    public List<Servico> listarServicos() {
        return listaServico;
    }

    public Servico buscarServicoPorId(int id) {
        Servico servico = listaServico.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    return servico;
    }

    public void atualizarServico(Servico servicoAtualizado) { 
        for (Servico servico : listaServico) {
            if (servico.getId() == servicoAtualizado.getId()) { 
                servico.setData(servicoAtualizado.getData());
                servico.setDescricao(servicoAtualizado.getDescricao()); 
                servico.setValor(servicoAtualizado.getValor());
                servico.setClienteId(servicoAtualizado.getClienteId());
                servico.setRealizada(servicoAtualizado.getRealizada()); 
                break; 
            }
        }
    }
    
    public void excluirServico(int id) {
        listaServico.removeIf(servico -> servico.getId() == id);
    }
}

