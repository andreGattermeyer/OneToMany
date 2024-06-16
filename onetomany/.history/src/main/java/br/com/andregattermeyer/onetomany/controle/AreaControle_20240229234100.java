package br.com.andregattermeyer.onetomany.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.andregattermeyer.onetomany.serviço.AreaServico;

@Controller
public class AreaControle {
    
    @Autowired
    private AreaServico areaServico;
}
