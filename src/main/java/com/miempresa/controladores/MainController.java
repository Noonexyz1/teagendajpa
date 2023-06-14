
package com.miempresa.controladores;

import com.miempresa.bean.BeanContacto;
import com.miempresa.entidades.Contacto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //editar();
        eliminar();
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    public void eliminar(){
        BeanContacto dao = new BeanContacto();
        dao.eliminar(4);
    }
    
    private void editar(){
        BeanContacto dao = new BeanContacto();
        Contacto c =  dao.buscar(3);
        c.setNombre("Zacarias Plata");
        c.setTelefono("88888888");
        
        dao.editar(c);
        
    }
    
    public void nuevo(){
        Contacto c = new Contacto();
        c.setNombre("Bruno Diaz");
        c.setTelefono("2222");
        c.setCorreo("bruno@mail.com");

        BeanContacto dao = new BeanContacto();
        dao.insertar(c);
    }
    
    public void mostrar(){
        BeanContacto dao = new BeanContacto();
        List<Contacto> lista = dao.listarTodos();
        for (Contacto item : lista) {
            System.out.println("------------------");
            System.out.println("Nombre: " + item.getNombre());
            System.out.println("Telefono: " + item.getTelefono());
            System.out.println("Correo: " + item.getCorreo());
        }
    }

    
}
