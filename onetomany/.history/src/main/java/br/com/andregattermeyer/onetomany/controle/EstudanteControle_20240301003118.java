package br.com.andregattermeyer.onetomany.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.andregattermeyer.onetomany.exceção.EstudanteNotFoundException;
import br.com.andregattermeyer.onetomany.modelo.Estudante;
import br.com.andregattermeyer.onetomany.serviço.AreaServico;
import br.com.andregattermeyer.onetomany.serviço.EstudanteServico;
import jakarta.validation.Valid;

@Controller
public class EstudanteControle {

    @Autowired
    private EstudanteServico estudanteServico;

    @Autowired
    private AreaServico areaServico;

    @GetMapping("/")
    public String listarEstudantes(Model model) {
        List<Estudante> estudantes = estudanteServico.buscarTodosEstudantes();
        model.addAttribute("listaEstudantes", estudantes);
        return "/lista-estudantes";
    }

    @PostMapping("/buscar")
    public String buscarEstudantes(Model model, @Param("nome") String nome) {
        if (nome == null) {
            return "redirect:/";
        }
        List<Estudante> estudantes = estudanteServico.buscarTodosEstudantesPorNome(nome);
        model.addAttribute("listaEstudantes", estudantes);
        return "/lista-estudantes";
    }

    @GetMapping("/novo")
    public String novoEstudante(Model model) {
        Estudante estudante = new Estudante();
        model.addAttribute("novoEstudante", estudante);

        List<Area> areas = areaServico.listar()
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
    public String apagarEstudante(@PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            estudanteServico.apagarEstudante(id);
        } catch (EstudanteNotFoundException e) {
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
        }
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") long id, RedirectAttributes attributes, Model model) {
        try {
            Estudante estudante = estudanteServico.buscarEstudantePorId(id);
            model.addAttribute("objetoEstudante", estudante);
            return "/alterar-estudante";
        } catch (EstudanteNotFoundException e) {
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
        }
        return "redirect:/";
    }

    @PostMapping("/editar/{id}")
    public String editarEstudante(@PathVariable("id") long id,
            @ModelAttribute("objetoEstudante") @Valid Estudante estudante,
            BindingResult erros) {
        if (erros.hasErrors()) {
            estudante.setId(id);
            return "/alterar-estudante";
        }
        estudanteServico.alterarEstudante(estudante);
        return "redirect:/";
    }

}
