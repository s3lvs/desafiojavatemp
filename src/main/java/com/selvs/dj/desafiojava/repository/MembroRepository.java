package com.selvs.dj.desafiojava.repository;

import com.selvs.dj.desafiojava.model.Membro;
import com.selvs.dj.desafiojava.model.MembroId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<Membro, MembroId> {
}