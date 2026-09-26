package org.example.tarefas_academicas.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Random;

@Getter
@Setter
public class Tarefa {
    private Long id;

    @NotBlank(message = "Adicione um titulo a sua tarefa")
    @Size(min = 1, max = 1000)
    private String titulo;

    @Size(min = 1, max = 1000)
    @NotBlank(message = "Adicione uma descricao")
    private String descricao;

    @NotNull(message = "Adicione uma data")
    private LocalDate prazo;


    private Prioridade prioridade;


    private StatusTarefa status;


    public void concluir() {
        if(this.getStatus() == StatusTarefa.PENDENTE){
            this.setStatus(StatusTarefa.CONCLUIDA);
        }
    }

    public void reabrir() {
        if(this.getStatus() == StatusTarefa.CONCLUIDA){
            this.setStatus(StatusTarefa.PENDENTE);
        }
    }

}
