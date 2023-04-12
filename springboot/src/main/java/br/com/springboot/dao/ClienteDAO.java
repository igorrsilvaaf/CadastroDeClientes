package br.com.springboot.dao;

import br.com.springboot.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // responsavel por realizar as operaçoes de acesso a dados, inserir, atualizar, deletar
public class ClienteDAO implements CRUD<Object, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Object PesquisaId(Long id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> list() {
        //Query query = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class);
        TypedQuery<Cliente> query = entityManager.createQuery("SELECT C FROM C", Cliente.class);
        try{
            return query.getResultList();
        }catch(NoResultException e){
            return null;
        }
    }


    @Override
    public void insere(Object cliente) throws Exception {
        entityManager.persist(cliente);
    }

    
    @Override
    public void salvar(Object cliente) throws Exception{
        ((ClienteDAO) entityManager).salvar(cliente);
    }

    @Override
    public void atualiza(Object cliente) throws Exception {
        entityManager.merge(cliente);
    }

    @Override
    public void remove(Object cliente) throws Exception {
        entityManager.remove(cliente);
    }
}
