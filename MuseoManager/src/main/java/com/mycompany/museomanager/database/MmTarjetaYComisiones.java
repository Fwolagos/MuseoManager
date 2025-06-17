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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ANTONY JOSUE
 */
@Entity
@Table(name = "MM_TARJETA_Y_COMISIONES")
@NamedQueries({
    @NamedQuery(name = "MmTarjetaYComisiones.findAll", query = "SELECT m FROM MmTarjetaYComisiones m"),
    @NamedQuery(name = "MmTarjetaYComisiones.findById", query = "SELECT m FROM MmTarjetaYComisiones m WHERE m.id = :id"),
    @NamedQuery(name = "MmTarjetaYComisiones.findByTipoDeTarjeta", query = "SELECT m FROM MmTarjetaYComisiones m WHERE m.tipoDeTarjeta = :tipoDeTarjeta"),
    @NamedQuery(name = "MmTarjetaYComisiones.findByComision", query = "SELECT m FROM MmTarjetaYComisiones m WHERE m.comision = :comision")})
public class MmTarjetaYComisiones implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mm_tarjeta_y_comisiones_gen")
    @SequenceGenerator(name = "mm_tarjeta_y_comisiones_gen", sequenceName = "SEQ_MM_TARJETA_Y_COMISIONES", allocationSize = 1)

    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TIPO_DE_TARJETA")
    private String tipoDeTarjeta;
    @Column(name = "COMISION")
    private BigInteger comision;
    @JoinColumn(name = "ID_MUSEO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private MmMuseos idMuseo;

    public MmTarjetaYComisiones() {
    }

    public MmTarjetaYComisiones(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTipoDeTarjeta() {
        return tipoDeTarjeta;
    }

    public void setTipoDeTarjeta(String tipoDeTarjeta) {
        this.tipoDeTarjeta = tipoDeTarjeta;
    }

    public BigInteger getComision() {
        return comision;
    }

    public void setComision(BigInteger comision) {
        this.comision = comision;
    }

    public MmMuseos getIdMuseo() {
        return idMuseo;
    }

    public void setIdMuseo(MmMuseos idMuseo) {
        this.idMuseo = idMuseo;
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
        if (!(object instanceof MmTarjetaYComisiones)) {
            return false;
        }
        MmTarjetaYComisiones other = (MmTarjetaYComisiones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.museomanager.database.MmTarjetaYComisiones[ id=" + id + " ]";
    }

}
