/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Recurso;
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
public class RecursoDAO {
    
    public List<Recurso> getAll(){
        List<Recurso> recursos = new ArrayList<Recurso>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            recursos = session.createCriteria(Recurso.class).list();
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return recursos;
    }
    
    public Recurso getByID(int id){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Recurso recurso = new Recurso();
        try {
            Transaction transaction = session.beginTransaction();
            recurso = (Recurso) session.get(Recurso.class,BigDecimal.valueOf(id));
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
        return recurso;
    }
    
}
