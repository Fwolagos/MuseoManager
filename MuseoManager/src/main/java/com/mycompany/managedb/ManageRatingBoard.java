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

import com.mycompany.museomanager.database.MmTablaDeValoraciones;
/**
 *
 * @author ANTONY JOSUE
 */
public class ManageRatingBoard {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("UPMuseumManager");

    public void add(MmTablaDeValoraciones valoracion) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(valoracion);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public MmTablaDeValoraciones search(BigDecimal id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(MmTablaDeValoraciones.class, id);
        } finally {
            em.close();
        }
    }

    public List<MmTablaDeValoraciones> read() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT v FROM MmTablaDeValoraciones v", MmTablaDeValoraciones.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(MmTablaDeValoraciones valoracion) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(valoracion);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(BigDecimal id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            MmTablaDeValoraciones valoracion = search(id);
            if (valoracion != null) {
                valoracion = em.merge(valoracion); // Asegura que esté gestionada
                em.remove(valoracion);
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
