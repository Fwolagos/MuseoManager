/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.museomanager.database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ANTONY JOSUE
 */
@Entity
@Table(name = "MM_ESPECIES")
@NamedQueries({
    @NamedQuery(name = "MmEspecies.findAll", query = "SELECT m FROM MmEspecies m"),
    @NamedQuery(name = "MmEspecies.findById", query = "SELECT m FROM MmEspecies m WHERE m.id = :id"),
    @NamedQuery(name = "MmEspecies.findByNombreCientifico", query = "SELECT m FROM MmEspecies m WHERE m.nombreCientifico = :nombreCientifico"),
    @NamedQuery(name = "MmEspecies.findByNombreComun", query = "SELECT m FROM MmEspecies m WHERE m.nombreComun = :nombreComun"),
    @NamedQuery(name = "MmEspecies.findByFechaDeExtincion", query = "SELECT m FROM MmEspecies m WHERE m.fechaDeExtincion = :fechaDeExtincion"),
    @NamedQuery(name = "MmEspecies.findByEpoca", query = "SELECT m FROM MmEspecies m WHERE m.epoca = :epoca"),
    @NamedQuery(name = "MmEspecies.findByPeso", query = "SELECT m FROM MmEspecies m WHERE m.peso = :peso"),
    @NamedQuery(name = "MmEspecies.findByTama\u00f1o", query = "SELECT m FROM MmEspecies m WHERE m.tama\u00f1o = :tama\u00f1o"),
    @NamedQuery(name = "MmEspecies.findByCaracteristicas", query = "SELECT m FROM MmEspecies m WHERE m.caracteristicas = :caracteristicas")})
public class MmEspecies implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mm_especies_gen")
    @SequenceGenerator(name = "mm_especies_gen", sequenceName = "SEQ_MM_ESPECIES", allocationSize = 1)

    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NOMBRE_CIENTIFICO")
    private String nombreCientifico;
    @Column(name = "NOMBRE_COMUN")
    private String nombreComun;
    @Column(name = "FECHA_DE_EXTINCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeExtincion;
    @Column(name = "EPOCA")
    private String epoca;
    @Column(name = "PESO")
    private BigInteger peso;
    @Column(name = "TAMA\u00d1O")
    private BigInteger tamaño;
    @Column(name = "CARACTERISTICAS")
    private String caracteristicas;
    @JoinColumn(name = "ID_COLECCION", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private MmColecciones idColeccion;

    public MmEspecies() {
    }

    public MmEspecies(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public Date getFechaDeExtincion() {
        return fechaDeExtincion;
    }

    public void setFechaDeExtincion(Date fechaDeExtincion) {
        this.fechaDeExtincion = fechaDeExtincion;
    }

    public String getEpoca() {
        return epoca;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public BigInteger getPeso() {
        return peso;
    }

    public void setPeso(BigInteger peso) {
        this.peso = peso;
    }

    public BigInteger getTamaño() {
        return tamaño;
    }

    public void setTamaño(BigInteger tamaño) {
        this.tamaño = tamaño;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public MmColecciones getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(MmColecciones idColeccion) {
        this.idColeccion = idColeccion;
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
        if (!(object instanceof MmEspecies)) {
            return false;
        }
        MmEspecies other = (MmEspecies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.museomanager.database.MmEspecies[ id=" + id + " ]";
    }

}
