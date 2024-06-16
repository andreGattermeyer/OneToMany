package br.com.andregattermeyer.onetomany.serviço;

import org.springframework.stereotype.Service;

import br.com.andregattermeyer.onetomany.repositorio.AreaRepositorio;

@Service
public class AreaServico {
    
    @Aut
    private AreaRepositorio areaRepositorio;
}
