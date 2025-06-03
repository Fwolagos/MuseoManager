/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managedb;
import com.mycompany.museomanager.database.MmVentaDeEntradas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author ANTONY JOSUE
 */
public class ManageSellTickets {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("user_management");

    public void add(MmVentaDeEntradas venta) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(venta);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public MmVentaDeEntradas search(BigDecimal id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(MmVentaDeEntradas.class, id);
        } finally {
            em.close();
        }
    }

    public List<MmVentaDeEntradas> read() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT v FROM MmVentaDeEntradas v", MmVentaDeEntradas.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(MmVentaDeEntradas venta) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(venta);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(BigDecimal id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            MmVentaDeEntradas venta = search(id);
            if (venta != null) {
                venta = em.merge(venta); // Asegura que esté gestionada
                em.remove(venta);
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
