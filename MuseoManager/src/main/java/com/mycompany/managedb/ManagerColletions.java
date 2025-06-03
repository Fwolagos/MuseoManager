/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managedb;
import com.mycompany.museomanager.database.MmColecciones;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author ANTONY JOSUE
 */
public class ManagerColletions {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("user_management");

    public void add(MmColecciones coleccion) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(coleccion);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public MmColecciones search(BigDecimal id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(MmColecciones.class, id);
        } finally {
            em.close();
        }
    }

    public List<MmColecciones> read() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM MmColecciones c", MmColecciones.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(MmColecciones coleccion) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(coleccion);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(BigDecimal id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            MmColecciones coleccion = search(id);
            if (coleccion != null) {
                coleccion = em.merge(coleccion); // Asegura que esté en el contexto de persistencia
                em.remove(coleccion);
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
