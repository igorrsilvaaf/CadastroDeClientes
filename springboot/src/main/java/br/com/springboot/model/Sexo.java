package br.com.springboot.model;

// Definição do enum Sexo
public enum Sexo {

    // Valores possíveis do enum
    MASCULINO("M"), // Masculino
    FEMININO("F"); // Feminino

    // Atributo que armazena a descrição correspondente a cada valor
    private String descricao;

    // Construtor do enum que recebe a descrição correspondente a cada valor
    Sexo(String descricao){
        this.descricao = descricao;
    }

    // Getter que retorna a descrição correspondente ao valor do enum
    public String getDescricao(){
        return this.descricao;
    }
}
