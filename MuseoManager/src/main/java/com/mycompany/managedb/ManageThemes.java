/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managedb;
import com.mycompany.museomanager.database.MmTematica;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author ANTONY JOSUE
 */
public class ManageThemes {
     private EntityManagerFactory emf = Persistence.createEntityManagerFactory("user_management");

    public void add(MmTematica tematica) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(tematica);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public MmTematica search(BigDecimal id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(MmTematica.class, id);
        } finally {
            em.close();
        }
    }

    public List<MmTematica> read() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT t FROM MmTematica t", MmTematica.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(MmTematica tematica) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(tematica);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(BigDecimal id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            MmTematica tematica = search(id);
            if (tematica != null) {
                tematica = em.merge(tematica); // Asegura que esté gestionada
                em.remove(tematica);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }
}
