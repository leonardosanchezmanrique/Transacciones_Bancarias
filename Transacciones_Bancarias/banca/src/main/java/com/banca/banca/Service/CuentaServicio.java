package com.banca.banca.Service;
import com.banca.banca.Models.Cuenta;
import com.banca.banca.Dao.CuentaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

@Service
public class CuentaServicio {
    @Autowired
    private CuentaDao cuentaDao;
    
    @Transactional(readOnly=false)
    public Cuenta save(Cuenta cuenta) {
        return cuentaDao.save(cuenta);
    }
    @Transactional(readOnly=false)
    public void delete(String id) {
        cuentaDao.deleteById(id);;
    }
    @Transactional(readOnly=true)
    public Cuenta findById(String id) {
       return cuentaDao.findById(id).orElse(null);
    }
    @Transactional(readOnly=true)
    public List<Cuenta> findByAll() {
        return (List<Cuenta>) cuentaDao.findAll();
    }

}