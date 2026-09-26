package org.example.tarefas_academicas.repository;

import org.example.tarefas_academicas.model.Tarefa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TarefaRepository {

    private final List<Tarefa> tarefas = new ArrayList<>();
    private Long contador = 1L;

    public List<Tarefa> listarTodos() {
        return tarefas;
    }

    public void salvar(Tarefa tarefa) {
        tarefa.setId(contador++);
        tarefas.add(tarefa);
    }

    public Optional buscarPorId(Long id) {
        // implementar
        return
    }

    public List listarPendentes() {
        // implementar
    }
}