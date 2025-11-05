package com.elociny.gerenciadorTarefas.service;

import com.elociny.gerenciadorTarefas.model.Tarefa;
import com.elociny.gerenciadorTarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public List<Tarefa> listar() {
        return repository.findAll();
    }

    public Tarefa salvar(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public Tarefa atualizar(Long id, Tarefa nova) {
        Tarefa tarefa = repository.findById(id).orElseThrow();
        tarefa.setTitulo(nova.getTitulo());
        tarefa.setDescricao(nova.getDescricao());
        tarefa.setResponsavel(nova.getResponsavel());
        tarefa.setDataTermino(nova.getDataTermino());
        return repository.save(tarefa);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
