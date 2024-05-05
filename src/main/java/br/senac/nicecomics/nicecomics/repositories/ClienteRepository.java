package br.senac.nicecomics.nicecomics.repositories;

import br.senac.nicecomics.nicecomics.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    Cliente findByEmailCliente(String emailCliente);
    boolean existsByEmailCliente(String emailCliente);
}
