package br.com.springboot.Controller;

import br.com.springboot.bo.ClienteBO;
import br.com.springboot.model.Cliente;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

    @Autowired
    private ClienteBO bo;

    @GetMapping("/clientes/novo")
    public String novo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "Cliente/formulario";
    }

    @PostMapping("/clientes/salvar")
    public ModelAndView salva(@ModelAttribute Cliente cliente) throws Exception {
        bo.insere(cliente);
        return new ModelAndView("redirect:/clientes/novo");
    }

    @ControllerAdvice
    public static class ErrorHandler {
        @ExceptionHandler(value = { Exception.class })
        @ResponseBody
        public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("Cliente/Error");
            mav.addObject("exception", e);
            mav.addObject("url", request.getRequestURL());
            return mav;
        }
    }
}
