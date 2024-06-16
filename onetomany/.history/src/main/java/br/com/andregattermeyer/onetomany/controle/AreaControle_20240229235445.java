package br.com.andregattermeyer.onetomany.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.andregattermeyer.onetomany.modelo.Area;
import br.com.andregattermeyer.onetomany.modelo.Estudante;
import br.com.andregattermeyer.onetomany.serviço.AreaServico;

@Controller
@RequestMapping("/area")
public class AreaControle {
    
    @Autowired
    private AreaServico areaServico;

     @GetMapping("/novo")
    public String novaArea(Model model) {
        Area area = new Area();
        model.addAttribute("novaArea", area);
        return "/nova-area";
    }
}
