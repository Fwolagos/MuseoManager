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

import com.mycompany.museomanager.database.MmTarjetaYComisiones;
/**
 *
 * @author ANTONY JOSUE
 */
public class ManageCardAndCommissions {
     private EntityManagerFactory emf = Persistence.createEntityManagerFactory("UPMuseumManager");

    public void add(MmTarjetaYComisiones tarjeta) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(tarjeta);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public MmTarjetaYComisiones search(BigDecimal id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(MmTarjetaYComisiones.class, id);
        } finally {
            em.close();
        }
    }

    public List<MmTarjetaYComisiones> read() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT t FROM MmTarjetaYComisiones t", MmTarjetaYComisiones.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(MmTarjetaYComisiones tarjeta) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(tarjeta);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(BigDecimal id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            MmTarjetaYComisiones tarjeta = search(id);
            if (tarjeta != null) {
                tarjeta = em.merge(tarjeta); // Asegura que esté gestionada
                em.remove(tarjeta);
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
