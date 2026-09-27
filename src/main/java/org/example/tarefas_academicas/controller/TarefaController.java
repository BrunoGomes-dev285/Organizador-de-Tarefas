package org.example.tarefas_academicas.controller;
import org.example.tarefas_academicas.model.Prioridade;
import org.springframework.ui.Model;
import jakarta.validation.Valid;
import org.example.tarefas_academicas.model.Tarefa;
import org.example.tarefas_academicas.repository.TarefaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaRepository repository;

    public TarefaController(TarefaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("tarefas",  repository.listarTodos());
        return "tarefas/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("tarefa", new Tarefa());
        model.addAttribute("prioridade", Prioridade.values());
        return "tarefas/formulario";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute("tarefa") Tarefa tarefa, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("prioridade", Prioridade.values());
            return"tarefas/formulario";
        }
        repository.salvar(tarefa);
            return "redirect:/tarefas";
    }
}