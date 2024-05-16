package br.senac.nicecomics.nicecomics.repositories;

import br.senac.nicecomics.nicecomics.models.Titulo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TituloRepository extends JpaRepository<Titulo, Long> {

    @Query(value = "SELECT id_titulo, nome_titulo, qtd_paginas_titulo, preco_titulo, "
            + "tipo_titulo, genero_titulo, url_capa_titulo,\n"
            + " promocao_titulo, categoria_titulo, id_autor, id_editora \n"
            + " FROM titulos WHERE categoria_titulo = ?1", nativeQuery = true)
    List<Titulo> findAllByCategoriaTitulo(String nomeCategoria);
}
