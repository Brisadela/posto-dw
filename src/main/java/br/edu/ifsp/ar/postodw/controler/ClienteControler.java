package br.edu.ifsp.ar.postodw.controler;

import br.edu.ifsp.ar.postodw.model.Bomba;
import br.edu.ifsp.ar.postodw.model.Cliente;
import br.edu.ifsp.ar.postodw.service.BombaService;
import br.edu.ifsp.ar.postodw.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteControler {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> list(){
        return clienteService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        return clienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@Valid @RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        clienteService.deleteById(id);
    }
}
