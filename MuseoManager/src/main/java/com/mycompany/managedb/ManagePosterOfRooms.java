/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.managedb;
import com.mycompany.museomanager.database.MmAficheDeSalas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author ANTONY JOSUE
 */
public class ManagePosterOfRooms {
    	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("user_management");

	public void add(MmAficheDeSalas afiche) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(afiche);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public MmAficheDeSalas search(BigDecimal id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(MmAficheDeSalas.class, id);
		} finally {
			em.close();
		}
	}

	public List<MmAficheDeSalas> read() {
		EntityManager em = emf.createEntityManager();
		List<MmAficheDeSalas> afiches;
		try {
			afiches = em.createQuery("SELECT a FROM MmAficheDeSalas a", MmAficheDeSalas.class).getResultList();
			return afiches;
		} finally {
			em.close();
		}
	}

	public void update(MmAficheDeSalas afiche) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(afiche);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public void delete(BigDecimal id) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			MmAficheDeSalas afiche = search(id);
			if (afiche != null) {
				afiche = em.merge(afiche); // Asegura que esté en el contexto
				em.remove(afiche);
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
