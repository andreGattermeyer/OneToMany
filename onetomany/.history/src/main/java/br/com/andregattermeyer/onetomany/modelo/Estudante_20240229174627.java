package br.com.andregattermeyer.onetomany.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.)
    private Long id;
    
}
