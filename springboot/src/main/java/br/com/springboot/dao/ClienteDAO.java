package br.com.springboot.dao;

import br.com.springboot.model.Cliente;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Transactional// responsavel por realizar as operaçoes de acesso a dados, inserir, atualizar, deletar

public class ClienteDAO implements CRUD<Cliente, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cliente PesquisaId(Long id) {
        return entityManager.find(Cliente.class, id);
    }

    public List<Cliente> listaTodos(){
        TypedQuery<Cliente> query = entityManager.createQuery("SELECT c FROM clientes c", Cliente.class);
        try{
            return query.getResultList();
        }catch(NoResultException e){
            return null;
        }
    }

    @Override
    public void insere(Cliente cliente) {
        entityManager.persist(cliente);
    }

    @Override
    public void atualiza(Cliente cliente) {
        entityManager.merge(cliente);
    }

    @Override
    public void remove(Cliente cliente) {
        entityManager.remove(cliente);
    }
}
