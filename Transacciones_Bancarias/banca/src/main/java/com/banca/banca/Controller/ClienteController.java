package com.banca.banca.Controller;
import com.banca.banca.Models.Cliente;
import com.banca.banca.Dao.ClienteDao;
import com.banca.banca.Service.ClienteServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteDao clienteDao; 
    @Autowired
    private ClienteServicio clienteServicio;
    
    @PostMapping(value="/")
    public ResponseEntity<Cliente> agregar(@RequestBody Cliente cliente){        
        Cliente obj = clienteServicio.save(cliente);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
   
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<Cliente> eliminar(@PathVariable String id){ 
        Cliente obj = clienteServicio.findById(id); 
        if(obj!=null) 
            clienteServicio.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @PutMapping(value="/") 
    public ResponseEntity<Cliente> editar(@RequestBody Cliente cliente){ 
        Cliente obj = clienteServicio.findById(cliente.getId_cliente()); 
        if(obj!=null) { 
            obj.setNombre_cliente(cliente.getNombre_cliente());
            obj.setClave_cliente(cliente.getClave_cliente());
            clienteServicio.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @GetMapping("/list") 
    public List<Cliente> consultarTodo(){
        return clienteServicio.findAll(); 
    }
    
    @GetMapping("/list/{id}") 
    public Cliente consultaPorId(@PathVariable String id){ 
        return clienteServicio.findById(id); 
    }
    
}
