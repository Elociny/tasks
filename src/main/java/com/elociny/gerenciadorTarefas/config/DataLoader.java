package com.elociny.gerenciadorTarefas.config;

import com.elociny.gerenciadorTarefas.model.Tarefa;
import com.elociny.gerenciadorTarefas.repository.TarefaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(TarefaRepository repository) {
        return args -> {
            if (repository.count() == 0) {

                repository.save(Tarefa.builder()
                        .titulo("Pagar fatura do cartão")
                        .descricao("Venceu dia 10, pagar com urgência para evitar juros.")
                        .responsavel("Carlos")
                        .dataTermino(LocalDate.now().minusDays(10))
                        .build());

                repository.save(Tarefa.builder()
                        .titulo("Entregar relatório mensal")
                        .descricao("Relatório de vendas pendente.")
                        .responsavel("Ana")
                        .dataTermino(LocalDate.now().minusDays(5))
                        .build());

                repository.save(Tarefa.builder()
                        .titulo("Devolver livro na biblioteca")
                        .descricao("Livro 'Clean Code', multa diária acumulando.")
                        .responsavel("Nicole")
                        .dataTermino(LocalDate.now().minusDays(2))
                        .build());

                repository.save(Tarefa.builder()
                        .titulo("Revisar Pull Request #42")
                        .descricao("Colega está esperando o code review.")
                        .responsavel("Dev Team")
                        .dataTermino(LocalDate.now().minusDays(1))
                        .build());

                repository.save(Tarefa.builder()
                        .titulo("Reunião de Daily")
                        .descricao("Alinhamento diário com a equipe.")
                        .responsavel("Scrum Master")
                        .dataTermino(LocalDate.now())
                        .build());

                repository.save(Tarefa.builder()
                        .titulo("Fazer compras do mês")
                        .descricao("Comprar itens básicos de alimentação.")
                        .responsavel("Família")
                        .dataTermino(LocalDate.now().plusDays(2))
                        .build());

                repository.save(Tarefa.builder()
                        .titulo("Estudar Integração Spring + React")
                        .descricao("Terminar o tutorial e aplicar na prática.")
                        .responsavel("Nicole")
                        .dataTermino(LocalDate.now().plusDays(7))
                        .build());

                repository.save(Tarefa.builder()
                        .titulo("Agendar revisão do carro")
                        .descricao("Troca de óleo e filtros.")
                        .responsavel("Carlos")
                        .dataTermino(LocalDate.now().plusDays(15))
                        .build());

                System.out.println("✅ 8 Tarefas de teste inseridas com sucesso!");
            }
        };
    }
}