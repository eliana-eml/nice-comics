package br.senac.nicecomics.nicecomics.controllers;

import br.senac.nicecomics.nicecomics.models.ItemPedido;
import br.senac.nicecomics.nicecomics.repositories.ItemPedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemspedido")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ItemPedidoController {
    
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    
    @GetMapping("/listar")
    public List<ItemPedido> listarItensPedido() {
        List<ItemPedido> listaItensPedido = itemPedidoRepository.findAll();
        return listaItensPedido;
    }
    
    @GetMapping(value = "/{id}")
    public ItemPedido findById(@PathVariable Long id) {
        ItemPedido resultado = itemPedidoRepository.findById(id).get();
        return resultado;
    }
    
    @GetMapping(value = "/listar/pedido/{id}")
    public List<ItemPedido> findByIdPedido(@PathVariable Long id) {
        List<ItemPedido> result = itemPedidoRepository.findAllItemPedidoByIdPedido(id);
        return result;     
    }
    
    @PostMapping
    public ResponseEntity<ItemPedido> cadastrarItemPedido(@RequestBody ItemPedido item) {
        ItemPedido itemSalvo = itemPedidoRepository.save(item);
        
        return ResponseEntity.ok(itemSalvo);
    }
}
