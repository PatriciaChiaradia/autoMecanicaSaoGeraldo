
package com.senac.autoMecanicaSaoGeraldo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="caixa")
public class Caixa {

    //Atributos:
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCaixa;
    
    @NotBlank(message = "Descrição é obrigatória.")
    private String descricao;
    
    @NotNull(message = "Valor é obrigatório.")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero.")
    private Double valor;
    
    @NotNull(message = "Data é obrigatória.")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;
    
    @NotBlank(message = "Tipo de lançamento é obrigatório.")
    private String tipoLancamento;
    
    private Double saldoTotal;

    //Construtores:
    public Caixa() {
    }

    public Caixa(Integer idCaixa, String descricao, Double valor, LocalDate data, String tipoLancamento, Double saldoTotal) {
        this.idCaixa = idCaixa;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipoLancamento = tipoLancamento;
        this.saldoTotal = saldoTotal;
    }
    
    //Getters e Setters:
    public Integer getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(Integer idCaixa) {
        this.idCaixa = idCaixa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public String getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(String tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public Double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(Double saldoTotal) {
        this.saldoTotal = saldoTotal;
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
    public enum TipoLancamento {
        ENTRADA,
        SAIDA
    }
}


