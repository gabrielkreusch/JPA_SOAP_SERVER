/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Compromisso;
import entities.Contato;
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
public class DAOCompromisso {

    public static boolean create(Compromisso compromisso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(compromisso);
            em.getTransaction().commit();
        } catch (Exception erro) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }

        return true;
    }

    public static boolean update(Compromisso compromisso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(compromisso);
            em.getTransaction().commit();
        } catch (Exception erro) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }

    public static boolean delete(Long idcompromisso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Compromisso compromisso = em.find(Compromisso.class, idcompromisso);
            em.remove(compromisso);
            em.getTransaction().commit();
        } catch (Exception erro) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }

        return true;
    }
    
    
    public static Compromisso getByID(Long idcompromisso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
        
        return em.find(Compromisso.class, idcompromisso);
    }

    public static List<Compromisso> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Compromisso> tq = em.createQuery("SELECT c FROM Compromisso c", Compromisso.class);
        
        return tq.getResultList();
    }
    
    public static List<Compromisso> getByLocal(Local local) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Compromisso> tq = em.createQuery("SELECT c FROM Compromisso c WHERE c.local = :local", Compromisso.class);
        tq.setParameter("local", local);
        
        return tq.getResultList();
    }
    
    public static List<Compromisso> getByContato(Contato contato) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Compromisso> tq = em.createQuery("SELECT c FROM Compromisso c INNER JOIN c.participantes p WHERE p.contato = :contato", Compromisso.class);
        tq.setParameter("contato", contato);
        
        return tq.getResultList();
    }
}