package br.com.springboot.dao;

import br.com.springboot.model.Cliente;

import java.util.List;

public interface CRUD<T, ID> { // T = template
    T PesquisaId(ID id);
    List<Cliente> list();
    void insere(T t) throws Exception;
    void atualiza(T t) throws Exception;
    void remove(T t) throws Exception;
}
