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
@Table(name = "MM_PRECIO_DE_ENTRADAS")
@NamedQueries({
    @NamedQuery(name = "MmPrecioDeEntradas.findAll", query = "SELECT m FROM MmPrecioDeEntradas m"),
    @NamedQuery(name = "MmPrecioDeEntradas.findById", query = "SELECT m FROM MmPrecioDeEntradas m WHERE m.id = :id"),
    @NamedQuery(name = "MmPrecioDeEntradas.findByCostoLunVier", query = "SELECT m FROM MmPrecioDeEntradas m WHERE m.costoLunVier = :costoLunVier"),
    @NamedQuery(name = "MmPrecioDeEntradas.findByCostoSabDom", query = "SELECT m FROM MmPrecioDeEntradas m WHERE m.costoSabDom = :costoSabDom")})
public class MmPrecioDeEntradas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mm_precio_de_entradas_gen")
    @SequenceGenerator(name = "mm_precio_de_entradas_gen", sequenceName = "SEQ_MM_PRECIO_DE_ENTRADAS", allocationSize = 1)

    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "COSTO_LUN_VIER")
    private BigInteger costoLunVier;
    @Column(name = "COSTO_SAB_DOM")
    private BigInteger costoSabDom;
    @JoinColumn(name = "ID_MUSEO", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MmMuseos idMuseo;

    public MmPrecioDeEntradas() {
    }

    public MmPrecioDeEntradas(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getCostoLunVier() {
        return costoLunVier;
    }

    public void setCostoLunVier(BigInteger costoLunVier) {
        this.costoLunVier = costoLunVier;
    }

    public BigInteger getCostoSabDom() {
        return costoSabDom;
    }

    public void setCostoSabDom(BigInteger costoSabDom) {
        this.costoSabDom = costoSabDom;
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
        if (!(object instanceof MmPrecioDeEntradas)) {
            return false;
        }
        MmPrecioDeEntradas other = (MmPrecioDeEntradas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.museomanager.database.MmPrecioDeEntradas[ id=" + id + " ]";
    }

}
