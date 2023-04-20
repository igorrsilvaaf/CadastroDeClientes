package br.com.springboot.Controller;

import br.com.springboot.bo.ClienteBO;
import br.com.springboot.model.Cliente;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private  ClienteBO clienteBO;

    //Novo registro
    @RequestMapping(value = "/novo", method = RequestMethod.GET)
    public ModelAndView novo(ModelMap model) {
        model.addAttribute("cliente", new Cliente());
        return new ModelAndView("/cliente/formulario", model);
    }

    //Salva o formulario no banco de dados
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String salva(@Valid @ModelAttribute Cliente cliente, BindingResult result, RedirectAttributes attr) throws Exception {
        if (result.hasErrors())
            return "/cliente/formulario";
        if(cliente.getId() == null){
            clienteBO.insere(cliente);
            attr.addFlashAttribute("feedback", "Cliente foi cadastrado com sucesso");
        }else{
            clienteBO.atualiza(cliente);
            attr.addFlashAttribute("feedback", "Cliente foi atualizado com sucesso");
        }
        return "redirect:/clientes";
    }

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
            attr.addFlashAttribute("feedback", "Cliente inativado com sucesso");
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
            attr.addFlashAttribute("feedback", "Cliente ativado com sucesso");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/clientes";
    }
}
