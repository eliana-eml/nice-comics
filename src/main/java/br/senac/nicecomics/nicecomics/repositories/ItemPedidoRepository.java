package br.senac.nicecomics.nicecomics.repositories;

import br.senac.nicecomics.nicecomics.models.ItemPedido;
import br.senac.nicecomics.nicecomics.models.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

//    public List<ItemPedido> findByPedido(Long pedido);
    
}
