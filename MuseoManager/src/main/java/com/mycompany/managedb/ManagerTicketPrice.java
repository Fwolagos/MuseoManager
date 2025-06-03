/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managedb;
import com.mycompany.museomanager.database.MmPrecioDeEntradas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author ANTONY JOSUE
 */
public class ManagerTicketPrice {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("user_management");

    public void add(MmPrecioDeEntradas precio) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(precio);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public MmPrecioDeEntradas search(BigDecimal id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(MmPrecioDeEntradas.class, id);
        } finally {
            em.close();
        }
    }

    public List<MmPrecioDeEntradas> read() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM MmPrecioDeEntradas p", MmPrecioDeEntradas.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(MmPrecioDeEntradas precio) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(precio);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(BigDecimal id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            MmPrecioDeEntradas precio = search(id);
            if (precio != null) {
                precio = em.merge(precio); // Asegura que esté gestionada
                em.remove(precio);
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
