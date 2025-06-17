/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.museomanager.database;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ANTONY JOSUE
 */
@Entity
@Table(name = "MM_TEMATICA")
@NamedQueries({
    @NamedQuery(name = "MmTematica.findAll", query = "SELECT m FROM MmTematica m"),
    @NamedQuery(name = "MmTematica.findById", query = "SELECT m FROM MmTematica m WHERE m.id = :id"),
    @NamedQuery(name = "MmTematica.findByNombreDeLaTematica", query = "SELECT m FROM MmTematica m WHERE m.nombreDeLaTematica = :nombreDeLaTematica"),
    @NamedQuery(name = "MmTematica.findByCaracteristicas", query = "SELECT m FROM MmTematica m WHERE m.caracteristicas = :caracteristicas"),
    @NamedQuery(name = "MmTematica.findByEpoca", query = "SELECT m FROM MmTematica m WHERE m.epoca = :epoca")})
public class MmTematica implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mm_tematica_gen")
    @SequenceGenerator(name = "mm_tematica_gen", sequenceName = "SEQ_MM_TEMATICA", allocationSize = 1)

    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NOMBRE_DE_LA_TEMATICA")
    private String nombreDeLaTematica;
    @Column(name = "CARACTERISTICAS")
    private String caracteristicas;
    @Column(name = "EPOCA")
    private String epoca;
    @JoinColumn(name = "ID_SALA", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private MmSalas idSala;

    public MmTematica() {
    }

    public MmTematica(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombreDeLaTematica() {
        return nombreDeLaTematica;
    }

    public void setNombreDeLaTematica(String nombreDeLaTematica) {
        this.nombreDeLaTematica = nombreDeLaTematica;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getEpoca() {
        return epoca;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public MmSalas getIdSala() {
        return idSala;
    }

    public void setIdSala(MmSalas idSala) {
        this.idSala = idSala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MmTematica)) {
            return false;
        }
        MmTematica other = (MmTematica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.museomanager.database.MmTematica[ id=" + id + " ]";
    }

}
