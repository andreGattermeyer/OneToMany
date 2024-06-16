package br.com.andregattermeyer.onetomany.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.andregattermeyer.onetomany.modelo.Estudante;
import br.com.andregattermeyer.onetomany.serviço.EstudanteServico;

@Controller
public class EstudanteControle {

    @Autowired
    private EstudanteServico estudanteServico;

    @GetMapping("/")
    public String listarEstudantes() {
        return "/lista-estudantes";
    }
    
    @GetMapping("/novo")
    public String novoEstudante(Model model) {
        Estudante estudante = new Estudante();
        model.addAttribute("novoEstudante", estudante);
        return "/novo-estudante";
    }

    @PostMapping("/gravar")
    public String gravarEstudante(@ModelAttribute("novoEstudante") Estudante estudante) {

        return "/novo-estudante";

    }
}
