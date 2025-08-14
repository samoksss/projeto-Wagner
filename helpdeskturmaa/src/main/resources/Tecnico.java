package com.wagner.helpdesk.domain;

import javax.persistence.Entity;

@Entity
public class Tecnico extends Pessoa {
    public Tecnico() { super(); }
    public Tecnico(Integer id, String nome, Integer cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }
}
package com.wagner.helpdesk.domain;

import javax.persistence.Entity;

@Entity
public class Tecnico extends Pessoa {
    public Tecnico() { super(); }
    public Tecnico(Integer id, String nome, Integer cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }
}
