package br.senac.nicecomics.nicecomics.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "titulos")
public class Titulo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTitulo;
 
    private String nomeTitulo;
    private int qtdPaginasTitulo;
    private double precoTitulo;
    private String tipoTitulo;
    private String generoTitulo;
    private String urlCapaTitulo;
    private char promocaoTitulo;
    private String categoriaTitulo;
    private int idAutor;
    private int idEditora;

    public Long getIdTitulo() {
        return idTitulo;
    }

    public void setIdTitulo(Long idTitulo) {
        this.idTitulo = idTitulo;
    }

    public String getNomeTitulo() {
        return nomeTitulo;
    }

    public void setNomeTitulo(String nomeTitulo) {
        this.nomeTitulo = nomeTitulo;
    }

    public int getQtdPaginasTitulo() {
        return qtdPaginasTitulo;
    }

    public void setQtdPaginasTitulo(int qtdPaginasTitulo) {
        this.qtdPaginasTitulo = qtdPaginasTitulo;
    }

    public double getPrecoTitulo() {
        return precoTitulo;
    }

    public void setPrecoTitulo(double precoTitulo) {
        this.precoTitulo = precoTitulo;
    }

    public String getTipoTitulo() {
        return tipoTitulo;
    }

    public void setTipoTitulo(String tipoTitulo) {
        this.tipoTitulo = tipoTitulo;
    }

    public String getGeneroTitulo() {
        return generoTitulo;
    }

    public void setGeneroTitulo(String generoTitulo) {
        this.generoTitulo = generoTitulo;
    }

    public String getUrlCapaTitulo() {
        return urlCapaTitulo;
    }

    public void setUrlCapaTitulo(String urlCapaTitulo) {
        this.urlCapaTitulo = urlCapaTitulo;
    }

    public char getPromocaoTitulo() {
        return promocaoTitulo;
    }

    public void setPromocaoTitulo(char promocaoTitulo) {
        this.promocaoTitulo = promocaoTitulo;
    }

    public String getCategoriaTitulo() {
        return categoriaTitulo;
    }

    public void setCategoriaTitulo(String categoriaTitulo) {
        this.categoriaTitulo = categoriaTitulo;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
    }
    
}
