/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managedb;
import com.mycompany.museomanager.database.MmEspecies;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author ANTONY JOSUE
 */
public class ManageSpecies {
     private EntityManagerFactory emf = Persistence.createEntityManagerFactory("user_management");

    public void add(MmEspecies especie) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(especie);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public MmEspecies search(BigDecimal id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(MmEspecies.class, id);
        } finally {
            em.close();
        }
    }

    public List<MmEspecies> read() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT e FROM MmEspecies e", MmEspecies.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(MmEspecies especie) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(especie);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(BigDecimal id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            MmEspecies especie = search(id);
            if (especie != null) {
                especie = em.merge(especie); // Asegura que esté gestionada
                em.remove(especie);
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
