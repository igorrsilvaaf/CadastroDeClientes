package br.com.springboot.bo;

import br.com.springboot.dao.ClienteDAO;
import br.com.springboot.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteBO {

    private final ClienteDAO dao;

    @Autowired
    public ClienteBO(ClienteDAO dao) {
        this.dao = dao;
    }

    public Cliente PesquisaId(Long id) {
        return (Cliente) dao.PesquisaId(id);
    }

    public List<Cliente> list() {
        return dao.list();
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

    public void inativar(Cliente cliente) throws Exception {
        cliente.setAtivo(false);
        atualiza(cliente);
    }

    public void ativar(Cliente cliente) throws Exception {
        cliente.setAtivo(true);
        atualiza(cliente);
    }
}
