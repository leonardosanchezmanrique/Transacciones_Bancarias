package com.banca.banca.Controller;
import com.banca.banca.Models.Transaccion;
import com.banca.banca.Dao.TransaccionDao;
import com.banca.banca.Service.TransaccionServicio;

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
@RequestMapping("/transaccion")
public class TransaccionController {
    
    @Autowired
    private TransaccionDao transaccionDao;

    @Autowired
    private TransaccionServicio transaccionServicio;
    
    @PostMapping(value="/")
    public ResponseEntity<Transaccion> agregar(@RequestBody Transaccion transaccion){        
        Transaccion obj = transaccionServicio.save(transaccion);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
    
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<Transaccion> eliminar(@PathVariable Integer id){ 
        Transaccion obj = transaccionServicio.findById(id); 
        if(obj!=null) 
        transaccionServicio.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @PutMapping(value="/") 
    public ResponseEntity<Transaccion> editar(@RequestBody Transaccion transaccion){ 
        Transaccion obj = transaccionServicio.findById(transaccion.getId_transaccion()); 
        if(obj!=null) {
            
            obj.setValor_transaccion(transaccion.getValor_transaccion());
            
            transaccionServicio.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @GetMapping("/list")
    public List<Transaccion> consultarTodo(){
        return transaccionServicio.findByAll(); 
    }
    
    @GetMapping("/list/{id}") 
    public Transaccion consultaPorId(@PathVariable Integer id){ 
        return transaccionServicio.findById(id); 
    }
}

