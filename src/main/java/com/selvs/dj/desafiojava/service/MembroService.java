package com.selvs.dj.desafiojava.service;

import com.selvs.dj.desafiojava.model.Membro;
import com.selvs.dj.desafiojava.model.MembroId;
import com.selvs.dj.desafiojava.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembroService {

    @Autowired
    private MembroRepository membroRepository;

    public List<Membro> findAll() {
        return membroRepository.findAll();
    }

    public Optional<Membro> findById(MembroId id) {
        return membroRepository.findById(id);
    }

    public Membro save(Membro membro) {
        return membroRepository.save(membro);
    }

    public void deleteById(MembroId id) {
        membroRepository.deleteById(id);
    }
}