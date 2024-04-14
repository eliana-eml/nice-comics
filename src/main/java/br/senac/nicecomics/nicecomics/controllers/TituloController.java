package br.senac.nicecomics.nicecomics.controllers;

import br.senac.nicecomics.nicecomics.models.Titulo;
import br.senac.nicecomics.nicecomics.repositories.TituloRepository;
import java.text.DecimalFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/titulos")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TituloController {
    
    @Autowired
    private TituloRepository tituloRepository;
    
    @GetMapping
    public List<Titulo> listarTitulos() {
        List<Titulo> listaTitulos = tituloRepository.findAll();
        
        DecimalFormat df = new DecimalFormat("###,00");
        
        for (Titulo titulo : listaTitulos) {
            double precoFormatado = Double.parseDouble(df.format(titulo.getPreco()));
            titulo.setPreco(precoFormatado);
        }
        
        return listaTitulos;
    }
    
    @GetMapping(value = "/{id}")
    public Titulo findById(@PathVariable Long id) {
        Titulo result = tituloRepository.findById(id).get();
        return result;
    }
}
