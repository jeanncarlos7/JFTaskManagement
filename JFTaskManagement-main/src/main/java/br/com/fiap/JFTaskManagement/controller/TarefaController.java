package br.com.fiap.jftaskmanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.jftaskmanagement.model.Categoria;

@RestController
@RequestMapping("tarefa")
public class TarefaController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Tarefa> repository = new ArrayList<>();

    @GetMapping
    public List<Tarefa> index(){
        return repository;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Tarefa create(@RequestBody Tarefa tarefa){ //binding
        log.info("cadastrando tarefa " + tarefa);
        repository.add(tarefa);
        return tarefa;
    }

    @GetMapping("{id}")
    public ResponseEntity<Tarefa> show(@PathVariable Long id){
        log.info("buscar tarefa por id {} ", id);

        // for(Tarefa tarefa : repository){
        //     if (tarefa.id().equals(id))
        //         return ResponseEntity.ok(tarefa);
        // }

        var tarefaEncontrada = getTarefaById(id);

        if (tarefaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();
        
        return ResponseEntity.ok(tarefa
        Encontrada.get());
    }

    @DeleteMapping("{id}") 
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("Apagando tarefa com id {} ", id);

        var tarefaEncontrada = getTarefaById(id);

        if (tarefaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        repository.remove(tarefaEncontrada.get());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa){
        log.info("atualizando tarefa com id {} para {}", id, tarefa);
         
        var tarefaEncontrada = getTarefaById(id);

        if (tarefaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        var tarefaAntiga = tarefaEncontrada.get();
        var tarefaNova = new Tarefa(id, tarefa.nome(), tarefa.icone());

        repository.remove(tarefaAntiga);
        repository.add(tarefaNova);

        return ResponseEntity.ok(tarefaNova);

    }

    private Optional<Tarefa> getTarefaById(Long id) {
        var tarefaEncontrada = repository
                                    .stream()
                                    .filter( c -> c.id().equals(id))
                                    .findFirst();
        return tarefaEncontrada;
    }

}
