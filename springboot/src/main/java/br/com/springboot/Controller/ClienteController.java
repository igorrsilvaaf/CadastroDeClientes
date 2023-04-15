package br.com.springboot.Controller;

import br.com.springboot.bo.ClienteBO;
import br.com.springboot.model.Cliente;
<<<<<<< HEAD
=======

>>>>>>> 2aadf07ec80bd4787b324b91652fa3950ae925d3
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

<<<<<<< HEAD
    private final ClienteBO clienteBO;
=======
    private final ClienteBO bo;

    public ClienteController(ClienteBO bo) {
        this.bo = bo;
    }
>>>>>>> 2aadf07ec80bd4787b324b91652fa3950ae925d3

    public ClienteController(ClienteBO clienteBO) {
        this.clienteBO = clienteBO;
    }

    //Novo registro
    @RequestMapping(value = "/novo", method = RequestMethod.GET)
    public ModelAndView novo(ModelMap model) {
        model.addAttribute("cliente", new Cliente());
        return new ModelAndView("cliente/formulario", model);
    }

<<<<<<< HEAD
    //Salva o formulario no banco de dados
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String salva(@ModelAttribute Cliente cliente) throws Exception {
        clienteBO.insere(cliente);
        return "/cliente/fomulario";
    }
=======
    @PostMapping("/clientes/salvar")
    public ModelAndView salva(@ModelAttribute Cliente cliente) throws Exception {
        bo.insere(cliente);
        return new ModelAndView("redirect:/clientes/novo");
    }

>>>>>>> 2aadf07ec80bd4787b324b91652fa3950ae925d3

    //Lista os cadastros salvos em nosso banco
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView lista(ModelMap model) {
        model.addAttribute("clientes", ClienteBO.listaTodos());
        return new ModelAndView("/cliente/lista", model);
    }

    //Edita o cadastro do cliente
    @RequestMapping(value = "/edita/{id}", method = RequestMethod.GET)
    public ModelAndView edita(@PathVariable("id") Long id, ModelMap model){
        try{
            model.addAttribute("cliente", clienteBO.PesquisaId(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ModelAndView("/cliente/formulario", model);
    }

    //Inativa o cliente
    @RequestMapping(value = "/inativa/{id}", method = RequestMethod.GET)
    public String inativa(@PathVariable("id") Long id, RedirectAttributes attr){
        System.out.println(id);
        try{
            Cliente cliente = clienteBO.PesquisaId(id);
            clienteBO.inativa(cliente);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/clientes";
    }

    @RequestMapping(value = "/ativa/{id}", method = RequestMethod.GET)
    public String ativa(@PathVariable("id") Long id, RedirectAttributes attr){
        System.out.println(id);
        try{
            Cliente cliente = clienteBO.PesquisaId(id);
            clienteBO.ativa(cliente);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/clientes";
    }
}
