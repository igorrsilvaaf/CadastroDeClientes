package br.com.springboot.BO;

import br.com.springboot.model.Cliente;
import br.com.springboot.model.Sexo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import  br.com.springboot.dao.ClienteDAO;

import java.time.LocalDate;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClienteBOTest {

    @Autowired
    private ClienteDAO dao;

    @Test
    @Order(1)
    public void insere() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNome("Igor da silva");
        cliente.setCpf("10287794962");
        cliente.setDataDeNascimento(LocalDate.of(1995, 12, 16));
        cliente.setSexo(String.valueOf(Sexo.MASCULINO));
        cliente.setCelular("48991781573");
        cliente.setTelefone("0123456789");
        cliente.setEmail("teste@teste.com");
        cliente.setAtivo(true);
        dao.insere(cliente);
    }

    @Test
    @Order(2)
    public void PesquisaId(){
        Cliente cliente = (Cliente) dao.PesquisaId(1L);
        System.out.println(cliente);
    }

    @Test
    @Order(3)
    public void atualizar() throws Exception {
        Cliente cliente = (Cliente) dao.PesquisaId(1L);
        cliente.setCpf("00000000000");
        dao.atualiza(cliente);
    }

    @Test
    @Order(4)
    public void remover() throws Exception {
        Cliente cliente = (Cliente) dao.PesquisaId(1L);
        dao.remove(cliente);
    }
}