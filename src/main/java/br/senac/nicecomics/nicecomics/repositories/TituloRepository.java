package br.senac.nicecomics.nicecomics.repositories;

import br.senac.nicecomics.nicecomics.models.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TituloRepository extends JpaRepository<Titulo, Long>{
    
}
