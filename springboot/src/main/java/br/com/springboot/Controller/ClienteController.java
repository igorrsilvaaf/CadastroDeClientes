package br.com.springboot.Controller;

import br.com.springboot.bo.ClienteBO;
import br.com.springboot.model.Cliente;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

    private final ClienteBO bo;

    public ClienteController(ClienteBO bo) {
        this.bo = bo;
    }

    @RequestMapping("/clientes/novo")
    public String novo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "Cliente/formulario";
    }

    @PostMapping("/clientes/salvar")
    public ModelAndView salva(@ModelAttribute Cliente cliente) throws Exception {
        bo.insere(cliente);
        return new ModelAndView("redirect:/clientes/novo");
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView lista(ModelMap model) {
        model.addAttribute("clientes", bo.listaTodos());
        return new ModelAndView("/Cliente/Lista", model);
    }
}
