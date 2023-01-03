package com.company.apiSimples.tarefas.api;

import com.company.apiSimples.tarefas.dto.TarefaDTO;
import com.company.apiSimples.tarefas.facade.TarefasFacade;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefasAPI {

    @Autowired
    private TarefasFacade tarefasFacade;

    @PostMapping
    @ResponseBody
    public TarefaDTO criar (@RequestBody TarefaDTO tarefaDTO){
        return tarefasFacade.criar(tarefaDTO);
    }

    @PutMapping("/{tarefaId}")
    @ResponseBody
    public TarefaDTO atualizar(@PathVariable("tarefasId")Long tarefaId, @RequestBody TarefaDTO tarefaDTO){
        return tarefasFacade.atualizar(tarefaDTO, tarefaId);
    }

    @GetMapping
    @ResponseBody
    public List<TarefaDTO> getAll(){
        return tarefasFacade.getAll();
    }

    @DeleteMapping("/{tarefaId}")
    @ResponseBody
    public String deletar(@PathVariable("tarefaID") Long tarefaId){
        return tarefasFacade.delete(tarefaId);
    }
}
