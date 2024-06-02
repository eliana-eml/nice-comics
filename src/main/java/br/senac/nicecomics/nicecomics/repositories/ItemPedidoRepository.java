package br.senac.nicecomics.nicecomics.repositories;

import br.senac.nicecomics.nicecomics.models.ItemPedido;
import br.senac.nicecomics.nicecomics.models.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

//    public List<ItemPedido> findByPedido(Long pedido);
    
    @Query(value = "SELECT id_item_pedido, qtd_titulo_item, valor_unitario_item, "
                 + "id_pedido, id_titulo FROM item_pedido WHERE id_pedido = ?1", nativeQuery = true)
    List<ItemPedido> findAllItemPedidoByIdPedido(Long id);
    
}
