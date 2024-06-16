package br.com.andregattermeyer.onetomany.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.andregattermeyer.onetomany.modelo.Estudante;
import br.com.andregattermeyer.onetomany.serviço.EstudanteServico;
import jakarta.validation.Valid;

@Controller
public class EstudanteControle {

    @Autowired
    private EstudanteServico estudanteServico;

    @GetMapping("/")
    public String listarEstudantes(Model model) {
        List<Estudante> estudantes = estudanteServico.buscarTodosEstudantes();
        model.addAttribute("listaEstudantes", estudantes);
        return "/lista-estudantes";
    }

    @GetMapping("/novo")
    public String novoEstudante(Model model) {
        Estudante estudante = new Estudante();
        model.addAttribute("novoEstudante", estudante);
        return "/novo-estudante";
    }

    @PostMapping("/gravar")
    public String gravarEstudante(@ModelAttribute("novoEstudante") @Valid Estudante estudante,
            BindingResult erros,
            RedirectAttributes attributes) {
                if (erros.hasErrors()) {
                    return "/novo-estudante";
                }
        estudanteServico.criarEstudante(estudante);
        attributes.addFlashAttribute("mensagem", "Estudante salvo ccom sucesso!");
        return "redirect:/novo";
    }

    @GetMapping("/apagar/{id}")
    public String apagarEstudante(@PathVariable("id") long id) {
        System.out.println("id" + id);
        return "redirect:/";
    }

}
