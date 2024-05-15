package br.senac.nicecomics.nicecomics.controllers;

import br.senac.nicecomics.nicecomics.models.Titulo;
import br.senac.nicecomics.nicecomics.models.TituloDetalhado;
import br.senac.nicecomics.nicecomics.repositories.TituloDetalhadoRepository;
import java.text.DecimalFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/titulosDetalhados")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TituloDetalhadoController {
    
    @Autowired
    private TituloDetalhadoRepository tituloDetalhadoRepository;
    
    @GetMapping(value = "/{id}")
    public TituloDetalhado findTituloDetalhadoById(@PathVariable Long id) {
        return tituloDetalhadoRepository.findTituloDetalhadoById(id);
    }
    
    @GetMapping
    public List<TituloDetalhado> listarTitulos() {
        
        List<TituloDetalhado> listaTitulos = tituloDetalhadoRepository.findAllTituloDetalhado();
        
        DecimalFormat df = new DecimalFormat("###,00");
        
        for (TituloDetalhado titulo : listaTitulos) {
            double precoFormatado = Double.parseDouble(df.format(titulo.getPrecoTitulo()));
            titulo.setPrecoTitulo(precoFormatado);
        }
        
        return listaTitulos;
    }
    
}
