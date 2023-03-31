package br.com.springboot.model;

public enum Sexo {
    MASCULINO("M"),
    FEMININO("F");

    private final String descricao;

    Sexo(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }
}