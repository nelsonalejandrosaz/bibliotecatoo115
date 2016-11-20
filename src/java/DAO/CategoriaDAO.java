/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Categoria;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author nelso
 */
public class CategoriaDAO {
    
    public List<Categoria> getAll() {
        List<Categoria> categorias = new ArrayList<Categoria>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            categorias = session.createCriteria(Categoria.class).list();
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } 
        return categorias;
    }
    
    public Categoria getbyID(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Categoria categoria = new Categoria();
        try {
            Transaction transaction = session.beginTransaction();
            categoria = (Categoria) session.get(Categoria.class,BigDecimal.valueOf(id));
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } 
        return categoria;
    }
    
    public void add(Categoria categoria) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {            
            Transaction transaction = session.beginTransaction();
//            Identificacion del ultimo ID para asignarlo a la clase            
            List<Categoria> categorias = new ArrayList<Categoria>();
            int id = 1;
            categorias = getAll();
            for (int i = 0; i < categorias.size(); i++) {
                if (id < Integer.parseInt(categorias.get(i).getIdcategoria().toString())) {
                    id = Integer.parseInt(categorias.get(i).getIdcategoria().toString());
                }
            }
//            Fin de metodo
            categoria.setIdcategoria(BigDecimal.valueOf(id + 1));
            session.save(categoria);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } 
    }
    
    public void delete(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Categoria categoria = getbyID(id);
        try {
            Transaction transaction = session.beginTransaction();
            session.delete(categoria);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } 
    }
    
    public void update(Categoria categoria) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.update(categoria);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } 
    }
    
}
