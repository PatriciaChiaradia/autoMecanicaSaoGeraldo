
package com.senac.autoMecanicaSaoGeraldo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="cliente")
public class Cliente {
    
    //Atributos:
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull(message = "Nome é obrigatório") 
    @Size(min = 1, max = 100, message = "Nome deve ter entre 1 e 100 caracteres")
    private String nome;
    
    @NotNull(message = "CPF é obrigatório") 
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato ###.###.###-##")
    private String cpf;
    
    @NotNull(message = "Telefone é obrigatório") 
    @Size(min = 10, max = 15, message = "Telefone deve ter entre 10 e 15 caracteres")
    private String telefone;
    
    @NotNull(message = "Nome é obrigatório")
    private String modelo;
    
    @NotNull(message = "Placa é obrigatória") 
    @Pattern(regexp = "^[A-Z]{3}[0-9][A-Z][0-9]{2}$", message = "Placa deve estar no formato ABC1D23")
    private String placa;

    //Construtores:
    public Cliente() {
    }

    public Cliente(Integer id, String nome, String cpf, String telefone, String modelo, String placa) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.modelo = modelo;
        this.placa = placa;
    }

    public Cliente(Integer id, String nome, String modelo, String placa) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
        this.placa = placa;
    }
   
    //Getters and Setters:
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
   
}
