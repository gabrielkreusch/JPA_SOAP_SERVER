/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Contato;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gabriel P Kreusch
 */
public class DAOContato {

    public static boolean create(Contato contato) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(contato);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }

    public static boolean update(Contato contato) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(contato);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }

        return true;
    }

    public static boolean delete(Long idcontato) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Contato contato = em.find(Contato.class, idcontato);
            em.remove(contato);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }

        return true;
    }

    public static Contato getByID(Long idcontato) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
        return em.find(Contato.class, idcontato);
    }

    public static List<Contato> getByName(String nome) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Contato> tq = em.createQuery("SELECT c FROM Contato c WHERE c.nome = :nome", Contato.class);
        tq.setParameter("nome", nome);

        return tq.getResultList();
    }

    public static List<Contato> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Contato> tq = em.createQuery("SELECT c FROM Contato c", Contato.class);

        return tq.getResultList();
    }
}
