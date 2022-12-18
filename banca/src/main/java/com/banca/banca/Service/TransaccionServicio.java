package com.banca.banca.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banca.banca.Dao.TransaccionDao;
import com.banca.banca.Models.Transaccion;

@Service
public class TransaccionServicio {
    @Autowired
    private TransaccionDao transaccionDao;

    @Transactional(readOnly=false)
    public Transaccion save(Transaccion transaccion) {
        return transaccionDao.save(transaccion);
    }
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        transaccionDao.deleteById(id);;
    }
    @Transactional(readOnly=true)
    public Transaccion findById(Integer id) {
       return transaccionDao.findById(id).orElse(null);
    }
    @Transactional(readOnly=true)
    public List<Transaccion> findByAll() {
        return (List<Transaccion>) transaccionDao.findAll();
    }
}
