package br.com.andregattermeyer.onetomany.modelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição deve ser informada.")
    @Size(min = 2, message = "A de deve ter no mínimo 02 caracteres")
    private String descricao;
}
