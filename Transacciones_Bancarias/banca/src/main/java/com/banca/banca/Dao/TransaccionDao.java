package com.banca.banca.Dao;
import com.banca.banca.Models.Transaccion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionDao  extends CrudRepository<Transaccion, Integer> {
    
}
