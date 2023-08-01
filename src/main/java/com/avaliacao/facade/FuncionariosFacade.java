package com.avaliacao.facade;

import com.avaliacao.dto.FuncionarioDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FuncionariosFacade {
    private static final Map<Long, FuncionarioDTO> funcionarios = new HashMap<>();

    public FuncionarioDTO criar(FuncionarioDTO funcionarioDTO) {
        Long proximoId = funcionarios.keySet().size() + 1L;
        funcionarioDTO.setId(proximoId);
        funcionarios.put(proximoId, funcionarioDTO);
        return funcionarioDTO;
    }

    public FuncionarioDTO atualizar(FuncionarioDTO funcionarioDTO, Long funcionarioId) {
        funcionarios.put(funcionarioId, funcionarioDTO);
        return funcionarioDTO;
    }

    public FuncionarioDTO getById (Long funcionarioId) {
        return funcionarios.get(funcionarioId);
    }

    public List<FuncionarioDTO> getAll () {
        return new ArrayList<>(funcionarios.values());
    }

    public String delete (Long funcinarioId) {
        funcionarios.remove(funcinarioId);
        return "Deletado com sucesso";
    }
}
