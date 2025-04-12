package com.escola.senai.service;

import com.escola.senai.model.Professor;
import com.escola.senai.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor salvarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    public Optional<Professor> buscarPorId(Long id) {
        return  professorRepository.findById(id);
    }

    public Professor atualizarProfessor(Long id, Professor professorAtualizado) {
        return professorRepository.findById(id)
                .map(professor -> {
                    professor.setNomeProfessor(professorAtualizado.getNomeProfessor());
                    professor.setDisciplinaProfessor(professorAtualizado.getDisciplinaProfessor());
                    return professorRepository.save(professor);
                })
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID: " + id));
    }

    public void deletarProfessor(Long id) {
        professorRepository.deleteById(id);
    }
}
