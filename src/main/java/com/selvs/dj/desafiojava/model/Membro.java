package com.selvs.dj.desafiojava.model;

import javax.persistence.*;

@Entity(name = "membros")
public class Membro {

    @EmbeddedId
    private MembroId id;

    public MembroId getId() {
        return id;
    }

    public void setId(MembroId id) {
        this.id = id;
    }
}