package br.senac.nicecomics.nicecomics.repositories;

import br.senac.nicecomics.nicecomics.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}
