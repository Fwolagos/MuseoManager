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
@Table(name = "MM_AFICHE_DE_SALAS")
@NamedQueries({
    @NamedQuery(name = "MmAficheDeSalas.findAll", query = "SELECT m FROM MmAficheDeSalas m"),
    @NamedQuery(name = "MmAficheDeSalas.findById", query = "SELECT m FROM MmAficheDeSalas m WHERE m.id = :id"),
    @NamedQuery(name = "MmAficheDeSalas.findByImg1", query = "SELECT m FROM MmAficheDeSalas m WHERE m.img1 = :img1"),
    @NamedQuery(name = "MmAficheDeSalas.findByImg2", query = "SELECT m FROM MmAficheDeSalas m WHERE m.img2 = :img2"),
    @NamedQuery(name = "MmAficheDeSalas.findByImg3", query = "SELECT m FROM MmAficheDeSalas m WHERE m.img3 = :img3"),
    @NamedQuery(name = "MmAficheDeSalas.findByValoracionPromedio", query = "SELECT m FROM MmAficheDeSalas m WHERE m.valoracionPromedio = :valoracionPromedio")})
public class MmAficheDeSalas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mm_afiche_de_salas_gen")
    @SequenceGenerator(name = "mm_afiche_de_salas_gen", sequenceName = "SEQ_MM_AFICHE_DE_SALAS", allocationSize = 1)

    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "IMG1")
    private String img1;
    @Column(name = "IMG2")
    private String img2;
    @Column(name = "IMG3")
    private String img3;
    @Column(name = "VALORACION_PROMEDIO")
    private BigInteger valoracionPromedio;
    @JoinColumn(name = "ID_SALA", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MmSalas idSala;

    public MmAficheDeSalas() {
    }

    public MmAficheDeSalas(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public BigInteger getValoracionPromedio() {
        return valoracionPromedio;
    }

    public void setValoracionPromedio(BigInteger valoracionPromedio) {
        this.valoracionPromedio = valoracionPromedio;
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
        if (!(object instanceof MmAficheDeSalas)) {
            return false;
        }
        MmAficheDeSalas other = (MmAficheDeSalas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.museomanager.database.MmAficheDeSalas[ id=" + id + " ]";
    }

}
