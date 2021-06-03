/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Participante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gabriel P Kreusch
 */
public class DAOParticipante {

    public static boolean create(Participante participante) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(participante);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }

    public static boolean update(Participante participante) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(participante);
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
            Participante participante = em.find(Participante.class, id);
            em.remove(participante);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }
    
    public static Participante getByID(Long nId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
        return em.find(Participante.class, nId);
    }

    public static List<Participante> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV03PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Participante> tq = em.createQuery("SELECT c FROM Participante c", Participante.class);
        return tq.getResultList();
    }
}