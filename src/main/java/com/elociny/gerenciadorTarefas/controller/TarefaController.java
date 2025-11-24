package com.elociny.gerenciadorTarefas.controller;

import com.elociny.gerenciadorTarefas.model.Tarefa;
import com.elociny.gerenciadorTarefas.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "http://localhost:5173")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @GetMapping
    @Operation(summary = "Listar todas as tarefas", description = "Retorna uma lista com todas as tarefas cadastradas no banco.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    public List<Tarefa> listar() {
        return service.listar();
    }

    @PostMapping
    @Operation(summary = "Criar nova tarefa", description = "Cadastra uma nova tarefa no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados")
    })
    public Tarefa salvar(@Valid @RequestBody Tarefa tarefa) {
        return service.salvar(tarefa);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar tarefa", description = "Atualiza os dados de uma tarefa existente baseada no ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada com o ID informado")
    })
    public Tarefa atualizar(@PathVariable Long id, @Valid @RequestBody Tarefa tarefa) {
        return service.atualizar(id, tarefa);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir tarefa", description = "Remove uma tarefa do banco de dados permanentemente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa excluída com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada com o ID informado")
    })
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}