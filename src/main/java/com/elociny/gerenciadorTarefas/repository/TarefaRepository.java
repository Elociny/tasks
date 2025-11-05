package com.elociny.gerenciadorTarefas.repository;

import com.elociny.gerenciadorTarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
