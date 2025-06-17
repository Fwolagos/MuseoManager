/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.museomanager.database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "MM_SALAS")
@NamedQueries({
    @NamedQuery(name = "MmSalas.findAll", query = "SELECT m FROM MmSalas m"),
    @NamedQuery(name = "MmSalas.findById", query = "SELECT m FROM MmSalas m WHERE m.id = :id"),
    @NamedQuery(name = "MmSalas.findByNombreDeSala", query = "SELECT m FROM MmSalas m WHERE m.nombreDeSala = :nombreDeSala"),
    @NamedQuery(name = "MmSalas.findByDescripcion", query = "SELECT m FROM MmSalas m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "MmSalas.findByTipoDeSala", query = "SELECT m FROM MmSalas m WHERE m.tipoDeSala = :tipoDeSala")})
public class MmSalas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mm_salas_gen")
    @SequenceGenerator(name = "mm_salas_gen", sequenceName = "SEQ_MM_SALAS", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NOMBRE_DE_SALA")
    private String nombreDeSala;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "TIPO_DE_SALA")
    private String tipoDeSala;
    @OneToMany(mappedBy = "idSala", fetch = FetchType.EAGER)
    private Collection<MmTematica> mmTematicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSala", fetch = FetchType.EAGER)
    private Collection<MmTablaDeValoraciones> mmTablaDeValoracionesCollection;
    @OneToMany(mappedBy = "idSala", fetch = FetchType.EAGER)
    private Collection<MmColecciones> mmColeccionesCollection;
    @JoinColumn(name = "ID_MUSEO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private MmMuseos idMuseo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSala", fetch = FetchType.EAGER)
    private Collection<MmAficheDeSalas> mmAficheDeSalasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSala", fetch = FetchType.EAGER)
    private Collection<MmVentasYSalas> mmVentasYSalasCollection;

    public MmSalas() {
    }

    public MmSalas(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombreDeSala() {
        return nombreDeSala;
    }

    public void setNombreDeSala(String nombreDeSala) {
        this.nombreDeSala = nombreDeSala;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoDeSala() {
        return tipoDeSala;
    }

    public void setTipoDeSala(String tipoDeSala) {
        this.tipoDeSala = tipoDeSala;
    }

    public Collection<MmTematica> getMmTematicaCollection() {
        return mmTematicaCollection;
    }

    public void setMmTematicaCollection(Collection<MmTematica> mmTematicaCollection) {
        this.mmTematicaCollection = mmTematicaCollection;
    }

    public Collection<MmTablaDeValoraciones> getMmTablaDeValoracionesCollection() {
        return mmTablaDeValoracionesCollection;
    }

    public void setMmTablaDeValoracionesCollection(Collection<MmTablaDeValoraciones> mmTablaDeValoracionesCollection) {
        this.mmTablaDeValoracionesCollection = mmTablaDeValoracionesCollection;
    }

    public Collection<MmColecciones> getMmColeccionesCollection() {
        return mmColeccionesCollection;
    }

    public void setMmColeccionesCollection(Collection<MmColecciones> mmColeccionesCollection) {
        this.mmColeccionesCollection = mmColeccionesCollection;
    }

    public MmMuseos getIdMuseo() {
        return idMuseo;
    }

    public void setIdMuseo(MmMuseos idMuseo) {
        this.idMuseo = idMuseo;
    }

    public Collection<MmAficheDeSalas> getMmAficheDeSalasCollection() {
        return mmAficheDeSalasCollection;
    }

    public void setMmAficheDeSalasCollection(Collection<MmAficheDeSalas> mmAficheDeSalasCollection) {
        this.mmAficheDeSalasCollection = mmAficheDeSalasCollection;
    }

    public Collection<MmVentasYSalas> getMmVentasYSalasCollection() {
        return mmVentasYSalasCollection;
    }

    public void setMmVentasYSalasCollection(Collection<MmVentasYSalas> mmVentasYSalasCollection) {
        this.mmVentasYSalasCollection = mmVentasYSalasCollection;
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
        if (!(object instanceof MmSalas)) {
            return false;
        }
        MmSalas other = (MmSalas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.museomanager.database.MmSalas[ id=" + id + " ]";
    }

}
