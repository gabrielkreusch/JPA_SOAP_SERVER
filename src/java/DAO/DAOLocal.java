/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Local;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gabriel P Kreusch
 */
public class DAOLocal {

    public static boolean create(Local local) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
    
        try {
            em.persist(local);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
      
        return true;
    }
    
    public static boolean update(Local local) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
      
        try {
            em.getTransaction().begin();
            em.merge(local);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
      
        return true;
    }

    public static boolean delete(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
      
        try {
            em.getTransaction().begin();
            Local local = em.find(Local.class, id);
            em.remove(local);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
      
        return true;
    }
    
    public static Local getByID(Long idlocal) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
 
        return em.find(Local.class, idlocal);
    }

    public static List<Local> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Local> tq = em.createQuery("SELECT c FROM Local c", Local.class);
     
        return tq.getResultList();
    }
}