/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Subcategoria;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author nelso
 */
public class SubcategoriaDAO {

    public List<Subcategoria> getAll() {
        List<Subcategoria> subCategorias = new ArrayList<Subcategoria>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            subCategorias = session.createCriteria(Subcategoria.class).list();
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return subCategorias;
    }

    public Subcategoria getbyID(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Subcategoria subcategoria = new Subcategoria();
        try {
            Transaction transaction = session.beginTransaction();
            subcategoria = (Subcategoria) session.get(Subcategoria.class, BigDecimal.valueOf(id));
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
        return subcategoria;
    }

    public void add(Subcategoria subcategoria) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
//            Identificacion del ultimo ID para asignarlo a la clase            
            List<Subcategoria> subcategorias = new ArrayList<Subcategoria>();
            int id = 1;
            subcategorias = getAll();
            for (int i = 0; i < subcategorias.size(); i++) {
                if (id < Integer.parseInt(subcategorias.get(i).getIdsubcategoria().toString())) {
                    id = Integer.parseInt(subcategorias.get(i).getIdsubcategoria().toString());
                }
            }
//            Fin de metodo para el id
            subcategoria.setIdsubcategoria(BigDecimal.valueOf(id + 1));
            session.save(subcategoria);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Subcategoria subcategoria = getbyID(id);
        try {
            Transaction transaction = session.beginTransaction();
            session.delete(subcategoria);
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void update(Subcategoria subcategoria) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.update(subcategoria);
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Subcategoria> getByCategoria(int id ) {
        List<Subcategoria> subCategorias = new ArrayList<Subcategoria>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            String hql = "from Subcategoria where idcategoria = :idcategoria";
            Query query = session.createQuery(hql);
            query.setBigDecimal("idcategoria", BigDecimal.valueOf(id));
            subCategorias= query.list();
            transaction.commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return subCategorias;
    }

}
