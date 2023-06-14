
package com.miempresa.bean;

import com.miempresa.dao.ContactosJpaController;
import com.miempresa.dao.exceptions.NonexistentEntityException;
import com.miempresa.entidades.Contacto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanContacto {
    private EntityManagerFactory emf;
    private ContactosJpaController daoContacto;

    public BeanContacto() {
        emf = Persistence.createEntityManagerFactory("Unidadpersistencia");
        daoContacto = new ContactosJpaController(emf);
    }
    
    public List<Contacto> listarTodos(){
        return daoContacto.findContactosEntities();
    }
    
    public void insertar(Contacto c){
        daoContacto.create(c);
    }
    
    public void editar(Contacto c){
        try {
            daoContacto.edit(c);
        } catch (Exception ex) {
            Logger.getLogger(BeanContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(Integer id){
        try {
            daoContacto.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Contacto buscar(Integer id){
        Contacto c = new Contacto();
        c = daoContacto.findContactos(id);
        return  c;
    }
    
}
