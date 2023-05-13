package com.selvs.dj.desafiojava.service;

import com.selvs.dj.desafiojava.model.Pessoa;
import com.selvs.dj.desafiojava.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa cadastrarMembro(String nome, Boolean funcionario) {
        Pessoa novoMembro = new Pessoa();
        novoMembro.setNome(nome);
        novoMembro.setFuncionario(funcionario);
        return pessoaRepository.save(novoMembro);
    }
}