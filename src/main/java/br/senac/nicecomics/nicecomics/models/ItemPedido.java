package br.senac.nicecomics.nicecomics.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "item_pedido")
public class ItemPedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemPedido;
    
    private int qtdTituloItem;
    private double valorUnitarioItem;
    private Long idTitulo;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    @JsonIgnore
    private Pedido idPedido;

    public Long getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(Long idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public int getQtdTituloItem() {
        return qtdTituloItem;
    }

    public void setQtdTituloItem(int qtdTituloItem) {
        this.qtdTituloItem = qtdTituloItem;
    }

    public double getValorUnitarioItem() {
        return valorUnitarioItem;
    }

    public void setValorUnitarioItem(double valorUnitarioItem) {
        this.valorUnitarioItem = valorUnitarioItem;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdTitulo() {
        return idTitulo;
    }

    public void setIdTitulo(Long idTitulo) {
        this.idTitulo = idTitulo;
    }


    
    
}
