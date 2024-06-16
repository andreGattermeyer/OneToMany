package br.com.andregattermeyer.onetomany.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.andregattermeyer.onetomany.modelo.Estudante;
import br.com.andregattermeyer.onetomany.serviço.AreaServico;

@Controller
public class AreaControle {
    
    @Autowired
    private AreaServico areaServico;

     @GetMapping("/novo")
    public String novo(Model model) {
        Estudante estudante = new Estudante();
        model.addAttribute("novoEstudante", estudante);
        return "/novo-estudante";
    }
}