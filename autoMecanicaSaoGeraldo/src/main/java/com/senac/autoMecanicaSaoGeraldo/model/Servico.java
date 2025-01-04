package com.senac.autoMecanicaSaoGeraldo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="servico")
public class Servico {
    
    //Atributos:
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull(message = "Descrição é obrigatória") 
    @Size(min = 1, max = 100, message = "Descrição deve ter entre 1 e 100 caracteres")
    private String descricao;
    
    @ManyToOne 
    @JoinColumn(name = "cliente_id") 
    private Cliente cliente;
    
    @NotNull(message = "Valor é obrigatório.")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero.")
    private Double valor;
    
    private Boolean Realizada;
    
    @NotNull(message = "Data é obrigatória.")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;
    
    //Métodos Construtores:
    public Servico() {
    }

    public Servico(Integer id, String descricao, Cliente cliente, Double valor, Boolean Realizada, LocalDate data) {
        this.id = id;
        this.descricao = descricao;
        this.cliente = cliente;
        this.valor = valor;
        this.Realizada = Realizada;
        this.data = data;
    }

    //Getters e Setters:
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente clienteId) {
        this.cliente = clienteId;
    }

    public Boolean getRealizada() {
        return Realizada;
    }

    public void setRealizada(Boolean Realizada) {
        this.Realizada = Realizada;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) { 
        this.data = data;
    }
    // Método para aceitar data no formato brasileiro (dd/MM/yyyy)
    public void setData(String data) { 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.data = LocalDate.parse(data, formatter); 
    }
    
    // Método para retornar a data formatada no padrão brasileiro
    public String getDataFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        return data != null ? data.format(formatter) : ""; 
    }
}


