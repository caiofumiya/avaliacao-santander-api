package com.avaliacao.api;

import com.avaliacao.dto.FuncionarioDTO;
import com.avaliacao.facade.FuncionariosFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/funcionarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class FuncionariosAPI {
    @Autowired
    private FuncionariosFacade funcionariosFacade;

    @PostMapping
    @ResponseBody
    public FuncionarioDTO criar(@RequestBody FuncionarioDTO funcionarioDTO) {
        return funcionariosFacade.criar(funcionarioDTO);
    }

    @PutMapping("/{funcionarioId}")
    @ResponseBody
    public FuncionarioDTO atualizar(@PathVariable("funcionarioId") Long funcionarioId,
                                    @RequestBody FuncionarioDTO funcionarioDTO) {
    return funcionariosFacade.atualizar(funcionarioDTO, funcionarioId);
    }

    @GetMapping
    @ResponseBody
    public List<FuncionarioDTO> getALl() {
        return funcionariosFacade.getAll();
    }

    @DeleteMapping("/{funcionarioId}")
    @ResponseBody
    public String delete(@PathVariable("funcionarioId") Long funcionarioId) {
        return funcionariosFacade.delete(funcionarioId);
    }
}
