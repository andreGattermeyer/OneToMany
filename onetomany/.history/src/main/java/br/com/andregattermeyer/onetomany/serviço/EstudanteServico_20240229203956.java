package br.com.andregattermeyer.onetomany.serviço;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andregattermeyer.onetomany.modelo.Estudante;
import br.com.andregattermeyer.onetomany.repositorio.EstudanteRepositorio;

@Service
public class EstudanteServico {
    
    @Autowired
    private EstudanteRepositorio estudanteRepositorio;

    public Estudante criarEstudante(Estudante estudante) {
        return estudanteRepositorio.save(estudante);
    }

    public List <Estudante> buscarTodos(Estudante estudante) {
        return estudanteRepositorio.save(estudante);
    }

}
