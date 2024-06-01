package br.senac.nicecomics.nicecomics.controllers;

import br.senac.nicecomics.nicecomics.models.Cliente;
import br.senac.nicecomics.nicecomics.repositories.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listarClientes() {
        List<Cliente> listaClientes = clienteRepository.findAll();
        return listaClientes;
    }

    @GetMapping(value = "/{id}")
    public Cliente findById(@PathVariable Long id) {
        Cliente result = clienteRepository.findById(id).get();
        return result;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {

        if (clienteRepository.existsByEmailCliente(cliente.getEmailCliente())) {
            return ResponseEntity.badRequest().body(null);
        }

        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @PostMapping("/login")
    public ResponseEntity<Cliente> efetuarLogin(@RequestBody Cliente cliente) {

        Cliente clienteEncontrado = clienteRepository.findByEmailCliente(cliente.getEmailCliente());

        if (clienteEncontrado == null || !clienteEncontrado.getSenhaCliente().equals(cliente.getSenhaCliente())) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clienteEncontrado);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cliente> atualizarCadastroCliente(@RequestBody Cliente cliente) {

        Cliente clienteAlterado = clienteRepository.save(cliente);
        return ResponseEntity.ok(clienteAlterado);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirCadastroCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content após a exclusão
    }
}
