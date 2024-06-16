package br.com.andregattermeyer.onetomany.serviço;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudanteServico {
    
    @Autowired
    private EstudanteRepositorio estudanteRepositorio;
}
