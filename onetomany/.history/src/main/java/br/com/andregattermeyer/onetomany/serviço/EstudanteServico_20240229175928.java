package br.com.andregattermeyer.onetomany.serviço;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andregattermeyer.onetomany.modelo.Estudante;
import br.com.andregattermeyer.onetomany.repositorio.EstudanteRepositorio;

@Service
public class EstudanteServico {
    
    @Autowired
    private EstudanteRepositorio estudanteRepositorio;

    public Estudante 
}
