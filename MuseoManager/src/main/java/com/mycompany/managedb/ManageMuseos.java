/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.managedb;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mycompany.museomanager.database.MmMuseos;

/**
 *
 * @author ANTONY JOSUE
 */
public class ManageMuseos {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("UPMuseumManager");

	public void add(MmMuseos museo) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(museo);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public MmMuseos search(BigDecimal id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(MmMuseos.class, id);
		} finally {
			em.close();
		}
	}

	public List<MmMuseos> read() {
		EntityManager em = emf.createEntityManager();
		List<MmMuseos> museos;
		try {
			museos = em.createQuery("SELECT m FROM MmMuseos m", MmMuseos.class).getResultList();
			return museos;
		} finally {
			em.close();
		}
	}

	public void update(MmMuseos museo) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(museo);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public void delete(BigDecimal id) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			MmMuseos museo = search(id);
			if (museo != null) {
				museo = em.merge(museo); // Necesario para poder hacer remove
				em.remove(museo);
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
