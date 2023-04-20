package br.com.springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;


@Entity // A anotação @Entity indica que essa classe é uma entidade JPA e pode ser persistida no banco de dados
@Table(name="clientes") // Define o nome da tabela que sera criada para essa entidade no BD

// Definicao da classe cliente
public class Cliente {
    @Id // Atributo que representa a chave primária da entidade no banco de dados.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração de valores para a chave primária
    private Long id;

    @Column(nullable = false, length = 50) // Define o nome da coluna no banco de dados, a obrigatoriedade e o tamanho máximo do campo
    @NotBlank(message = "Informe seu nome completo")
    @Size(min = 10, max = 100)
    private String nome; //Atributo que representa o nome do cliente.

    @Column(length = 20) // Define o tamanho máximo do campo
    @CPF(message = "Informe um CPF válido")
    private String cpf;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // Define o formato de data esperado para o campo.
    @Column(name = "data_nascimento", columnDefinition = "DATE") // Define o nome da coluna no banco de dados e o tipo de dados
    private LocalDate DataDeNascimento;

    @Enumerated(EnumType.STRING) // Define que o atributo é um enum e deve ser persistido como uma string.
    @NotNull(message = "Obrigatório o preenchimento do campo SEXO")
    private Sexo sexo;

    @Column(length = 15)
    private String telefone;

    @Column(length = 15)
    @NotNull(message = "Obrigatório o preenchimento do celular")
    private String celular;

    @Column(length = 50)
    @jakarta.validation.constraints.Email
    private String Email;


    private boolean ativo; // Atributo que indica se o cliente está ativo ou não

    public Cliente(){
        this.ativo = true;
    }
    // Getters e Setters para os atributos da classe
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
        return DataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        DataDeNascimento = dataDeNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
