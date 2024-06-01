package br.senac.nicecomics.nicecomics.repositories;

import br.senac.nicecomics.nicecomics.models.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "SELECT id_pedido, data_pedido, valor_total_pedido, id_cliente "
            + "FROM pedidos WHERE id_cliente = ?1", nativeQuery = true)
    List<Pedido> findAllPedidosByIdCliente(Long id);
}
