package org.example.tarefas_academicas.repository;

import com.sun.source.doctree.ReturnTree;
import jakarta.servlet.Filter;
import org.example.tarefas_academicas.model.StatusTarefa;
import org.example.tarefas_academicas.model.Tarefa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.example.tarefas_academicas.model.StatusTarefa.PENDENTE;

@Repository
public class TarefaRepository {

    private final List<Tarefa> tarefas = new ArrayList<>();
    private Long contador = 1L;



    public List<Tarefa> listarTodos(){
        return tarefas;
    }

    public void salvar(Tarefa tarefa) {
        tarefa.setId(contador++);
        tarefas.add(tarefa);
    }

        public Optional<Tarefa> buscarPorId(Long id) {
            return tarefas.stream()
                    .filter(tarefa -> tarefa.getId().equals(id))
                    .findFirst();
        }

    public List listarPendentes() {
        return tarefas.stream()
                .filter(tarefa -> tarefa.getStatus().equals(PENDENTE))
                .toList();
    }


}