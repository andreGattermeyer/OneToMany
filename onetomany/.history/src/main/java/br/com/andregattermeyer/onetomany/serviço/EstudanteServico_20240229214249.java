package br.com.andregattermeyer.onetomany.serviço;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andregattermeyer.onetomany.exceção.EstudanteNotFoundException;
import br.com.andregattermeyer.onetomany.modelo.Estudante;
import br.com.andregattermeyer.onetomany.repositorio.EstudanteRepositorio;

@Service
public class EstudanteServico {
    
    @Autowired
    private EstudanteRepositorio estudanteRepositorio;

    public Estudante criarEstudante(Estudante estudante) {
        return estudanteRepositorio.save(estudante);
    }

    public List <Estudante> buscarTodosEstudantes() {
        return estudanteRepositorio.findAll();
    }

    public Estudante buscarEstudantePorId(Long id) throws EstudanteNotFoundException{
        Optional<Estudante> opt = estudanteRepositorio.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new EstudanteNotFoundException("Estudante com id" + id + " não existe!");
        }
    }

    public voi

}
