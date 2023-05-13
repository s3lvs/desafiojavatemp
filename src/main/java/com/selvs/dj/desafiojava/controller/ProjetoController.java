package com.selvs.dj.desafiojava.controller;

import com.selvs.dj.desafiojava.model.Projeto;
import com.selvs.dj.desafiojava.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping("/all")
    public List<Projeto> findAll() {
        return projetoService.findAll();
    }

    @GetMapping("/{id}")
    public Projeto findById(@PathVariable Long id) {
        return projetoService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado"));
    }

    @PostMapping(value = "salvar-projeto", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE} )
    public String create(@RequestParam Map<String, String> body) {
        Projeto p = new Projeto();
        return "index";
    }

    @PutMapping("/{id}")
    public Projeto update(@PathVariable Long id, @RequestBody Projeto projeto) {
        Projeto projetoExistente = projetoService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado"));

        projetoExistente.setNome(projeto.getNome());
        projetoExistente.setDataInicio(projeto.getDataInicio());
        projetoExistente.setGerente(projeto.getGerente());
        projetoExistente.setDataPrevisaoFim(projeto.getDataPrevisaoFim());
        projetoExistente.setDataFim(projeto.getDataFim());
        projetoExistente.setOrcamento(projeto.getOrcamento());
        projetoExistente.setDescricao(projeto.getDescricao());
        projetoExistente.setStatus(projeto.getStatus());

        return projetoService.save(projetoExistente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Projeto projeto = projetoService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado"));

        String status = projeto.getStatus();
        if (!"iniciado".equalsIgnoreCase(status) && !"em andamento".equalsIgnoreCase(status) &&
                !"encerrado".equalsIgnoreCase(status)) {
            projetoService.deleteById(id);
        } else {
            throw new IllegalStateException("O projeto não pode ser excluído, pois seu status é iniciado, em andamento ou encerrado.");
        }
    }


}
