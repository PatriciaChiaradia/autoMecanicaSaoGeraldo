package com.senac.autoMecanicaSaoGeraldo.converter;

import com.senac.autoMecanicaSaoGeraldo.model.Cliente;
import com.senac.autoMecanicaSaoGeraldo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToClienteConverter implements Converter<String, Cliente> {

    @Autowired
    private ClienteService clienteService;

    @Override
    public Cliente convert(String source) {
        try {
            Integer id = Integer.valueOf(source);
            return clienteService.buscarClientePorId(id);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
