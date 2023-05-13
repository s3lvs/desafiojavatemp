package com.selvs.dj.desafiojava.controller;

import com.selvs.dj.desafiojava.model.Membro;
import com.selvs.dj.desafiojava.model.MembroId;
import com.selvs.dj.desafiojava.model.Pessoa;
import com.selvs.dj.desafiojava.model.Projeto;
import com.selvs.dj.desafiojava.service.PessoaService;
import com.selvs.dj.desafiojava.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public List<Pessoa> findAll() {
        return pessoaService.findAll();
    }

    // Cadastro de membro não é permitido diretamente
    @PostMapping("/{idPessoa}/projetos/{idProjeto}")
    public Projeto associateMembroToProjeto(@PathVariable Long idPessoa, @PathVariable Long idProjeto) {
        Pessoa pessoa = pessoaService.findById(idPessoa)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));

        if (!pessoa.isFuncionario()) {
            throw new IllegalStateException("Somente funcionários podem ser associados a projetos");
        }

        Projeto projeto = projetoService.findById(idProjeto)
                .orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado"));

        Membro membro = new Membro();
        MembroId membroId = new MembroId();
        membroId.setPessoa(pessoa);
        membroId.setProjeto(projeto);
        membro.setId(membroId);

        projeto.getMembros().add(membro);
        return projetoService.save(projeto);
    }

    @PostMapping("/membros")
    public Pessoa cadastrarMembro(@RequestParam("nome") String nome, @RequestParam("atribuicao") Boolean funcionario) {
        return pessoaService.cadastrarMembro(nome, funcionario);
    }

    @GetMapping("/index")
    public String viewBooks(Model model) {
        //model.addAttribute("books", bookService.getBooks());
        return "index";
    }
}