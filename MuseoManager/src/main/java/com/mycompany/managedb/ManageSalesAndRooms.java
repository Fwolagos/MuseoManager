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

import com.mycompany.museomanager.database.MmVentasYSalas;

/**
 *
 * @author ANTONY JOSUE
 */
public class ManageSalesAndRooms {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("UPMuseumManager");

    public void add(MmVentasYSalas entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public MmVentasYSalas search(BigDecimal id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(MmVentasYSalas.class, id);
        } finally {
            em.close();
        }
    }

    public List<MmVentasYSalas> read() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT v FROM MmVentasYSalas v", MmVentasYSalas.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(MmVentasYSalas entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(BigDecimal id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            MmVentasYSalas entity = search(id);
            if (entity != null) {
                entity = em.merge(entity); // Asegura que la entidad esté gestionada
                em.remove(entity);
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
