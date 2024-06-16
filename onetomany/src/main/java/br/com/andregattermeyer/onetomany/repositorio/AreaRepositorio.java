package br.com.andregattermeyer.onetomany.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.andregattermeyer.onetomany.modelo.Area;

public interface AreaRepositorio extends JpaRepository<Area, Long>{
    
}
