package com.escola.senai.service;

import com.escola.senai.model.Aluno;
import com.escola.senai.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public  Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodos() {
        return  alunoRepository.findAll();
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return  alunoRepository.findById(id);
    }

    public Aluno atualizarAluno(Long id, Aluno alunoAtualizado) {
        return alunoRepository.findById(id)
                .map(aluno -> {
                    aluno.setNomeAluno(alunoAtualizado.getNomeAluno());
                    aluno.setIdadeAluno(alunoAtualizado.getIdadeAluno());
                    aluno.setMatriculaAluno(alunoAtualizado.getMatriculaAluno());
                    return alunoRepository.save(aluno);
                })
                .orElseThrow(() -> new RuntimeException("Aluno não rencontrado com o ID: " + id));
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}
