package br.com.andregattermeyer.onetomany.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.andregattermeyer.onetomany.modelo.Estudante;

public interface EstudanteRepositorio extends JpaRepository<Estudante, Long>{
    
}
