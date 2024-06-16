package br.com.andregattermeyer.onetomany.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.andregattermeyer.onetomany.modelo.Estudante;

@Controller
public class EstudanteControle {

    @GetMapping("/")
    public String listarEstudantes() {
        return "/lista-estudantes";
    }
    
    @GetMapping("/novo")
    public String novoEstudante() {
        Estudante estudante = new Estudante()
        return "/novo-estudante";
    }
}
