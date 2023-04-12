package br.com.springboot.Controller;

import br.com.springboot.bo.ClienteBO;
import br.com.springboot.model.Cliente;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // Indica que esta classe é um controller
@RequestMapping("/Clientes") // Indica o caminho base para os endpoints mapeados nesta classe
public class ClienteController {

    // Injeta uma instância de ClienteBO nesta classe
    @Autowired
    private ClienteBO bo;

    @GetMapping("/novo") // Indica que este método responde a requisições GET no caminho /Clientes/novo
    public ModelAndView novo(@NotNull ModelMap model){
        model.addAttribute("cliente", new Cliente()); // Adiciona um objeto Cliente vazio ao ModelMap com a chave "cliente"
        return new ModelAndView("/Cliente/formulario", model); // Retorna uma nova instância de ModelAndView com o nome da view e o ModelMap como parâmetros
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute("cliente") Cliente cliente) {
        try {
            bo.salvar(cliente);
            return new ModelAndView("/Cliente/formulario");
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("/erro");
        }
    }
}
