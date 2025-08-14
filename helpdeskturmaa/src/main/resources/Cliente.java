package com.wagner.helpdesk.domain;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {
    public Cliente() { super(); }
    public Cliente(Integer id, String nome, Integer cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }
}
