package br.senac.nicecomics.nicecomics.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "titulos")
public class Titulo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String nome;
    private String autor;
    private String editora;
    private int qtdpaginas;
    private double preco;
    private String tipo;
    private String genero;
    private String urlcapa;
    private char promocao;

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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getQtdpaginas() {
        return qtdpaginas;
    }

    public void setQtdpaginas(int qtdpaginas) {
        this.qtdpaginas = qtdpaginas;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUrlcapa() {
        return urlcapa;
    }

    public void setUrlcapa(String urlcapa) {
        this.urlcapa = urlcapa;
    }

    public char getPromocao() {
        return promocao;
    }

    public void setPromocao(char promocao) {
        this.promocao = promocao;
    }
    
}
