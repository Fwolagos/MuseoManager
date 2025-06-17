/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.museomanager.database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ANTONY JOSUE
 */
@Entity
@Table(name = "MM_COLECCIONES")
@NamedQueries({
    @NamedQuery(name = "MmColecciones.findAll", query = "SELECT m FROM MmColecciones m"),
    @NamedQuery(name = "MmColecciones.findById", query = "SELECT m FROM MmColecciones m WHERE m.id = :id"),
    @NamedQuery(name = "MmColecciones.findByNombreDeColeccion", query = "SELECT m FROM MmColecciones m WHERE m.nombreDeColeccion = :nombreDeColeccion"),
    @NamedQuery(name = "MmColecciones.findBySiglo", query = "SELECT m FROM MmColecciones m WHERE m.siglo = :siglo"),
    @NamedQuery(name = "MmColecciones.findByDescripcion", query = "SELECT m FROM MmColecciones m WHERE m.descripcion = :descripcion")})
public class MmColecciones implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mm_colecciones_gen")
    @SequenceGenerator(name = "mm_colecciones_gen", sequenceName = "SEQ_MM_COLECCIONES", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NOMBRE_DE_COLECCION")
    private String nombreDeColeccion;
    @Column(name = "SIGLO")
    private BigInteger siglo;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_SALA", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private MmSalas idSala;
    @OneToMany(mappedBy = "idColeccion", fetch = FetchType.EAGER)
    private Collection<MmEspecies> mmEspeciesCollection;

    public MmColecciones() {
    }

    public MmColecciones(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombreDeColeccion() {
        return nombreDeColeccion;
    }

    public void setNombreDeColeccion(String nombreDeColeccion) {
        this.nombreDeColeccion = nombreDeColeccion;
    }

    public BigInteger getSiglo() {
        return siglo;
    }

    public void setSiglo(BigInteger siglo) {
        this.siglo = siglo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public MmSalas getIdSala() {
        return idSala;
    }

    public void setIdSala(MmSalas idSala) {
        this.idSala = idSala;
    }

    public Collection<MmEspecies> getMmEspeciesCollection() {
        return mmEspeciesCollection;
    }

    public void setMmEspeciesCollection(Collection<MmEspecies> mmEspeciesCollection) {
        this.mmEspeciesCollection = mmEspeciesCollection;
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
        if (!(object instanceof MmColecciones)) {
            return false;
        }
        MmColecciones other = (MmColecciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.museomanager.database.MmColecciones[ id=" + id + " ]";
    }

}
