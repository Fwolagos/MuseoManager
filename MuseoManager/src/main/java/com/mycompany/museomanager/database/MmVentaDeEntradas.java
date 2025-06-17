/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.museomanager.database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ANTONY JOSUE
 */
@Entity
@Table(name = "MM_VENTA_DE_ENTRADAS")
@NamedQueries({
    @NamedQuery(name = "MmVentaDeEntradas.findAll", query = "SELECT m FROM MmVentaDeEntradas m"),
    @NamedQuery(name = "MmVentaDeEntradas.findById", query = "SELECT m FROM MmVentaDeEntradas m WHERE m.id = :id"),
    @NamedQuery(name = "MmVentaDeEntradas.findByFecha", query = "SELECT m FROM MmVentaDeEntradas m WHERE m.fecha = :fecha"),
    @NamedQuery(name = "MmVentaDeEntradas.findByNombreDelVisitante", query = "SELECT m FROM MmVentaDeEntradas m WHERE m.nombreDelVisitante = :nombreDelVisitante"),
    @NamedQuery(name = "MmVentaDeEntradas.findByComisionCobrada", query = "SELECT m FROM MmVentaDeEntradas m WHERE m.comisionCobrada = :comisionCobrada"),
    @NamedQuery(name = "MmVentaDeEntradas.findByVigencia", query = "SELECT m FROM MmVentaDeEntradas m WHERE m.vigencia = :vigencia")})
public class MmVentaDeEntradas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mm_venta_de_entradas_gen")
    @SequenceGenerator(name = "mm_venta_de_entradas_gen", sequenceName = "SEQ_MM_VENTA_DE_ENTRADAS", allocationSize = 1)

    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "NOMBRE_DEL_VISITANTE")
    private String nombreDelVisitante;
    @Column(name = "COMISION_COBRADA")
    private BigInteger comisionCobrada;
    @Column(name = "VIGENCIA")
    private String vigencia;
    @JoinColumn(name = "ID_MUSEO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private MmMuseos idMuseo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVenta", fetch = FetchType.EAGER)
    private Collection<MmVentasYSalas> mmVentasYSalasCollection;

    public MmVentaDeEntradas() {
    }

    public MmVentaDeEntradas(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreDelVisitante() {
        return nombreDelVisitante;
    }

    public void setNombreDelVisitante(String nombreDelVisitante) {
        this.nombreDelVisitante = nombreDelVisitante;
    }

    public BigInteger getComisionCobrada() {
        return comisionCobrada;
    }

    public void setComisionCobrada(BigInteger comisionCobrada) {
        this.comisionCobrada = comisionCobrada;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public MmMuseos getIdMuseo() {
        return idMuseo;
    }

    public void setIdMuseo(MmMuseos idMuseo) {
        this.idMuseo = idMuseo;
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
        if (!(object instanceof MmVentaDeEntradas)) {
            return false;
        }
        MmVentaDeEntradas other = (MmVentaDeEntradas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.museomanager.database.MmVentaDeEntradas[ id=" + id + " ]";
    }

}
