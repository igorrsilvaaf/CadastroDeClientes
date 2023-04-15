package br.com.springboot.bo;

import br.com.springboot.dao.ClienteDAO;
import br.com.springboot.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


@Service
public class ClienteBO {

    private static ClienteDAO dao;

    public ClienteBO(ClienteDAO dao) {
        ClienteBO.dao = dao;
    }


    public Cliente PesquisaId(Long id) {
        return (Cliente) dao.PesquisaId(id);
    }

    public static List<Cliente> listaTodos() {
        return dao.listaTodos();
    }

    public void insere(Cliente cliente) throws Exception {
        dao.insere(cliente);
    }

    public void salvar(Cliente cliente) throws Exception {
        dao.salvar(cliente);
    }

    public void atualiza(Cliente cliente) throws Exception {
        dao.atualiza(cliente);
    }

    public void remove(Cliente cliente) throws Exception {
        dao.remove(cliente);
    }


<<<<<<< HEAD
    public void inativa(@org.jetbrains.annotations.NotNull Cliente cliente) throws Exception {
=======
    public void inativar(@org.jetbrains.annotations.NotNull Cliente cliente) throws Exception {
>>>>>>> 2aadf07ec80bd4787b324b91652fa3950ae925d3
        cliente.setAtivo(false);
        atualiza(cliente);
    }

<<<<<<< HEAD
    public void ativa(Cliente cliente) throws Exception {
        cliente.setAtivo(true);
        dao.atualiza(cliente);
    }
=======
    public List<Cliente> listaTodos() {
        List<Object> clientes = Collections.singletonList(dao.listaTodos());
        List<Cliente> clientesConvertidos = new ArrayList<>();
        for (Object cliente : clientes) {
            clientesConvertidos.add((Cliente) cliente);
        }
        return clientesConvertidos;
    }

>>>>>>> 2aadf07ec80bd4787b324b91652fa3950ae925d3
}
