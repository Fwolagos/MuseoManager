/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managedb;
import com.mycompany.museomanager.database.MmSalas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author ANTONY JOSUE
 */
public class ManageRooms {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("user_management");

	public void add(MmSalas sala) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(sala);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public MmSalas search(BigDecimal id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(MmSalas.class, id);
		} finally {
			em.close();
		}
	}

	public List<MmSalas> read() {
		EntityManager em = emf.createEntityManager();
		try {
			return em.createQuery("SELECT s FROM MmSalas s", MmSalas.class).getResultList();
		} finally {
			em.close();
		}
	}

	public void update(MmSalas sala) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(sala);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public void delete(BigDecimal id) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			MmSalas sala = search(id);
			if (sala != null) {
				sala = em.merge(sala); // Asegura que esté en el contexto de persistencia
				em.remove(sala);
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
