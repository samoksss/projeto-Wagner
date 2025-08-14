package com.wagner.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wagner.helpdesk.domain.enums.Prioridade;
import com.wagner.helpdesk.domain.enums.Status;

@Entity
public class Chamado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;

    // Armazena o código do enum
    private Integer prioridade;
    private Integer status;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @ManyToOne(optional = false)
    private Cliente cliente;

    @ManyToOne
    private Tecnico tecnico;

    public Chamado() {
        setStatus(Status.ABERTO);
        setPrioridade(Prioridade.MEDIA);
    }

    public Chamado(Integer id, Prioridade prioridade, Status status,
                   String titulo, String observacoes, Cliente cliente, Tecnico tecnico) {
        this.id = id;
        setPrioridade(prioridade);
        setStatus(status);
        this.titulo = titulo;
        this.observacoes = observacoes;
        this.cliente = cliente;
        this.tecnico = tecnico;
    }

    // Getters/Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDate getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(LocalDate dataAbertura) { this.dataAbertura = dataAbertura; }

    public LocalDate getDataFechamento() { return dataFechamento; }
    public void setDataFechamento(LocalDate dataFechamento) { this.dataFechamento = dataFechamento; }

    public Prioridade getPrioridade() { return Prioridade.toEnum(prioridade); }
    public void setPrioridade(Prioridade p) { this.prioridade = (p == null ? null : p.getCodigo()); }

    public Status getStatus() { return Status.toEnum(status); }
    public void setStatus(Status s) { this.status = (s == null ? null : s.getCodigo()); }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Tecnico getTecnico() { return tecnico; }
    public void setTecnico(Tecnico tecnico) { this.tecnico = tecnico; }
}
