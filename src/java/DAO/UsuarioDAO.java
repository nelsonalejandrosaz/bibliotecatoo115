/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Usuario;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nelson Alejandro Saz <nelsonalejandrosaz@gmail.com>
 */
public class UsuarioDAO {
    
        public List<Usuario> getAll(){
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            usuarios = session.createCriteria(Usuario.class).list();
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return usuarios;
    }
    
    public Usuario getByID(int id){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Usuario usuario = new Usuario();
        try {
            Transaction transaction = session.beginTransaction();
            usuario = (Usuario) session.get(Usuario.class,BigDecimal.valueOf(id));
//            String queryString = "from Subcategoria where idSubcategoria = :id ";
//            Query query = session.createQuery(queryString);
//            query.setInteger("id", id);
//            subcategoria = (Subcategoria) query.uniqueResult();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return usuario;
    }
    
    public void update(Usuario usuario) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.update(usuario);
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
    public void add(Usuario usuario) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
//            Identificacion del ultimo ID para asignarlo a la clase            
            List<Usuario> usuarios = new ArrayList<Usuario>();
            int id = 1;
            usuarios = getAll();
            for (int i = 0; i < usuarios.size(); i++) {
                if (id < Integer.parseInt(usuarios.get(i).getIdusuario().toString())) {
                    id = Integer.parseInt(usuarios.get(i).getIdusuario().toString());
                }
            }
//            Fin de metodo para el id
            usuario.setIdusuario(BigDecimal.valueOf(id + 1));
            session.save(usuario);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
    public void delete(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Usuario usuario = getByID(id);
        try {
            Transaction transaction = session.beginTransaction();
            session.delete(usuario);
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
}
