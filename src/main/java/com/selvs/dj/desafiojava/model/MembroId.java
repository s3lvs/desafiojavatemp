package com.selvs.dj.desafiojava.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class MembroId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idprojeto")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "idpessoa")
    private Pessoa pessoa;


    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}