/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.museomanager.database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.persistence.Table;

/**
 *
 * @author Estudiante
 */
@Entity
@Table(name = "MM_TABLA_DE_VALORACIONES")
@NamedQueries({
    @NamedQuery(name = "MmTablaDeValoraciones.findAll", query = "SELECT m FROM MmTablaDeValoraciones m"),
    @NamedQuery(name = "MmTablaDeValoraciones.findById", query = "SELECT m FROM MmTablaDeValoraciones m WHERE m.id = :id"),
    @NamedQuery(name = "MmTablaDeValoraciones.findByCalificacion", query = "SELECT m FROM MmTablaDeValoraciones m WHERE m.calificacion = :calificacion"),
    @NamedQuery(name = "MmTablaDeValoraciones.findByObservaciones", query = "SELECT m FROM MmTablaDeValoraciones m WHERE m.observaciones = :observaciones")})
public class MmTablaDeValoraciones implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CALIFICACION")
    private BigInteger calificacion;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @JoinColumn(name = "ID_SALA", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MmSalas idSala;

    public MmTablaDeValoraciones() {
    }

    public MmTablaDeValoraciones(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigInteger calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
        if (!(object instanceof MmTablaDeValoraciones)) {
            return false;
        }
        MmTablaDeValoraciones other = (MmTablaDeValoraciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.museomanager.database.MmTablaDeValoraciones[ id=" + id + " ]";
    }
    
}
