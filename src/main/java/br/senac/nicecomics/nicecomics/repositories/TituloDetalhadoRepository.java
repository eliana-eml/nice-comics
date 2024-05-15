package br.senac.nicecomics.nicecomics.repositories;

import br.senac.nicecomics.nicecomics.models.TituloDetalhado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TituloDetalhadoRepository extends JpaRepository<TituloDetalhado, Long>{
    
    @Query(value =  "SELECT t.id_titulo, t.nome_titulo, t.url_capa_titulo, t.qtd_paginas_titulo,\n" 
                +   "t.preco_titulo, t.tipo_titulo, a.nome_autor, e.nome_editora FROM \n" 
                +   "titulos t INNER JOIN autores a ON t.id_autor = a.id_autor\n" 
                +   "INNER JOIN editoras e ON t.id_editora = e.id_editora"
                +   " WHERE t.id_titulo = ?1", nativeQuery = true)
    TituloDetalhado findTituloDetalhadoById(Long id);
    
    @Query(value =  "SELECT t.id_titulo, t.nome_titulo, t.url_capa_titulo, t.qtd_paginas_titulo,\n" 
                +   "t.preco_titulo, t.tipo_titulo, a.nome_autor, e.nome_editora FROM \n" 
                +   "titulos t INNER JOIN autores a ON t.id_autor = a.id_autor\n" 
                +   "INNER JOIN editoras e ON t.id_editora = e.id_editora", nativeQuery = true)
    List<TituloDetalhado> findAllTituloDetalhado();
}
