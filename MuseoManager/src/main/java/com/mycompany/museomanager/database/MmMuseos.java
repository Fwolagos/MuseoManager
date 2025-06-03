/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.museomanager.database;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Estudiante
 */
@Entity
@Table(name = "MM_MUSEOS")
@NamedQueries({
    @NamedQuery(name = "MmMuseos.findAll", query = "SELECT m FROM MmMuseos m"),
    @NamedQuery(name = "MmMuseos.findById", query = "SELECT m FROM MmMuseos m WHERE m.id = :id"),
    @NamedQuery(name = "MmMuseos.findByNombreDelMuseo", query = "SELECT m FROM MmMuseos m WHERE m.nombreDelMuseo = :nombreDelMuseo"),
    @NamedQuery(name = "MmMuseos.findByTipoDeMuseo", query = "SELECT m FROM MmMuseos m WHERE m.tipoDeMuseo = :tipoDeMuseo"),
    @NamedQuery(name = "MmMuseos.findByUbicacion", query = "SELECT m FROM MmMuseos m WHERE m.ubicacion = :ubicacion"),
    @NamedQuery(name = "MmMuseos.findByUrlDelSitioWeb", query = "SELECT m FROM MmMuseos m WHERE m.urlDelSitioWeb = :urlDelSitioWeb"),
    @NamedQuery(name = "MmMuseos.findByFechaDeFundacion", query = "SELECT m FROM MmMuseos m WHERE m.fechaDeFundacion = :fechaDeFundacion")})
public class MmMuseos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NOMBRE_DEL_MUSEO")
    private String nombreDelMuseo;
    @Column(name = "TIPO_DE_MUSEO")
    private String tipoDeMuseo;
    @Column(name = "UBICACION")
    private String ubicacion;
    @Column(name = "URL_DEL_SITIO_WEB")
    private String urlDelSitioWeb;
    @Column(name = "FECHA_DE_FUNDACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeFundacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMuseo", fetch = FetchType.LAZY)
    private Collection<MmPrecioDeEntradas> mmPrecioDeEntradasCollection;
    @OneToMany(mappedBy = "idMuseo", fetch = FetchType.LAZY)
    private Collection<MmSalas> mmSalasCollection;
    @OneToMany(mappedBy = "idMuseo", fetch = FetchType.LAZY)
    private Collection<MmVentaDeEntradas> mmVentaDeEntradasCollection;
    @OneToMany(mappedBy = "idMuseo", fetch = FetchType.LAZY)
    private Collection<MmTarjetaYComisiones> mmTarjetaYComisionesCollection;

    public MmMuseos() {
    }

    public MmMuseos(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombreDelMuseo() {
        return nombreDelMuseo;
    }

    public void setNombreDelMuseo(String nombreDelMuseo) {
        this.nombreDelMuseo = nombreDelMuseo;
    }

    public String getTipoDeMuseo() {
        return tipoDeMuseo;
    }

    public void setTipoDeMuseo(String tipoDeMuseo) {
        this.tipoDeMuseo = tipoDeMuseo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUrlDelSitioWeb() {
        return urlDelSitioWeb;
    }

    public void setUrlDelSitioWeb(String urlDelSitioWeb) {
        this.urlDelSitioWeb = urlDelSitioWeb;
    }

    public Date getFechaDeFundacion() {
        return fechaDeFundacion;
    }

    public void setFechaDeFundacion(Date fechaDeFundacion) {
        this.fechaDeFundacion = fechaDeFundacion;
    }

    public Collection<MmPrecioDeEntradas> getMmPrecioDeEntradasCollection() {
        return mmPrecioDeEntradasCollection;
    }

    public void setMmPrecioDeEntradasCollection(Collection<MmPrecioDeEntradas> mmPrecioDeEntradasCollection) {
        this.mmPrecioDeEntradasCollection = mmPrecioDeEntradasCollection;
    }

    public Collection<MmSalas> getMmSalasCollection() {
        return mmSalasCollection;
    }

    public void setMmSalasCollection(Collection<MmSalas> mmSalasCollection) {
        this.mmSalasCollection = mmSalasCollection;
    }

    public Collection<MmVentaDeEntradas> getMmVentaDeEntradasCollection() {
        return mmVentaDeEntradasCollection;
    }

    public void setMmVentaDeEntradasCollection(Collection<MmVentaDeEntradas> mmVentaDeEntradasCollection) {
        this.mmVentaDeEntradasCollection = mmVentaDeEntradasCollection;
    }

    public Collection<MmTarjetaYComisiones> getMmTarjetaYComisionesCollection() {
        return mmTarjetaYComisionesCollection;
    }

    public void setMmTarjetaYComisionesCollection(Collection<MmTarjetaYComisiones> mmTarjetaYComisionesCollection) {
        this.mmTarjetaYComisionesCollection = mmTarjetaYComisionesCollection;
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
        if (!(object instanceof MmMuseos)) {
            return false;
        }
        MmMuseos other = (MmMuseos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.museomanager.database.MmMuseos[ id=" + id + " ]";
    }
    
}
