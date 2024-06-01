package br.senac.nicecomics.nicecomics.controllers;

import br.senac.nicecomics.nicecomics.models.ItemPedido;
import br.senac.nicecomics.nicecomics.models.Pedido;
import br.senac.nicecomics.nicecomics.repositories.ItemPedidoRepository;
import br.senac.nicecomics.nicecomics.repositories.PedidoRepository;
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
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PedidoController {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    
    @GetMapping("/listar")
    public List<Pedido> listarPedidos() {
        List<Pedido> listaPedidos = pedidoRepository.findAll();
        return listaPedidos;
    }
    
    @GetMapping(value = "/listar/{id}")
    public Pedido findById(@PathVariable Long id) {
        Pedido result = pedidoRepository.findById(id).get();
        return result;     
    }
    
    @GetMapping(value = "/listar/cliente/{id}")
    public List<Pedido> findByIdCliente(@PathVariable Long id) {
        List<Pedido> result = pedidoRepository.findAllPedidosByIdCliente(id);
        return result;     
    }
    
    @PostMapping
    public ResponseEntity<Pedido> cadastrarPedido(@RequestBody Pedido pedido) {
                
        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        
        for (ItemPedido item : pedido.getListaItensPedido()) {
            item.setIdPedido(pedidoSalvo);
            itemPedidoRepository.save(item);
        }
              
        return ResponseEntity.ok(pedidoSalvo);
    }
    
}
