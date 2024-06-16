package br.com.andregattermeyer.onetomany.serviço;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andregattermeyer.onetomany.modelo.Area;
import br.com.andregattermeyer.onetomany.repositorio.AreaRepositorio;

@Service
public class AreaServico {
    
    @Autowired
    private AreaRepositorio areaRepositorio;

    public Area gravar(Area area) {
       return areaRepositorio.save(area);
    }
}
