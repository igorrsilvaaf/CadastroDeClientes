package br.com.springboot.bo;

import br.com.springboot.dao.ClienteDAO;
import br.com.springboot.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteBO {

    private static ClienteDAO dao;

    public ClienteBO(ClienteDAO dao) {
        ClienteBO.dao = dao;
    }


    public Cliente PesquisaId(Long id) {
        return dao.PesquisaId(id);
    }

    public static List<Cliente> listaTodos() {
        return dao.listaTodos();
    }

    public void insere(Cliente cliente) throws Exception {
        dao.insere(cliente);
    }


    public void atualiza(Cliente cliente) throws Exception {
        dao.atualiza(cliente);
    }

    public void remove(Cliente cliente) throws Exception {
        dao.remove(cliente);
    }


    public void inativa(@org.jetbrains.annotations.NotNull Cliente cliente) throws Exception {
        cliente.setAtivo(false);
        atualiza(cliente);
    }

    public void ativa(Cliente cliente) throws Exception {
        cliente.setAtivo(true);
        dao.atualiza(cliente);
    }
}
