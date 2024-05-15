package br.senac.nicecomics.nicecomics.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "titulosDetalhados")
public class TituloDetalhado {
    
    @Id
    private Long idTitulo;
    private String nomeTitulo;
    private String urlCapaTitulo;
    private int qtdPaginasTitulo;
    private double precoTitulo;
    private String tipoTitulo;
    private String nomeAutor;
    private String nomeEditora;

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

    public String getUrlCapaTitulo() {
        return urlCapaTitulo;
    }

    public void setUrlCapaTitulo(String urlCapaTitulo) {
        this.urlCapaTitulo = urlCapaTitulo;
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

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }
    
}
